package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import login.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type Window accept controller.
 * Window alert that open when you click Place to the Order
 *
 * @author yuliiamelnyk on 18/2/21
 * @project HollyOrder
 */

public class WindowAcceptController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    /**
     * Btn accept clicked.
     * When the user clicked on OK button he will return to Home page
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void btnAcceptClicked(ActionEvent event) throws IOException {
        System.out.println("btnAddPersonClicked");

        Parent parent = FXMLLoader.load(getClass().getResource("/home.fxml"));
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(getClass().getResource("/styles/homeStyle.css").toExternalForm());
        Main.getPrimaryStage().setScene(scene);

        closeStage(event);

    }

    // In the finish we close the window
    private void closeStage(ActionEvent event) {
        Node  source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
