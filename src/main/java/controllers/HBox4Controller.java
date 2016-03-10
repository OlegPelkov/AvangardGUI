package main.java.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import main.java.controllers.BeakerController;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Oleg on 02.03.2016.
 */
public class HBox4Controller implements Initializable {

    @FXML
    private GridPane gridPane_Beakers_flow_delivery;

    @FXML
    private GridPane gridPane_Beakers_flow_recovery;

    public  AnchorPane beaker_flow_delivery_1;
    public  AnchorPane beaker_flow_delivery_2;
    public  AnchorPane beaker_flow_delivery_3;
    public  AnchorPane beaker_flow_delivery_4;
    public  AnchorPane beaker_flow_recovery_1;
    public  AnchorPane beaker_flow_recovery_2;
    public  AnchorPane beaker_flow_recovery_3;
    public  AnchorPane beaker_flow_recovery_4;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        /**
         * Load delivery beakers
         *
         */

        FXMLLoader fxmlLoader =  new FXMLLoader(getClass().getResource("/main/resources/fxml/beaker.fxml"));
        try {
          beaker_flow_delivery_1 = (AnchorPane) fxmlLoader.load();

        } catch (IOException e) {
            e.printStackTrace();
        }

        BeakerController beaker_delivery_1_Controller =  fxmlLoader.getController();

        fxmlLoader =  new FXMLLoader(getClass().getResource("/main/resources/fxml/beaker.fxml"));
        try {
            beaker_flow_delivery_2 = (AnchorPane) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BeakerController beaker_delivery_2_Controller =  fxmlLoader.getController();


        fxmlLoader =  new FXMLLoader(getClass().getResource("/main/resources/fxml/beaker.fxml"));
        try {
            beaker_flow_delivery_3 = (AnchorPane) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BeakerController beaker_delivery_3_Controller =  fxmlLoader.getController();



        fxmlLoader =  new FXMLLoader(getClass().getResource("/main/resources/fxml/beaker.fxml"));
        try {
            beaker_flow_delivery_4 = (AnchorPane) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BeakerController beaker_delivery_4_Controller =  fxmlLoader.getController();


        /**
         * Load recovery beakers
         *
         */

        fxmlLoader =  new FXMLLoader(getClass().getResource("/main/resources/fxml/beaker.fxml"));
        try {
            beaker_flow_recovery_1 = (AnchorPane) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BeakerController beaker_recovery_1_Controller =  fxmlLoader.getController();

        fxmlLoader =  new FXMLLoader(getClass().getResource("/main/resources/fxml/beaker.fxml"));
        try {
            beaker_flow_recovery_2 = (AnchorPane) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BeakerController beaker_recovery_2_Controller =  fxmlLoader.getController();

        fxmlLoader =  new FXMLLoader(getClass().getResource("/main/resources/fxml/beaker.fxml"));
        try {
            beaker_flow_recovery_3 = (AnchorPane) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BeakerController beaker_recovery_3_Controller =  fxmlLoader.getController();

        fxmlLoader =  new FXMLLoader(getClass().getResource("/main/resources/fxml/beaker.fxml"));
        try {
            beaker_flow_recovery_4 = (AnchorPane) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BeakerController beaker_recovery_4_Controller =  fxmlLoader.getController();

        beaker_delivery_1_Controller.calculateBeakerPropeties(80.0);
        beaker_delivery_1_Controller.setFuelLevelBeaker(90.0);

        beaker_delivery_2_Controller.calculateBeakerPropeties(100.0);
        beaker_delivery_2_Controller.setFuelLevelBeaker(50.0);

        beaker_delivery_3_Controller.calculateBeakerPropeties(300.0);
        beaker_delivery_3_Controller.setFuelLevelBeaker(100.0);

        beaker_delivery_4_Controller.calculateBeakerPropeties(10.0);
        beaker_delivery_4_Controller.setFuelLevelBeaker(18.0);

        beaker_recovery_1_Controller.calculateBeakerPropeties(180.0);
        beaker_recovery_1_Controller.setFuelLevelBeaker(40.0);
        beaker_recovery_1_Controller.setStateBeaker("1");

        beaker_recovery_2_Controller.calculateBeakerPropeties(200.0);
        beaker_recovery_2_Controller.setFuelLevelBeaker(180.0);
        beaker_recovery_2_Controller.setStateBeaker("1");

        beaker_recovery_3_Controller.calculateBeakerPropeties(200.0);
        beaker_recovery_3_Controller.setFuelLevelBeaker(100.0);
        beaker_recovery_3_Controller.setStateBeaker("1");

        beaker_recovery_4_Controller.calculateBeakerPropeties(250.0);
        beaker_recovery_4_Controller.setFuelLevelBeaker(100.0);
        beaker_recovery_4_Controller.setStateBeaker("1");

        gridPane_Beakers_flow_delivery.add(beaker_flow_delivery_1,0,0);
        gridPane_Beakers_flow_delivery.add(beaker_flow_delivery_2,1,0);
        gridPane_Beakers_flow_delivery.add(beaker_flow_delivery_3,2,0);
        gridPane_Beakers_flow_delivery.add(beaker_flow_delivery_4,3,0);

        gridPane_Beakers_flow_recovery.add(beaker_flow_recovery_1,0,0);
        gridPane_Beakers_flow_recovery.add(beaker_flow_recovery_2,1,0);
        gridPane_Beakers_flow_recovery.add(beaker_flow_recovery_3,2,0);
        gridPane_Beakers_flow_recovery.add(beaker_flow_recovery_4,3,0);


    }


}
