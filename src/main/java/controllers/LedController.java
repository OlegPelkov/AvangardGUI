package controllers;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by oleg on 11.03.16.
 */
public class LedController implements Initializable {

    @FXML
    private ToggleButton led_beaker;

    private boolean blink = false;

    /**
     * Set-up blink-timer
     * */

    Timeline timeline = new Timeline();

    KeyFrame keyFrame = new KeyFrame(Duration.millis(500),

            new EventHandler<ActionEvent>() {

                public void handle(ActionEvent event) {

                    if (blink == false) {
                        led_beaker.getStyleClass().set(1,"ledBlink-on");
                        blink = true;
                    } else {
                        led_beaker.getStyleClass().set(1,"ledBlink-off");
                        blink = false;
                    }

                }
            });


    public void LedBlinkStart( ) {
        if(led_beaker.isSelected()) {
            blink = true;
            timeline.play();
        }

    }

    public void LedBlinkStop() {
        if(led_beaker.isSelected()) {
            blink = false;
            led_beaker.getStyleClass().set(1, "ledBlink-on");
            timeline.stop();
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
        led_beaker.getStyleClass().add(1,"led");
        led_beaker.getStyleClass().add(1,"ledBlink-on");
        led_beaker.getStyleClass().add(1,"ledBlink-off");

        led_beaker.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if(led_beaker.isSelected()){
                    led_beaker.getStyleClass().set(1,"ledBlink-on");
                } else led_beaker.getStyleClass().set(1,"ledBlink-off");

            }
        });

    }





}
