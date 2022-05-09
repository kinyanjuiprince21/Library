package controllers;

import javafx.event.ActionEvent;
import java.io.IOException;

public class LibrarianSection {
    private static LibrarianSection librarianSection;

    public LibrarianSection() {

    }

    public static  LibrarianSection getInstance() {
        if(librarianSection == null)
            librarianSection = new LibrarianSection();
        return librarianSection;
    }
    public void toLogInForm(ActionEvent event) throws IOException {
        LibraryController.getInstance().toLogin(event);
    }
    public void addBooks(ActionEvent event) throws IOException {
        AdminLogIn.getInstance().LoadStage(event, "/views/addBooks.fxml");
    }

    public void viewBooks(ActionEvent event) throws IOException {
        AdminLogIn.getInstance().LoadStage(event, "/views/ViewBooks.fxml");
    }
    public void backToLibrarianSection(ActionEvent event) throws IOException {
        AdminLogIn.getInstance().LoadStage(event, "/views/LibrarianSection.fxml");
    }

    public void issueBook (ActionEvent event) throws IOException {
        AdminLogIn.getInstance().LoadStage(event, "/views/IssueBooks.fxml");
    }

    public void returnBook(ActionEvent event) throws IOException {
        AdminLogIn.getInstance().LoadStage(event, "/views/ReturnBook.fxml");
    }

    public void viewIssuedBook(ActionEvent event) throws IOException {
        AdminLogIn.getInstance().LoadStage(event, "/views/ViewIssuedBook.fxml");
    }
}
