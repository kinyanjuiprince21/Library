package controllers;

import dao.BooksDAOImpl;
import dao.IssueBookDAOImpl;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import models.Books;
import models.IssueBooks;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class returnBookController implements Initializable {

    public TextField txtCallNo, txtStudentId;
    public Button btnReturnBook;
    public Label lblCallNo, lblStudentId;


    public void backToLibrarianSection(ActionEvent event) throws IOException {
        LibrarianSection.getInstance().backToLibrarianSection(event);
    }

    public boolean validate() {
        boolean test = true;
        lblCallNo.setVisible(false);
        lblStudentId.setVisible(false);

        if(txtCallNo.getText().isEmpty()) {
            lblCallNo.setVisible(true);
            lblCallNo.setText("required");
            lblCallNo.setTextFill(Color.RED);
            test = false;

        }
        if(txtStudentId.getText().isEmpty()) {
            lblStudentId.setVisible(true);
            lblStudentId.setText("required");
            lblStudentId.setTextFill(Color.RED);
            test = false;
        }
        return test;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblCallNo.setVisible(false);
        lblStudentId.setVisible(false);
        btnReturnBook.setOnAction(e -> {

            String callNo = txtCallNo.getText();
            int studentId = Integer.parseInt(txtStudentId.getText().isEmpty()? "0" : txtStudentId.getText());

            IssueBooks issueBooks = IssueBookDAOImpl.getInstance().get("Select * from issue_books where book_call_no=? and student_id=?", callNo, studentId);

            if(validate()) {
                if(issueBooks == null){
                    new Alert(Alert.AlertType.ERROR, "Sorry, unable to return the book!").showAndWait();
                    return;
                }
                IssueBookDAOImpl.getInstance().delete(issueBooks.getIssuedBook_id());
                Books book = BooksDAOImpl.getInstance().getByCallNo(callNo);
                book.setQuantity(book.getQuantity() + 1);
                book.setIssued(book.getIssued() - 1);
                BooksDAOImpl.getInstance().update(book);
                new Alert(Alert.AlertType.CONFIRMATION, "Book with call no " + issueBooks.getBook_call_no() + " has been successfully returned!").showAndWait();

            }

        });
    }
}
