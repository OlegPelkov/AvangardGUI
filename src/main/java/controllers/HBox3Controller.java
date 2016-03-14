package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class HBox3Controller  implements Initializable {


    private static HBox3Controller instance = null;

    private HBox3Controller(){


    }

    public static  HBox3Controller getInstance(){
        if(instance == null){
            instance = new HBox3Controller();
        }
        return  instance;

    }


    @FXML
    private GridPane gird_led_beaker;

    private AnchorPane led_beaker_1;
    private AnchorPane led_beaker_2;
    private AnchorPane led_beaker_3;
    private AnchorPane led_beaker_4;
    private AnchorPane led_beaker_5;
    private AnchorPane led_beaker_6;

    public LedController led_beaker_1_Controller;
    public LedController led_beaker_2_Controller;
    public LedController led_beaker_3_Controller;
    public LedController led_beaker_4_Controller;
    public LedController led_beaker_5_Controller;
    public LedController led_beaker_6_Controller;




    @Override
    public void initialize(URL location, ResourceBundle resources) {

        /**
         *
         * Load ledBeakers and controllers
         *
         * */

        FXMLLoader fxmlLoader =  new FXMLLoader(getClass().getResource("/fxml/ledBeaker.fxml"));
        try {
            led_beaker_1 = (AnchorPane) fxmlLoader.load();

        } catch (IOException e) {
            e.printStackTrace();
        }

        led_beaker_1_Controller =  fxmlLoader.getController();


        fxmlLoader =  new FXMLLoader(getClass().getResource("/fxml/ledBeaker.fxml"));
        try {
            led_beaker_2 = (AnchorPane) fxmlLoader.load();

        } catch (IOException e) {
            e.printStackTrace();
        }

        led_beaker_2_Controller =  fxmlLoader.getController();


        fxmlLoader =  new FXMLLoader(getClass().getResource("/fxml/ledBeaker.fxml"));
        try {
            led_beaker_3 = (AnchorPane) fxmlLoader.load();

        } catch (IOException e) {
            e.printStackTrace();
        }

        led_beaker_3_Controller =  fxmlLoader.getController();


        fxmlLoader =  new FXMLLoader(getClass().getResource("/fxml/ledBeaker.fxml"));
        try {
            led_beaker_4 = (AnchorPane) fxmlLoader.load();

        } catch (IOException e) {
            e.printStackTrace();
        }

        led_beaker_4_Controller =  fxmlLoader.getController();


        fxmlLoader =  new FXMLLoader(getClass().getResource("/fxml/ledBeaker.fxml"));
        try {
            led_beaker_5 = (AnchorPane) fxmlLoader.load();

        } catch (IOException e) {
            e.printStackTrace();
        }

        led_beaker_5_Controller =  fxmlLoader.getController();


        fxmlLoader =  new FXMLLoader(getClass().getResource("/fxml/ledBeaker.fxml"));
        try {
            led_beaker_6 = (AnchorPane) fxmlLoader.load();

        } catch (IOException e) {
            e.printStackTrace();
        }

        led_beaker_6_Controller =  fxmlLoader.getController();

        /**
         *
         * Add ledBeakers on frame
         *
         * */

        gird_led_beaker.add(led_beaker_1,0,0);
        gird_led_beaker.add(led_beaker_2,1,0);
        gird_led_beaker.add(led_beaker_3,2,0);
        gird_led_beaker.add(led_beaker_4,3,0);
        gird_led_beaker.add(led_beaker_5,4,0);
        gird_led_beaker.add(led_beaker_6,5,0);


    }
}
