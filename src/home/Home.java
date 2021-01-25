package home;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import model.Person;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;


import java.io.IOException;

public class Home extends Application {

    @Override
    public void start(Stage stage) {
        try{
            var fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("home.fxml"));

            var personController = new HomeController(new Person());
            fxmlLoader.setController(personController);

            var root = (Pane)fxmlLoader.load();
            var scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch(IOException exception){
            System.out.println(exception.getMessage());
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
