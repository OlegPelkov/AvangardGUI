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


public class HBox3Controller  implements Initializable {

    @FXML
    private ToggleButton  led_beaker_1;

    private boolean blink = true;

    Timeline timeline = new Timeline();

    KeyFrame keyFrame = new KeyFrame(Duration.millis(500),

            new EventHandler<ActionEvent>() {

                public void handle(ActionEvent event) {

                    if (blink == false) {
                        led_beaker_1.getStyleClass().set(1,"ledBlink-on");
                        blink = true;
                    } else {
                        led_beaker_1.getStyleClass().set(1,"ledBlink-off");
                        blink = false;
                    }

                }
            });

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
        led_beaker_1.getStyleClass().add(1,"led");
        led_beaker_1.getStyleClass().add(1,"ledBlink-on");
        led_beaker_1.getStyleClass().add(1,"ledBlink-off");
        LedBlinkStart();

    }

    public void LedBlinkStart( ) {

            timeline.play();

    }

    public void LedBlinkStop() {
        led_beaker_1.getStyleClass().set(1,"led");
        timeline.stop();

    }



}
