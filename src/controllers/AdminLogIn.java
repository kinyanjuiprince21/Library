package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminLogIn implements Initializable {
    private static Stage stage;
    private static Scene scene;
    private static Parent root;
    private String name = "admin";
    private String password = "admin123";

    private static AdminLogIn adminLogIn;
    public Label lblName, lblPassword;
    public Button logInAdminSection;


    public AdminLogIn(){}

    public static AdminLogIn getInstance() {
        if(adminLogIn == null) {
            adminLogIn = new AdminLogIn();
        }
        return adminLogIn;
    }

    @FXML
    private TextField adminName;
    @FXML
    private PasswordField adminPassword;

    public  void LoadStage(ActionEvent event, String file) throws IOException {
        root = FXMLLoader.load(getClass().getResource(file));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public  void backToLibrary(ActionEvent event) throws IOException {
        LoadStage(event, "/views/Library.fxml");
    }
    public static void AlertBox(String title, String message ) {
        stage = new Stage();

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);
        stage.setMinWidth(400);
        stage.setMinHeight(200);

        Label label = new Label();
        label.setText(message);
        label.setTextFill(Color.RED);
        label.setFont(Font.font(20));

        Button closeButton  = new Button("Close");
        closeButton.setOnAction( e -> stage.close());

        VBox layout = new VBox(30);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        scene = new Scene(layout);
        stage.setScene(scene);
        stage.showAndWait();
    }

    public boolean validate() {
        boolean test = true;
        lblName.setVisible(false);
        lblPassword.setVisible(false);

        if(adminName.getText().isEmpty()) {
            lblName.setVisible(true);
            lblName.setText("required");
            lblName.setTextFill(Color.RED);
            test = false;
        }
        if(adminPassword.getText().isEmpty()) {
            lblPassword.setVisible(true);
            lblPassword.setText("required");
            lblPassword.setTextFill(Color.RED);
            test = false;
        }

        return test;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        lblName.setVisible(false);
        lblPassword.setVisible(false);

        logInAdminSection.setOnAction(e -> {
            String nameEntered = adminName.getText();
            String passwordEntered = adminPassword.getText();
            if(validate()){
                if(!adminName.getText().equals(name)) {
                    lblName.setVisible(true);
                    lblName.setText("admin does not exist");
                    lblName.setTextFill(Color.RED);
                }
                if(!adminPassword.getText().equals(password)){
                    lblPassword.setVisible(true);
                    lblPassword.setText("incorrect password entered!");
                    lblPassword.setTextFill(Color.RED);
                    return;
                }

                if(nameEntered.equals(name) && passwordEntered.equals(password)) {
                    try {
                        LoadStage(e, "/views/AdminSection.fxml");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }
}

