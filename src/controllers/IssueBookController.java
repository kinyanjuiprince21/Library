package controllers;

import dao.BooksDAOImpl;
import dao.IssueBookDAOImpl;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import models.Books;
import models.IssueBooks;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class IssueBookController implements Initializable {

    public Label lblCallNo, lblStudentId, lblStudentName, lblStudentContact;
    IssueBooks issueBooks = new IssueBooks();
    public TextField txtCallNo, txtStudentId, txtStudentName, txtStudentContact;
    public Button btnIssueBook;



    public void backToLibrarianSection(ActionEvent event) throws IOException {
        LibrarianSection.getInstance().backToLibrarianSection(event);
    }

    public void clear() {
        txtCallNo.clear();
        txtStudentId.clear();
        txtStudentName.clear();
        txtStudentContact.clear();
    }

    public boolean validate(IssueBooks issueBooks) {
        boolean test = true;
        lblCallNo.setVisible(false);
        lblStudentId.setVisible(false);
        lblStudentName.setVisible(false);
        lblStudentContact.setVisible(false);

        if(issueBooks.getBook_call_no().isEmpty()) {
            lblCallNo.setVisible(true);
            lblCallNo.setText("required");
            lblCallNo.setTextFill(Color.RED);
            test = false;
        }
        if(issueBooks.getStudent_id() < 1) {
            lblStudentId.setVisible(true);
            lblStudentId.setText("required");
            lblStudentId.setTextFill(Color.RED);
            test = false;
        }
        if(issueBooks.getStudent_name().isEmpty()) {
            lblStudentName.setVisible(true);
            lblStudentName.setText("required");
            lblStudentName.setTextFill(Color.RED);
            test = false;
        }
        if(issueBooks.getStudent_contact().isEmpty()) {
            lblStudentContact.setVisible(true);
            lblStudentContact.setText("required");
            lblStudentContact.setTextFill(Color.RED);
            test = false;
        }

        return test;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        lblCallNo.setVisible(false);
        lblStudentId.setVisible(false);
        lblStudentName.setVisible(false);
        lblStudentContact.setVisible(false);

        btnIssueBook.setOnAction(e -> {
            String book_call_no = txtCallNo.getText();
            int student_id = Integer.parseInt(txtStudentId.getText().isEmpty()? "0":txtStudentId.getText());
            String student_name = txtStudentName.getText();
            String student_contact = txtStudentContact.getText();

            issueBooks.setBook_call_no(book_call_no);
            issueBooks.setStudent_id(student_id);
            issueBooks.setStudent_name(student_name);
            issueBooks.setStudent_contact(student_contact);

            Books book = BooksDAOImpl.getInstance().getByCallNo(txtCallNo.getText());

            if(validate(issueBooks)) {
                if(book == null) {
                    new Alert(Alert.AlertType.ERROR, "Book with call no " + txtCallNo.getText() + " does not exist").showAndWait();
                    return;
                }
                if(book.getQuantity() < 1) {
                    new Alert(Alert.AlertType.WARNING,
                            "Book with call no " + book.getCallNo() + " out of stock!").showAndWait();
                    return;
                }
                if(IssueBookDAOImpl.getInstance().add(issueBooks) > 0) {
                    book.setQuantity(book.getQuantity() - 1);
                    book.setIssued(book.getIssued() + 1);
                    BooksDAOImpl.getInstance().update(book);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Book Issued successfully!");
                    alert.showAndWait();
                    if(alert.getResult() == ButtonType.OK) {
                        clear();
                    }
                }
                if(IssueBookDAOImpl.getInstance().add(issueBooks) < 0) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Book not Issued!");
                    alert.show();
                }
            }
        });
    }
}
