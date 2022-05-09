package controllers;


import javafx.event.ActionEvent;

import java.io.IOException;

public class LibraryController {
    private static LibraryController libraryController;

    public LibraryController(){}

    public static LibraryController getInstance() {
        if(libraryController == null)
            libraryController = new LibraryController();
        return libraryController;
    }
    public  void toAdminLogIn(ActionEvent event) throws IOException {
        AdminLogIn.getInstance().LoadStage(event, "/views/AdminLogIn.fxml");
    }

    public void toLogin(ActionEvent event) throws IOException {
        AdminLogIn.getInstance().LoadStage(event, "/views/LogInForm.fxml");
    }
}
