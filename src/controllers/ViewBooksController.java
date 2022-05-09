package controllers;

import dao.BooksDAOImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Books;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class ViewBooksController implements Initializable {

    @FXML
    private TableColumn<Books, String> added_date;

    @FXML
    private TableColumn<Books, String> author;

    @FXML
    private TableColumn<Books, String> callNo;

    @FXML
    private TableColumn<Books, String> id;

    @FXML
    private TableColumn<Books, String> issued;

    @FXML
    private TableColumn<Books, String> name;

    @FXML
    private TableColumn<Books, String> publisher;

    @FXML
    private TableColumn<Books, String> quantity;

    @FXML
    private TableView<Books> tblViewBooks;

     public void backToLibrarianSection(ActionEvent event) throws IOException {
         LibrarianSection.getInstance().backToLibrarianSection(event);
     }

     public void initializeWidgets() {
         quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
         publisher.setCellValueFactory(new PropertyValueFactory<>("publisher"));
         name.setCellValueFactory(new PropertyValueFactory<>("name"));
         issued.setCellValueFactory(new PropertyValueFactory<>("issued"));
         id.setCellValueFactory(new PropertyValueFactory<>("book_id"));
         callNo.setCellValueFactory(new PropertyValueFactory<>("callNo"));
         author.setCellValueFactory(new PropertyValueFactory<>("author"));
         added_date.setCellValueFactory(new PropertyValueFactory<>("added_date"));
     }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeWidgets();
        List<Books> all = BooksDAOImpl.getInstance().getAll();
        ObservableList<Books> observableList =  FXCollections.observableArrayList();
        observableList.addAll(all);
        tblViewBooks.setItems(observableList);
    }
}
