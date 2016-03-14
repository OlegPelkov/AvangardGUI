package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Oleg on 05.03.2016.
 */

public class BeakerController implements Initializable {

    @FXML
    private AnchorPane beaker_pane;
    @FXML
    private Ellipse ellipse_top_fuel;
    @FXML
    private Ellipse ellipse_bottom_fuel;
    @FXML
    private Arc arc_tick_top_beaker;
    @FXML
    private Arc arc_tick_bottom_beaker;
    @FXML
    private Text text_top_beaker;
    @FXML
    private Text text_bottom_beaker;
    @FXML
    private Rectangle rectangle_beaker;
    @FXML
    private Rectangle rectangle_fuel;

    private Double beakerRate = 1.0;

    private enum BeakerMode {

        DISABLED, RELATIVE, MARKS_CENTER
    }

    private BeakerMode beakerMode;

    private Double currentFlowThreadValue;

    private final Color DEFAULT_MARK_COLOR = Color.web("#ff1f1f");
    private final Color DEFAULT_FUEL_FACE_COLOR = Color.web("#1fffb4");
    private final Color DEFAULT_FUEL_TOP_COLOR = Color.web("#2eb586");
    private final Color TRANSPARENT_COLOR = Color.web("transparent");

    private void setColorMark(String webColor){

        arc_tick_top_beaker.setStroke(Color.web(webColor));
        arc_tick_bottom_beaker.setStroke(Color.web(webColor));
        text_top_beaker.fillProperty().set(Color.web(webColor));
        text_bottom_beaker.fillProperty().set(Color.web(webColor));

    }

    private void setVisibleFuel(boolean visibleFuel){

        if(visibleFuel) {

            ellipse_top_fuel.setFill(DEFAULT_FUEL_TOP_COLOR);
            ellipse_bottom_fuel.setFill(DEFAULT_FUEL_FACE_COLOR);
            rectangle_fuel.setFill(DEFAULT_FUEL_FACE_COLOR);

        } else {

            ellipse_top_fuel.setFill(TRANSPARENT_COLOR);
            ellipse_bottom_fuel.setFill(TRANSPARENT_COLOR);
            rectangle_fuel.setFill(TRANSPARENT_COLOR);

        }


    }

    public void  setBeakerMode(String mode){

        switch (mode){
            case "DISABLED" : {
                beakerMode = BeakerMode.DISABLED;
                setDisabledMode();
            } break;

            case "RELATIVE" : {
                beakerMode = BeakerMode.RELATIVE;
                setRelativeMode();
            } break;

            case "MARKS_CENTER" : {
                beakerMode = BeakerMode.MARKS_CENTER;
                setMarksCenterMode();
            } break;
        }

    }

    public void startTest(){


    }


    public void setFuelLevelBeaker(double flowThread){

        if(beakerMode==BeakerMode.DISABLED) {
            flowThread =0.0;
        }

        /**
         * if flowThread out of border
         * */
        if((flowThread*beakerRate)>(rectangle_beaker.getHeight()-ellipse_top_fuel.getRadiusY())){
            flowThread = (rectangle_beaker.getHeight()-ellipse_top_fuel.getRadiusY())/this.beakerRate;
        }

         double oldFuelHeight;

         currentFlowThreadValue = flowThread;
         oldFuelHeight = rectangle_fuel.getHeight();
         rectangle_fuel.setHeight(flowThread * this.beakerRate);
         beaker_pane.setTopAnchor(rectangle_fuel, beaker_pane.getTopAnchor(rectangle_fuel) + oldFuelHeight - rectangle_fuel.getHeight());
         beaker_pane.setTopAnchor(ellipse_top_fuel, beaker_pane.getTopAnchor(rectangle_fuel) - ellipse_top_fuel.getRadiusY());
    }

    public void calculateBeakerPropeties(double initFlowThread){

        double beakerRate;
        double spreadFlow;
        double oldFuelHeight;

        oldFuelHeight = rectangle_fuel.getHeight();
        beakerRate = rectangle_beaker.getHeight()/(initFlowThread*2);
        spreadFlow = initFlowThread*0.4;

        this.beakerRate = beakerRate;

        rectangle_fuel.setHeight(initFlowThread*beakerRate);
        beaker_pane.setTopAnchor(rectangle_fuel,beaker_pane.getTopAnchor(rectangle_fuel)+oldFuelHeight-rectangle_fuel.getHeight());
        beaker_pane.setTopAnchor(ellipse_top_fuel,beaker_pane.getTopAnchor(rectangle_fuel)-ellipse_top_fuel.getRadiusY());

        beaker_pane.setTopAnchor(arc_tick_top_beaker,beaker_pane.getTopAnchor(rectangle_fuel) - spreadFlow*beakerRate);
        beaker_pane.setTopAnchor(arc_tick_bottom_beaker,beaker_pane.getTopAnchor(rectangle_fuel) + spreadFlow*beakerRate);

        beaker_pane.setTopAnchor(text_top_beaker,beaker_pane.getTopAnchor(rectangle_fuel) - spreadFlow*beakerRate -arc_tick_top_beaker.getRadiusY());
        beaker_pane.setTopAnchor(text_bottom_beaker,beaker_pane.getTopAnchor(rectangle_fuel) + spreadFlow*beakerRate -arc_tick_top_beaker.getRadiusY());

        text_top_beaker.setText(String.valueOf(initFlowThread+spreadFlow));
        text_bottom_beaker.setText(String.valueOf(initFlowThread-spreadFlow));

    }

    private void setDisabledMode(){

        setColorMark("transparent");
        setVisibleFuel(false);


    }

    private void setRelativeMode(){

        setColorMark("transparent");
        setFuelLevelBeaker(currentFlowThreadValue);
        setVisibleFuel(true);


    }

    private void setMarksCenterMode(){

        setColorMark(DEFAULT_MARK_COLOR.toString());
        setFuelLevelBeaker(currentFlowThreadValue);
        setVisibleFuel(true);


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        currentFlowThreadValue = 0.0;
        calculateBeakerPropeties(140.0);
        setBeakerMode("DISABLED");


    }


}
