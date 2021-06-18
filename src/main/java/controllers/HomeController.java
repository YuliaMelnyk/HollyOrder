package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import login.Main;
import model.CartItem;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;

/**
 * The type Home controller.
 * Class controller for page home.fxml
 *
 * @author yuliiamelnyk on 2/9/21
 * @project HollyOrder
 */

public class HomeController extends BaseController implements Initializable {

    /**
     * The Cart tab.
     */
    @FXML
    Tab cartTab;

    /**
     * The Scroll pane.
     */
    @FXML
    ScrollPane scrollPane;

    @FXML
    private TableView<CartItem> cartTable;
    @FXML
    private TableColumn<CartItem, Long> id;
    @FXML
    private TableColumn<CartItem, Timestamp> timestamp;
    @FXML
    private TableColumn<CartItem, Double> totalPrice;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            addCartElements(scrollPane);
            addToOrder(cartTable, id, timestamp, totalPrice);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Click finger.
     * click en category of Finger Foods
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void clickFinger(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/fingerfoods.fxml"));
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(getClass().getResource("/styles/fingerFoodStyle.css").toExternalForm());
        Main.getPrimaryStage().setScene(scene);
    }

    /**
     * Click western.
     * click en category of Western Soups
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void clickWestern(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/soup.fxml"));
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(getClass().getResource("/styles/soup.css").toExternalForm());
        Main.getPrimaryStage().setScene(scene);
    }

    /**
     * Click sandwiches.
     * click en category of Sandwiches
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void clickSandwiches(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/sandwiches.fxml"));
        Scene scene = new Scene(parent);
        Main.getPrimaryStage().setScene(scene);
    }

    /**
     * Click salads.
     * click en category of Salads
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void clickSalads(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/salads.fxml"));
        Scene scene = new Scene(parent);
        Main.getPrimaryStage().setScene(scene);
    }

    /**
     * Click chicken.
     * click en category of Chicken
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void clickChicken(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/chicken.fxml"));
        Scene scene = new Scene(parent);
        Main.getPrimaryStage().setScene(scene);
    }

    /**
     * Click burger.
     * click en category of Burgers
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void clickBurger(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/burger.fxml"));
        Scene scene = new Scene(parent);
        Main.getPrimaryStage().setScene(scene);
    }

    /**
     * Click drinks.
     * click en category of Drinks
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void clickDrinks(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/drinks.fxml"));
        Scene scene = new Scene(parent);
        Main.getPrimaryStage().setScene(scene);
    }

    /**
     * Click desserts.
     * click en category of Desserts
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void clickDesserts(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/dessert.fxml"));
        Scene scene = new Scene(parent);
        Main.getPrimaryStage().setScene(scene);
    }

    /**
     * Click on table.
     *
     * @param mouseEvent the mouse event
     * @throws IOException the io exception
     */
    public void clickOnTable(MouseEvent mouseEvent) throws IOException {
        clickOnRowTableOrder(cartTable);
    }
}
