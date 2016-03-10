package main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.controlsfx.control.StatusBar;
import main.java.controllers.HBox4Controller;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../resources/fxml/RootLayout.fxml"));
        StackPane rootLayout = (StackPane) fxmlLoader.load();

        fxmlLoader =  new FXMLLoader(getClass().getResource("../resources/fxml/VBox.fxml"));
        AnchorPane leftBoxLayout  = (AnchorPane) fxmlLoader.load();

        fxmlLoader =  new FXMLLoader(getClass().getResource("../resources/fxml/HBox1.fxml"));
        StackPane rightBoxLayout1 = (StackPane) fxmlLoader.load();

        fxmlLoader =  new FXMLLoader(getClass().getResource("../resources/fxml/HBox2.fxml"));
        StackPane rightBoxLayout2 = (StackPane) fxmlLoader.load();

        fxmlLoader =  new FXMLLoader(getClass().getResource("../resources/fxml/HBox3.fxml"));
        StackPane rightBoxLayout3 = (StackPane) fxmlLoader.load();

        fxmlLoader =  new FXMLLoader(getClass().getResource("../resources/fxml/HBox4.fxml"));
        StackPane rightBoxLayout4 = (StackPane) fxmlLoader.load();

        HBox4Controller hBox4Controller  =  fxmlLoader.getController();

        fxmlLoader =  new FXMLLoader(getClass().getResource("../resources/fxml/VBoxBackground.fxml"));
        VBox VBoxBackground = (VBox) fxmlLoader.load();

        fxmlLoader =  new FXMLLoader(getClass().getResource("../resources/fxml/HBoxBackground.fxml"));
        HBox HBoxBackground = (HBox) fxmlLoader.load();

        VBoxBackground.getChildren().add(rightBoxLayout1);
        VBoxBackground.getChildren().add(rightBoxLayout2);
        VBoxBackground.getChildren().add(rightBoxLayout3);
        VBoxBackground.getChildren().add(rightBoxLayout4);

        HBoxBackground.getChildren().add(leftBoxLayout);
        HBoxBackground.getChildren().add(VBoxBackground);

        HBoxBackground.setHgrow(VBoxBackground, Priority.ALWAYS);
        VBoxBackground.setVgrow(rightBoxLayout4, Priority.ALWAYS);

        leftBoxLayout.prefHeightProperty().bind(rootLayout.heightProperty());
        HBoxBackground.prefHeightProperty().bind(rootLayout.heightProperty());

        rootLayout.getChildren().add(HBoxBackground);

        StatusBar statusBarV = new StatusBar();
        statusBarV.setPrefSize(40.0,40.0);
        statusBarV.setStyle("-fx-background-color: #1f1f2e;");
        statusBarV.setProgress(.5);
        VBoxBackground.getChildren().add(statusBarV);

      /*  statusBarV.prefHeightProperty().bind(rootLayout.heightProperty().subtract(1200.0));*/

      /*  rootLayout.getChildren().add(statusBarV);
        rootLayout.setMargin(statusBarV,new Insets(rootLayout.getHeight()-statusBarV.getHeight(),0.0,0.0,0.0));
        rootLayout.setAlignment(statusBarV, Pos.BOTTOM_CENTER);*/

        Scene scene = new Scene(rootLayout,1280,720);

        primaryStage.setScene(scene);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
