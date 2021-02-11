package controllers;

import dao.DAO.CartDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import login.Main;
import model.Product;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author yuliiamelnyk on 2/9/21
 * @project HollyOrder
 */

public class HomeController implements Initializable {

    //list of products that add to card
    public static List<Product> products = new ArrayList<>();

    public static HashMap<Integer, Product> cartItems = new HashMap<>();




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            addCartElements();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //click en category of Finger Foods
    @FXML
    public void clickFinger(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/fingerfoods.fxml"));
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(getClass().getResource("/styles/fingerFoodStyle.css").toExternalForm());
        Main.getPrimaryStage().setScene(scene);
    }

    //click en category of Western Soups
    @FXML
    public void clickWestern(MouseEvent event) throws IOException {

        Parent parent = FXMLLoader.load(getClass().getResource("/soup.fxml"));
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(getClass().getResource("/styles/soup.css").toExternalForm());
        Main.getPrimaryStage().setScene(scene);
    }


    //click en category of Sandwiches
    @FXML
    public void clickSandwiches(MouseEvent event) throws IOException {

        Parent parent = FXMLLoader.load(getClass().getResource("/sandwiches.fxml"));
        Scene scene = new Scene(parent);
        Main.getPrimaryStage().setScene(scene);
    }

    //click en category of Salads
    @FXML
    public void clickSalads(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/salads.fxml"));
        Scene scene = new Scene(parent);
        Main.getPrimaryStage().setScene(scene);
    }

    //click en category of Chicken
    @FXML
    public void clickChicken(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/chicken.fxml"));
        Scene scene = new Scene(parent);
        Main.getPrimaryStage().setScene(scene);
    }

    //click en category of Burgers
    @FXML
    public void clickBurger(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/burger.fxml"));
        Scene scene = new Scene(parent);
        Main.getPrimaryStage().setScene(scene);
    }

    //click en category of Drinks
    @FXML
    public void clickDrinks(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/drinks.fxml"));
        Scene scene = new Scene(parent);
        Main.getPrimaryStage().setScene(scene);
    }

    //click en category of Desserts
    @FXML
    public void clickDesserts(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/dessert.fxml"));
        Scene scene = new Scene(parent);
        Main.getPrimaryStage().setScene(scene);
    }

    //method using foreach to take element book and fill fxml element in positions in gridpane
    private void addCartElements() throws IOException {

        GridPane gridPane = new GridPane();
        gridPane.setVgap(200);
        gridPane.setHgap(200);

        int index = -1;


        for (Product product : products) {
            index++;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/product_item.fxml"));
            VBox hb = (VBox) loader.load();
            hb.setMinHeight(350);

            //set isbn
            String Name = product.getName();

            //((Label) loader.getNamespace().get("quantity")).setText(currentISBN);
            //put image value en label from DB
            if (product.getImage() != null) {
                Image image = new Image(new ByteArrayInputStream(product.getImage()));
                ((ImageView) loader.getNamespace().get("productImage")).setImage(image);
            }
            //put name value en label from DB
            ((Label) loader.getNamespace().get("name")).setText(product.getName());

            //add each element in gridpane
            gridPane.add(hb, index % 2, index/2);
        }
    }
}
