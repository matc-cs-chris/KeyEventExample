package com.example.tempfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.io.IOException;

//intro to fxml - https://docs.oracle.com/javase/8/javafx/api/javafx/fxml/doc-files/introduction_to_fxml.html
//see - initialize() method in controller

//event bubbling logic - https://docs.oracle.com/javafx/2/events/processing.htm

//how to find out where an event is consumed:
/*
scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<Event>() {
        @Override
        public void handle(Event event) {
            System.out.println(event);
        }
    });
 */

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        //how to access your controller from your application - preserves MVC
        HelloController control = fxmlLoader.getController();
        scene.setOnKeyPressed(control::onKeyPressed);

        stage.setTitle("Press a directional key");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}