package controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by oleg on 11.03.16.
 */
public class VBoxController implements Initializable {

    /**
     *
     * Make as singletone
     *
     * */
    private static VBoxController instance = null;

    private VBoxController(){


    }

    public static  VBoxController getInstance(){
        if(instance == null){
            instance = new VBoxController();
        }
        return  instance;

    }

    @FXML
    private RadioButton radioButton_Pumps;

    @FXML
    private  RadioButton radioButton_Injectors;

    @FXML
    private ProgressBar progress_bar_adjusting;

    @FXML
    private ProgressBar progress_bar_measuring;

    @FXML
    private Text text_progress_adjusting;

    @FXML
    private Text text_progress_measuring;

    @FXML
    private ToggleButton  toggle_button_start;

    @FXML
    private ListView testList;


    private  HBox3Controller hBox3Controller;
    private  HBox4Controller hBox4Controller;


    public String  getSelectedTest(){

        return (String) testList.getSelectionModel().getSelectedItem();

    }

    public void startProcess(){

        progress_bar_adjusting.setProgress(0.2);
        progress_bar_measuring.setProgress(0.8);
        /**
         * get instance of HBox3Controller
         * and set-up its child nodes
         * */
        hBox3Controller.led_beaker_1_Controller.LedBlinkStart();
        hBox3Controller.led_beaker_2_Controller.LedBlinkStart();
        hBox3Controller.led_beaker_3_Controller.LedBlinkStart();
        hBox3Controller.led_beaker_4_Controller.LedBlinkStart();
        hBox3Controller.led_beaker_5_Controller.LedBlinkStart();
        hBox3Controller.led_beaker_6_Controller.LedBlinkStart();



    }

    public void stopProcess(){

        progress_bar_adjusting.setProgress(0);
        progress_bar_measuring.setProgress(0.1);
        progress_bar_measuring.setProgress(0.8);
        /**
         * get instance of HBox3Controller
         * and set-up its child nodes
         * */
        hBox3Controller.led_beaker_1_Controller.LedBlinkStop();
        hBox3Controller.led_beaker_2_Controller.LedBlinkStop();
        hBox3Controller.led_beaker_3_Controller.LedBlinkStop();
        hBox3Controller.led_beaker_4_Controller.LedBlinkStop();
        hBox3Controller.led_beaker_5_Controller.LedBlinkStop();
        hBox3Controller.led_beaker_6_Controller.LedBlinkStop();

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        /**
        * test data
        * **/

        ObservableList<String> testListData = FXCollections.observableArrayList("testDisable","testRelative","testCenter");

        testList.setItems(testListData);

        /**
         * Get controllers of panels
         *
         * */

        hBox3Controller = HBox3Controller.getInstance();
        hBox4Controller = HBox4Controller.getInstance();


        /**
         * Initialize ProgressBars
         *
         * Bind Text on ProgressBar to value of progress
         *
         * */


        progress_bar_adjusting.progressProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                text_progress_adjusting.setText(String.valueOf(newValue.doubleValue()*100));
            }
        });


        progress_bar_measuring.progressProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                text_progress_measuring.setText(String.valueOf(newValue.doubleValue()*100));
            }
        });


        /**
         * Initialize ToggleButtons
         *
         * Set Start/stop state for Start/Stop button
         *
         * */

        toggle_button_start.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(toggle_button_start.isSelected()){

                    toggle_button_start.setText("Start");
                    startProcess();

                } else {
                    toggle_button_start.setText("Stop");
                    stopProcess();

                }
            }
        });


        /**
         * Initialize RadioButtons
         *
         * radio - Pump, Injectors
         *
         */

        radioButton_Pumps.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                hBox4Controller.selectTabPump();

            }
        });

        radioButton_Injectors.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                hBox4Controller.selectTabFlow();
            }
        });



    }
}

