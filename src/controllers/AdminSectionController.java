package controllers;
import javafx.event.ActionEvent;
import java.io.IOException;

public class AdminSectionController {

    private static AdminSectionController adminSectionController;

    public AdminSectionController() {

    }

    public static AdminSectionController getInstance() {
        if( adminSectionController == null)
            adminSectionController = new AdminSectionController();
        return adminSectionController;
    }
    public void toAdmin(ActionEvent event) throws IOException {
        AdminLogIn.getInstance().LoadStage(event, "/views/AdminLogIn.fxml");
    }

    public void addLibrarian(ActionEvent event) throws IOException {
        AdminLogIn.getInstance().LoadStage(event, "/views/AddLibrarian.fxml");
    }
    public void backAdminSection(ActionEvent event) throws IOException {
        AdminLogIn.getInstance().LoadStage(event, "/views/AdminSection.fxml");
    }

    public void viewLibrarian(ActionEvent event) throws IOException {
        AdminLogIn.getInstance().LoadStage(event, "/views/ViewLibrarian.fxml");
    }
    public void deleteLibrarian(ActionEvent event) throws IOException {
        AdminLogIn.getInstance().LoadStage(event, "/views/DeleteLibrarian.fxml");
    }
}
