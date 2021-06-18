package home;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import model.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;


import java.io.IOException;

/**
 * The type Home.
 */
public class Home extends Application {

    @Override
    public void start(Stage stage) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("home.fxml"));

            //var personController = new HomeController(new User());
            //fxmlLoader.setController(personController);

            Pane root = (Pane)fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch(IOException exception){
            System.out.println(exception.getMessage());
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch();
    }
}
