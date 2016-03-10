package controllers;

import eu.hansolo.enzo.lcd.Lcd;
import eu.hansolo.enzo.lcd.LcdBuilder;
import eu.hansolo.medusa.Gauge;
import eu.hansolo.medusa.GaugeBuilder;
import eu.hansolo.medusa.Section;
import eu.hansolo.medusa.skins.SimpleSkin;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Oleg on 04.03.2016.
 */
public class HBox1Controller implements Initializable {

    @FXML
    private GridPane gridPaneHBox1;

    @FXML
    private ToggleButton button_pump_control;

    @FXML
    private ToggleButton deviceStateButton;

    private StatePump state;

    private enum StatePump {
        ON("ON", "1"),
        OFF("OFF", "0"),
        AUTO_ON("AUTO", "1"),
        AUTO_OFF("AUTO", "0");

        public String text;
        public String code;

        StatePump( String text, String code) {
            this.text = text;
            this.code = code;
        }

    }

    public void pumpSetOn() {
        state = StatePump.ON;
        button_pump_control.getStyleClass().set(1,"pump-button-on");
        button_pump_control.setText("ON");
        //  send();

    }

    public void pumpSetOff() {
        state = StatePump.OFF;
        button_pump_control.getStyleClass().set(1,"pump-button-off");
        button_pump_control.setText("OFF");
      //  send();

    }

    public void pumpSetAuto(final boolean deviceStateOn) {
        state = deviceStateOn ? StatePump.AUTO_ON : StatePump.AUTO_OFF;

        if(state == StatePump.AUTO_ON){
            button_pump_control.setText("AUTO");
            button_pump_control.getStyleClass().set(1,"pump-button-on");

        } if(state == StatePump.AUTO_OFF) {
            button_pump_control.setText("AUTO");
            button_pump_control.getStyleClass().set(1,"pump-button-off");
        }
      //  send();

    }

    public boolean isOn() {
        return state == StatePump.ON;
    }

    public boolean isOff() {
        return state == StatePump.OFF;
    }

    public boolean isAuto() {
        return state == StatePump.AUTO_ON || state == StatePump.AUTO_OFF;
    }

    public String getCode() {
        return state.code;
    }

    public void makeAutoChange(final boolean deviceStateOn) {
        if (!isAuto()) {
            throw new RuntimeException("Pump not in a AUTO state");
        }
        pumpSetAuto(deviceStateOn);
    }

   /* private void send() {
        new CritSender().add(PROTOCOL.DEVICE_PUMP, state.code).send();
    }*/

    private void pumpButtonMousePressed() {

          if (isOff()) {
              pumpSetOn();
            } else if (isOn()) {
                pumpSetAuto(deviceStateButton.isSelected());
            } else if (isAuto()) {
                pumpSetOff();
            }
        }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Gauge temp = GaugeBuilder.create()
                //.skinType(Gauge.SkinType.SIMPLE)
                //.skinType(Gauge.SkinType.DASHBOARD)
                //.skinType(Gauge.SkinType.INDICATOR)
                .skinType(Gauge.SkinType.KPI)
                .sections( new Section(0, 100.0, "0", Color.web("#99ff33")))
                .title("")
                .unit("")
                .barBackgroundColor(Color.web("#cc5200"))
                .barColor(Color.web("#99ff33"))
                .titleColor(Color.web("#ccff33"))
                .unitColor(Color.web("#ccff33"))
                .valueColor(Color.web("#ccff33"))
                .tickLabelsVisible(false)
                .sectionTextVisible(false)
                .tickLabelSectionsVisible(false)
                .onlyFirstAndLastTickLabelVisible(false)
                .areaTextVisible(false)
                .prefSize(170.0,170.0)
                .thresholdVisible(true)
                .threshold(80)
                .animated(true)
                .build();

        temp.setValue(20.0);
        temp.setStyle("-fx-font: 10px Tahoma;");
        /**
         *
         *LCD Display
         *
         */

        Lcd lcd = LcdBuilder.create()
                .prefWidth(280)
                .prefHeight(122)
                .styleClass(Lcd.STYLE_CLASS_BLUE_LIGHTBLUE)
                .backgroundVisible(true)
                .value(1299.0)
                .foregroundShadowVisible(true)
                .crystalOverlayVisible(true)
                .title("")
                .titleVisible(false)
                .batteryVisible(false)
                .signalVisible(false)
                .alarmVisible(false)
                .unit("bar")
                .unitVisible(true)
                .decimals(0)
                .minMeasuredValueDecimals(4)
                .minMeasuredValueVisible(false)
                .maxMeasuredValueDecimals(4)
                .maxMeasuredValueVisible(false)
                .formerValueVisible(false)
                .threshold(26)
                .thresholdVisible(false)
                .trendVisible(false)
                .trend(Lcd.Trend.RISING)
                .numberSystemVisible(false)
                .lowerRightTextVisible(true)
                .valueFont(Lcd.LcdFont.DIGITAL)
                .animated(true)
                .build();
        lcd.setMaxValue(5000.0);
        lcd.setMaxHeight(122);
        lcd.setPrefWidth(280);
        FunLevelGauge gauge = new FunLevelGauge();
        gauge.setPrefSize(90, 90);
        gauge.setOpacity(0.8);
        gauge.setLevel(0.4);

        StackPane pane = new StackPane();
        Image image = new Image("/images/oilTank.png", true);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER , BackgroundSize.DEFAULT);
        pane.setBackground(new Background(backgroundImage));
        pane.setPrefHeight(100);
        pane.setPrefHeight(100);
        pane.getChildren().add(gauge);
        pane.setMargin(gauge,new Insets(0, 0, 0, 0));

        gridPaneHBox1.add(lcd, 3, 0);
        gridPaneHBox1.add(pane, 2, 0);

        button_pump_control.getStyleClass().add(1,"pump-button");
        button_pump_control.getStyleClass().add(1,"pump-button-on");
        button_pump_control.getStyleClass().add(1,"pump-button-off");

        pumpSetOff();

        button_pump_control.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                pumpButtonMousePressed();

            }
        });

        deviceStateButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                pumpSetAuto(!deviceStateButton.isSelected());


            }
        });


      }
}
