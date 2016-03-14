package controllers;

import eu.hansolo.enzo.lcd.Lcd;
import eu.hansolo.enzo.lcd.LcdBuilder;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import java.net.URL;
import java.util.ResourceBundle;

public class HBox2Controller implements Initializable {

    @FXML
    public GridPane gridPaneHBox2;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Lcd lcd = LcdBuilder.create()
                .prefWidth(280)
                .prefHeight(122)
                .styleClass(Lcd.STYLE_CLASS_BLUE_LIGHTBLUE)
                .backgroundVisible(true)
                .value(99.0)
                .foregroundShadowVisible(true)
                .crystalOverlayVisible(true)
                .title("")
                .titleVisible(false)
                .batteryVisible(false)
                .signalVisible(false)
                .alarmVisible(false)
                .unit(" bar")
                .unitVisible(true)
                .decimals(0)
                .minMeasuredValueDecimals(4)
                .minMeasuredValueVisible(false)
                .maxMeasuredValueDecimals(4)
                .maxMeasuredValueVisible(false)
                .formerValueVisible(false)
                .threshold(0)
                .thresholdVisible(false)
                .trendVisible(false)
                .trend(Lcd.Trend.RISING)
                .numberSystemVisible(false)
                .lowerRightTextVisible(true)
                .valueFont(Lcd.LcdFont.DIGITAL)
                .animated(true)
                .build();
        lcd.setMaxValue(5000.0);
        lcd.setValue(1999.0);
        gridPaneHBox2.add(lcd,6,0);

    }
}