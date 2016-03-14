package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Oleg on 02.03.2016.
 */
public class HBox4Controller implements Initializable {

    /**
     *
     * Make as singletone
     *
     * */
    private static HBox4Controller instance = null;

    private HBox4Controller(){


    }

    public static  HBox4Controller getInstance(){
        if(instance == null){
            instance = new HBox4Controller();
        }
        return  instance;

    }


    @FXML
    private Tab  tab_flow;

    @FXML
    private Tab  tab_coding;

    @FXML
    private Tab  tab_pump;

    @FXML
    private Tab  tab_voltage;

    @FXML
    private Tab tab_delay;

    @FXML
    private Tab tab_info;

    @FXML
    private Tab tab_settings;

    @FXML
    private Tab tab_report;

    @FXML
    private TabPane tab_pane;

    @FXML
    private GridPane gridPane_Beakers_flow_delivery;

    @FXML
    private GridPane gridPane_Beakers_flow_recovery;

    private VBoxController vBoxController;

    public  AnchorPane beaker_flow_delivery_1;
    public  AnchorPane beaker_flow_delivery_2;
    public  AnchorPane beaker_flow_delivery_3;
    public  AnchorPane beaker_flow_delivery_4;
    public  AnchorPane beaker_flow_recovery_1;
    public  AnchorPane beaker_flow_recovery_2;
    public  AnchorPane beaker_flow_recovery_3;
    public  AnchorPane beaker_flow_recovery_4;

    public void selectTabFlow(){
        tab_pane.getSelectionModel().select(tab_flow);

        }

    public void selectTabCoding(){
        tab_pane.getSelectionModel().select(tab_coding);

    }

    public void selectTabPump(){
        tab_pane.getSelectionModel().select(tab_pump);

    }

    public void selectTabVoltage(){
        tab_pane.getSelectionModel().select(tab_voltage);

    }

    public void selectTabDelay(){
        tab_pane.getSelectionModel().select(tab_delay);

    }

    public void selectTabInfo(){
        tab_pane.getSelectionModel().select(tab_info);

    }

    public void selectTabSettings(){
        tab_pane.getSelectionModel().select(tab_settings);

    }

    public void selectTabReport(){
        tab_pane.getSelectionModel().select(tab_report);

    }

    public void updateBeakers(){

        if(vBoxController.getSelectedTest().equals("testDisable")){

        }


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        /**
         * get controllers
         *
         * * */

        vBoxController = VBoxController.getInstance();

        /**
         * Load delivery beakers
         *
         */

        FXMLLoader fxmlLoader =  new FXMLLoader(getClass().getResource("/fxml/beaker.fxml"));
        try {
          beaker_flow_delivery_1 = (AnchorPane) fxmlLoader.load();

        } catch (IOException e) {
            e.printStackTrace();
        }

        BeakerController beaker_delivery_1_Controller =  fxmlLoader.getController();

        fxmlLoader =  new FXMLLoader(getClass().getResource("/fxml/beaker.fxml"));
        try {
            beaker_flow_delivery_2 = (AnchorPane) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BeakerController beaker_delivery_2_Controller =  fxmlLoader.getController();


        fxmlLoader =  new FXMLLoader(getClass().getResource("/fxml/beaker.fxml"));
        try {
            beaker_flow_delivery_3 = (AnchorPane) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BeakerController beaker_delivery_3_Controller =  fxmlLoader.getController();



        fxmlLoader =  new FXMLLoader(getClass().getResource("/fxml/beaker.fxml"));
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

        fxmlLoader =  new FXMLLoader(getClass().getResource("/fxml/beaker.fxml"));
        try {
            beaker_flow_recovery_1 = (AnchorPane) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BeakerController beaker_recovery_1_Controller =  fxmlLoader.getController();

        fxmlLoader =  new FXMLLoader(getClass().getResource("/fxml/beaker.fxml"));
        try {
            beaker_flow_recovery_2 = (AnchorPane) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BeakerController beaker_recovery_2_Controller =  fxmlLoader.getController();

        fxmlLoader =  new FXMLLoader(getClass().getResource("/fxml/beaker.fxml"));
        try {
            beaker_flow_recovery_3 = (AnchorPane) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BeakerController beaker_recovery_3_Controller =  fxmlLoader.getController();

        fxmlLoader =  new FXMLLoader(getClass().getResource("/fxml/beaker.fxml"));
        try {
            beaker_flow_recovery_4 = (AnchorPane) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BeakerController beaker_recovery_4_Controller =  fxmlLoader.getController();

        beaker_delivery_1_Controller.calculateBeakerPropeties(80.0);
        beaker_delivery_1_Controller.setBeakerMode("DISABLED");
        beaker_delivery_1_Controller.setFuelLevelBeaker(90.0);

        beaker_delivery_2_Controller.calculateBeakerPropeties(100.0);
        beaker_delivery_2_Controller.setBeakerMode("DISABLED");
        beaker_delivery_2_Controller.setFuelLevelBeaker(50.0);

        beaker_delivery_3_Controller.calculateBeakerPropeties(300.0);
        beaker_delivery_3_Controller.setBeakerMode("RELATIVE");
        beaker_delivery_3_Controller.setFuelLevelBeaker(600.0);

        beaker_delivery_4_Controller.calculateBeakerPropeties(100.0);
        beaker_delivery_4_Controller.setBeakerMode("RELATIVE");
        beaker_delivery_4_Controller.setFuelLevelBeaker(28.0);

        beaker_recovery_1_Controller.calculateBeakerPropeties(180.0);
        beaker_recovery_1_Controller.setBeakerMode("MARKS_CENTER");
        beaker_recovery_1_Controller.setFuelLevelBeaker(40.0);

        beaker_recovery_2_Controller.calculateBeakerPropeties(200.0);
        beaker_recovery_2_Controller.setBeakerMode("MARKS_CENTER");
        beaker_recovery_2_Controller.setFuelLevelBeaker(180.0);

        beaker_recovery_3_Controller.calculateBeakerPropeties(200.0);
        beaker_recovery_3_Controller.setBeakerMode("MARKS_CENTER");
        beaker_recovery_3_Controller.setFuelLevelBeaker(100.0);

        beaker_recovery_4_Controller.calculateBeakerPropeties(250.0);
        beaker_recovery_4_Controller.setBeakerMode("MARKS_CENTER");
        beaker_recovery_4_Controller.setFuelLevelBeaker(100.0);


        gridPane_Beakers_flow_delivery.add(beaker_flow_delivery_1,0,0);
        gridPane_Beakers_flow_delivery.add(beaker_flow_delivery_2,1,0);
        gridPane_Beakers_flow_delivery.add(beaker_flow_delivery_3,2,0);
        gridPane_Beakers_flow_delivery.add(beaker_flow_delivery_4,3,0);

        gridPane_Beakers_flow_recovery.add(beaker_flow_recovery_1,0,0);
        gridPane_Beakers_flow_recovery.add(beaker_flow_recovery_2,1,0);
        gridPane_Beakers_flow_recovery.add(beaker_flow_recovery_3,2,0);
        gridPane_Beakers_flow_recovery.add(beaker_flow_recovery_4,3,0);

        selectTabFlow();


    }


}
