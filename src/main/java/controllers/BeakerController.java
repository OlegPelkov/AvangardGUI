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

    private final Color DEFAULT_MARK_COLOR = Color.web("#ff1f1f");

    private void setColorMark(String webColor){

        arc_tick_top_beaker.setStroke(Color.web(webColor));
        arc_tick_bottom_beaker.setStroke(Color.web(webColor));
        text_top_beaker.fillProperty().set(Color.web(webColor));
        text_bottom_beaker.fillProperty().set(Color.web(webColor));

    }

    public void setStateBeaker(String state){

        if(state.equals("1")){
            setColorMark("transparent");
        }

    }

    public void setFuelLevelBeaker(double FlowThread){

        double oldFuelHeight;
        oldFuelHeight = rectangle_fuel.getHeight();
        rectangle_fuel.setHeight(FlowThread*this.beakerRate);
        beaker_pane.setTopAnchor(rectangle_fuel,beaker_pane.getTopAnchor(rectangle_fuel)+oldFuelHeight-rectangle_fuel.getHeight());
        beaker_pane.setTopAnchor(ellipse_top_fuel,beaker_pane.getTopAnchor(rectangle_fuel)-ellipse_top_fuel.getRadiusY());

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        arc_tick_top_beaker.setStroke(DEFAULT_MARK_COLOR);
        arc_tick_bottom_beaker.setStroke(DEFAULT_MARK_COLOR);
        text_top_beaker.fillProperty().set(DEFAULT_MARK_COLOR);
        text_bottom_beaker.fillProperty().set(DEFAULT_MARK_COLOR);
        setStateBeaker("0");
        calculateBeakerPropeties(140.0);
        setFuelLevelBeaker(40);

    }


}
