package com.example.descosystem_g22;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private PasswordField password_tf;

    @FXML
    private TextField username_tf;

    @FXML
    private Label message_lbl;

    @FXML
    void onLoginButtonClick(ActionEvent event) throws IOException {
        Authenticator auth = new Authenticator();

        String username = username_tf.getText();
        String password = password_tf.getText();
        if (!validate(username, password)) {
            message_lbl.setText("Username or password cannot be blank!");
            return;
        }

        User login_user = new User(username, password);

        if (auth.checkLogIn(login_user)) {
            message_lbl.setText("Log in successful!");
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hr.fxml"));
            Scene scene2 = new Scene(fxmlLoader.load());


            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            stage.setTitle("HR Dashboard");
            stage.setScene(scene2);
            }
        else {
            message_lbl.setText("Invalid username or password!");
        }
    }
    private boolean validate(String username, String password) {
        if (username.isBlank() || password.isBlank()) {
//            message_lbl.setText("Username or password cannot be blank!");
            return false;
        }
        return true;
    }

    @Deprecated
    void onDemoAdminClick(ActionEvent actionEvent) {
        // switch to admin dashboard for demo
    }
}
