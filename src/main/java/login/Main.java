package login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 * The type Main.
 */
public class Main extends Application {
    private static Stage primaryStage;

    /**
     * Gets primary stage.
     *
     * @return the primary stage
     */
    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    private static void setPrimaryStage(Stage primaryStage) {
        Main.primaryStage = primaryStage;
    }


    @Override
    public void start(Stage primaryStage) {
        try {
            setPrimaryStage(primaryStage);

            Parent parent = FXMLLoader.load(getClass().getResource("/login.fxml"));
            Scene scene = new Scene(parent);
            //scene.getStylesheets().add(getClass().getResource("/styles/style.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Application for Order food");
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
            Alert errorSendMail = new Alert(Alert.AlertType.ERROR);
            errorSendMail.setTitle("ERROR");
            errorSendMail.setHeaderText("B³¹d");
            errorSendMail.setContentText(e.getMessage());
            errorSendMail.show();
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}

