package main;

import controllers.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.controlsfx.control.StatusBar;

public class Main extends Application {

    public HBox3Controller hBox3Controller;
    public HBox4Controller hBox4Controller;

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/RootLayout.fxml"));
        StackPane rootLayout = (StackPane) fxmlLoader.load();

        fxmlLoader =  new FXMLLoader(getClass().getResource("/fxml/VBox.fxml"));
        AnchorPane vBoxlayout  = (AnchorPane) fxmlLoader.load();

        VBoxController vBox_Controller = fxmlLoader.getController();

        fxmlLoader =  new FXMLLoader(getClass().getResource("/fxml/HBox1.fxml"));
        StackPane hBoxLayout1 = (StackPane) fxmlLoader.load();

        HBox1Controller hBox1Controller = fxmlLoader.getController();

        fxmlLoader =  new FXMLLoader(getClass().getResource("/fxml/HBox2.fxml"));
        StackPane hBoxLayout2 = (StackPane) fxmlLoader.load();

        HBox2Controller hBox2Controller = fxmlLoader.getController();

        fxmlLoader =  new FXMLLoader(getClass().getResource("/fxml/HBox3.fxml"));
        hBox3Controller = HBox3Controller.getInstance();
        fxmlLoader.setController(hBox3Controller);
        StackPane hBoxLayout3 = (StackPane) fxmlLoader.load();


        fxmlLoader =  new FXMLLoader(getClass().getResource("/fxml/HBox4.fxml"));
        hBox4Controller = HBox4Controller.getInstance();
        fxmlLoader.setController(hBox4Controller);
        StackPane hBoxLayout4 = (StackPane) fxmlLoader.load();

        fxmlLoader =  new FXMLLoader(getClass().getResource("/fxml/VBoxBackground.fxml"));
        VBox vBoxBackground = (VBox) fxmlLoader.load();

        fxmlLoader =  new FXMLLoader(getClass().getResource("/fxml/HBoxBackground.fxml"));
        HBox hBoxBackground = (HBox) fxmlLoader.load();

        vBoxBackground.getChildren().add(hBoxLayout1);
        vBoxBackground.getChildren().add(hBoxLayout2);
        vBoxBackground.getChildren().add(hBoxLayout3);
        vBoxBackground.getChildren().add(hBoxLayout4);

        hBoxBackground.getChildren().add(vBoxlayout);
        hBoxBackground.getChildren().add(vBoxBackground);

        hBoxBackground.setHgrow(vBoxBackground, Priority.ALWAYS);
        vBoxBackground.setVgrow(hBoxLayout4, Priority.ALWAYS);

        vBoxlayout.prefHeightProperty().bind(rootLayout.heightProperty());
        hBoxBackground.prefHeightProperty().bind(rootLayout.heightProperty());

        rootLayout.getChildren().add(hBoxBackground);

        StatusBar statusBarV = new StatusBar();
        statusBarV.setPrefSize(40.0,40.0);
        statusBarV.setStyle("-fx-background-color: #1f1f2e;");
        statusBarV.setProgress(.5);
        vBoxBackground.getChildren().add(statusBarV);

        Scene scene = new Scene(rootLayout,1280,720);

        primaryStage.setScene(scene);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
