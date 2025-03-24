package com.example.tempfx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    public VBox rootNode;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public <T> void onKeyPressed(KeyEvent e) {
        //NOTE: directional buttons not captured - would need to see where they're consumed with an eventfilter in app



        System.out.println("some key pressed");

        switch(e.getCode()) {
            case KeyCode.W:
            case KeyCode.UP:
                System.out.println("up pressed");
                welcomeText.setText("up pressed");
                break;
            case KeyCode.A:
            case KeyCode.LEFT:
                System.out.println("left pressed");
                welcomeText.setText("left pressed");
                break;
            case KeyCode.S:
            case KeyCode.DOWN:
                System.out.println("down pressed");
                welcomeText.setText("down pressed");
                break;
            case KeyCode.D:
            case KeyCode.RIGHT:
                System.out.println("right pressed");
                welcomeText.setText("right pressed");
                break;
        }
    }

    public Scene accessScene() {
        // Get the Stage associated with the root node
        // Note: is null until scene totally loaded
        return rootNode.getScene();
    }

    public Stage accessStage() {
        // Get the Stage associated with the root node
        return (Stage) accessScene().getWindow();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //below doesn't work - fxml isn't loaded yet so scene is null
        //accessScene().setOnKeyPressed(this::onKeyPressed);
    }
}