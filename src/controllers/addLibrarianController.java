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


public class addLibrarianController implements Initializable {
    Librarian librarian = new Librarian();

    public TextField txtName, txtEmail, txtAddress, txtCity, txtContact;
    public PasswordField txtPassword;
    public Button btnAddLibrarian;
    public Label lblName, psfPassword, lblEmail,lblAddress, lblCity, lblContact;


    public void backAdminSection(ActionEvent event) throws IOException {
        AdminLogIn.getInstance().LoadStage(event, "/views/AdminSection.fxml");
    }

    public void clear() {
        txtName.clear();
        txtEmail.clear();
        txtAddress.clear();
        txtCity.clear();
        txtContact.clear();
    }

    public boolean validate(Librarian librarian) {
        boolean test = true;
        lblName.setVisible(false);
        psfPassword.setVisible(false);
        lblEmail.setVisible(false);
        lblAddress.setVisible(false);
        lblCity.setVisible(false);
        lblContact.setVisible(false);


        if(librarian.getName().isEmpty()) {
            lblName.setVisible(true);
            lblName.setText("required");
            lblName.setTextFill(Color.RED);
            test = false;
        }
        if(librarian.getPassword().isEmpty()) {
            psfPassword.setVisible(true);
            psfPassword.setText("required");
            psfPassword.setTextFill(Color.RED);
            test = false;
        }
        if(librarian.getEmail().isEmpty()) {
            lblEmail.setVisible(true);
            lblEmail.setText("required");
            lblEmail.setTextFill(Color.RED);
            test = false;
        }
        if(librarian.getAddress().isEmpty()) {
            lblAddress.setVisible(true);
            lblAddress.setText("required");
            lblAddress.setTextFill(Color.RED);
            test = false;
        }
        if(librarian.getCity().isEmpty()) {
            lblCity.setVisible(true);
            lblCity.setText("required");
            lblCity.setTextFill(Color.RED);
            test = false;
        }
        if(librarian.getContact().isEmpty()) {
            lblContact.setVisible(true);
            lblContact.setText("required");
            lblContact.setTextFill(Color.RED);
            test = false;
        }
        return test;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnAddLibrarian.setOnAction(e -> {
            String name = txtName.getText();
            String password = txtPassword.getText();
            String email = txtEmail.getText();
            String address = txtAddress.getText();
            String city = txtCity.getText();
            String contact = txtContact.getText();


            librarian.setName(name);
            librarian.setPassword(password);
            librarian.setEmail(email);
            librarian.setAddress(address);
            librarian.setCity(city);
            librarian.setContact(contact);

            if(validate(librarian)) {
                if (LibrarianDAOImpl.getInstance().add(librarian) > 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Librarian" +
                            "  added successfully!");
                    alert.show();

                    if(alert.getResult() == ButtonType.OK) {
                        clear();
                    }
                }
                if(LibrarianDAOImpl.getInstance().add(librarian) < 0){
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Librarian not added!");
                    alert.show();
                }
            }
        });
    }
}
