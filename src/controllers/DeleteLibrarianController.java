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

public class DeleteLibrarianController implements Initializable {


    public TextField txtId;
    public Button btnDelete;
    public Label lblRequired;
    public void backToAdminSection(ActionEvent event) throws IOException {
        AdminSectionController.getInstance().backAdminSection(event);
    }

    public void clear() {
        txtId.clear();
    }
    public boolean validate() {
        boolean test = true;
        lblRequired.setVisible(false);

        if(txtId.getText().isEmpty()) {
            test = false;
            lblRequired.setVisible(true);
            lblRequired.setText("required");
            lblRequired.setTextFill(Color.RED);
        }
        return test;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblRequired.setVisible(false);
        btnDelete.setOnAction(e -> {
            int id = Integer.parseInt(txtId.getText().isEmpty()? "0" : txtId.getText());

            Librarian librarian = LibrarianDAOImpl.getInstance().get(id);

            if(validate()) {
                if(librarian == null){
                    new Alert(Alert.AlertType.INFORMATION,"Librarian does not exist!").showAndWait();
                    return;
                }
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete " + librarian.getName() + " ?");
                alert.showAndWait();
                if (alert.getResult() == ButtonType.OK) {
                    if(LibrarianDAOImpl.getInstance().delete(id) > 0) {
                        alert = new Alert(Alert.AlertType.CONFIRMATION, "Librarian " + librarian.getName() + " was deleted successfully!");
                        alert.showAndWait();
                        if(alert.getResult() == ButtonType.OK) {
                            clear();
                        }
                    }

                }
            }
        });
    }
}
