package controllers;

import dao.BooksDAOImpl;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import models.Books;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class addBookController implements Initializable {

    public Label lblCallNo, lblName, lblAuthor, lblPublisher, lblQuantity;
    Books book = new Books();
    public TextField txtCallNo,txtName,txtAuthor,txtPublisher, txtQuantity;
    public Button BtnAddBook;



    public void backToLibrarianSection(ActionEvent event) throws IOException {
        LibrarianSection.getInstance().backToLibrarianSection(event);
    }

    public void clear() {
        txtCallNo.clear();
        txtName.clear();
        txtAuthor.clear();
        txtPublisher.clear();
        txtQuantity.clear();
    }
    public boolean validate(Books book) {
        boolean test = true;
        lblCallNo.setVisible(false);
        lblName.setVisible(false);
        lblAuthor.setVisible(false);
        lblPublisher.setVisible(false);
        lblQuantity.setVisible(false);

        if(book.getCallNo().isEmpty()) {
            lblCallNo.setVisible(true);
            lblCallNo.setText("required");
            lblCallNo.setTextFill(Color.RED);
            test = false;
        }
        if(book.getName().isEmpty()) {
            lblName.setVisible(true);
            lblName.setText("required");
            lblName.setTextFill(Color.RED);
            test = false;
        }
        if(book.getAuthor().isEmpty()) {
            lblAuthor.setVisible(true);
            lblAuthor.setText("required");
            lblAuthor.setTextFill(Color.RED);
            test = false;
        }
        if(book.getPublisher().isEmpty()) {
            lblPublisher.setVisible(true);
            lblPublisher.setText("required");
            lblPublisher.setTextFill(Color.RED);
            test = false;
        }
        if(book.getQuantity() < 1) {
            lblQuantity.setVisible(true);
            lblQuantity.setText("required");
            lblQuantity.setTextFill(Color.RED);
            test = false;
        }

        return test;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblCallNo.setVisible(false);
        lblName.setVisible(false);
        lblAuthor.setVisible(false);
        lblPublisher.setVisible(false);
        lblQuantity.setVisible(false);

        BtnAddBook.setOnAction(e -> {
            String call_no = txtCallNo.getText();
            String name = txtName.getText();
            String author = txtAuthor.getText();
            String publisher = txtPublisher.getText();
            int quantity = Integer.parseInt(txtQuantity.getText().isEmpty() ? "0" : txtQuantity.getText());

            book.setCallNo(call_no);
            book.setName(name);
            book.setAuthor(author);
            book.setPublisher(publisher);
            book.setQuantity(quantity);
            book.setIssued(0);

            if(validate(book)) {
                if (BooksDAOImpl.getInstance().add(book) > 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Books" +
                            "  added successfully!");
                    alert.show();
                    if(alert.getResult() == ButtonType.OK) {
                        clear();
                    }
                }
                if(BooksDAOImpl.getInstance().add(book) < 0) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Books not added successfully!");
                    alert.show();
                }
            }
        });
    }
}
