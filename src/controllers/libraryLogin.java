package controllers;

import dao.LibrarianDAOImpl;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import models.Librarian;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class libraryLogin implements Initializable {

    public TextField txtName;
    public PasswordField txtPassword;
    public Button librarianLogInBtn;
    public Label lblName, lblPassword;


    public libraryLogin() {}


    public boolean validate() {
        boolean test = true;
        lblName.setVisible(false);
        lblPassword.setVisible(false);

        if(txtName.getText().isEmpty()){
            lblName.setVisible(true);
            lblName.setText("required");
            lblName.setTextFill(Color.RED);
            test = false;
        }
        if(txtPassword.getText().isEmpty()){
            lblPassword.setVisible(true);
            lblPassword.setText("required");
            lblPassword.setTextFill(Color.RED);
            test = false;
        }

        return test;
    }
     public void toLibrary(ActionEvent event) throws IOException {
        AdminLogIn.getInstance().backToLibrary(event);
     }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblName.setVisible(false);
        lblPassword.setVisible(false);

        librarianLogInBtn.setOnAction(e -> {

            String name = txtName.getText();
            String Password = txtPassword.getText();
            Librarian librarian = LibrarianDAOImpl.getInstance().getByName(name);
            if(validate()) {
                if(librarian == null) {
                    lblName.setVisible(true);
                    lblName.setText("Librarian does not exist!");
                    lblName.setTextFill(Color.RED);
                    return;
                }
                if(!librarian.
                        getPassword().equals(txtPassword.getText())){
                    lblPassword.setVisible(true);
                    lblPassword.setText("incorrect Password entered!");
                    lblPassword.setTextFill(Color.RED);
                    return;
                }
                if(librarian.getName().equals(name) && librarian.getPassword().equals(Password)) {
                    try {
                        AdminLogIn.getInstance().LoadStage(e, "/views/LibrarianSection.fxml");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }

        });
    }
}
