package controllers;

import dao.IssueBookDAOImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.IssueBooks;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewIssuedBookController implements Initializable {

    @FXML
    private TableColumn<IssueBooks, String> bookCallNo;

    @FXML
    private TableColumn<IssueBooks, String> id;

    @FXML
    private TableColumn<IssueBooks, String> issuedDate;

    @FXML
    private TableColumn<IssueBooks, String> studentContact;

    @FXML
    private TableColumn<IssueBooks, String> studentId;

    @FXML
    private TableColumn<IssueBooks, String> studentName;

    @FXML
    private TableView<IssueBooks> tblViewIssuedBook;


    public void initializeWidgets() {
        studentName.setCellValueFactory(new PropertyValueFactory<>("student_name"));
        studentId.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        studentContact.setCellValueFactory(new PropertyValueFactory<>("student_contact"));
        issuedDate.setCellValueFactory(new PropertyValueFactory<>("issued_date"));
        id.setCellValueFactory(new PropertyValueFactory<>("issuedBook_id"));
        bookCallNo.setCellValueFactory(new PropertyValueFactory<>("book_call_no"));
    }
    public void backToLibrarianSection(ActionEvent event) throws IOException {
        LibrarianSection.getInstance().backToLibrarianSection(event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeWidgets();
        ObservableList<IssueBooks> observableList = FXCollections.observableArrayList(IssueBookDAOImpl.getInstance().getAll());
        tblViewIssuedBook.setItems(observableList);
    }
}
