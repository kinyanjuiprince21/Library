package controllers;

import dao.LibrarianDAOImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Librarian;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewLibrarianController implements Initializable {
    @FXML
    private TableColumn<Librarian, String> address;

    @FXML
    private TableColumn<Librarian, String> city;

    @FXML
    private TableColumn<Librarian, String> contact;

    @FXML
    private TableColumn<Librarian, String> email;

    @FXML
    private TableColumn<Librarian, Integer> id;

    @FXML
    private TableColumn<Librarian, String> name;

    @FXML
    private TableColumn<Librarian, String> password;

    @FXML
    private TableView<Librarian> tblViewLibrarian;


    public void backAdminSection(ActionEvent event) throws IOException {
        AdminSectionController.getInstance().backAdminSection(event);
    }

    public void initWidgets() {
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        password.setCellValueFactory(new PropertyValueFactory<>("password"));
        id.setCellValueFactory(new PropertyValueFactory<>("librarian_id"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        city.setCellValueFactory(new PropertyValueFactory<>("city"));
        contact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initWidgets();
        ObservableList<Librarian> observableList = FXCollections.observableArrayList(LibrarianDAOImpl.getInstance().getAll());
        tblViewLibrarian.setItems(observableList);
    }
}
