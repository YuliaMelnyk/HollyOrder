package controllers;

import dao.DAO.ProductDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.CartItem;
import model.Product;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static controllers.LoginController.productsDetailOrder;

/**
 * @author yuliiamelnyk on 29/3/21
 * @project HollyOrder
 */

// Window show when user clicked to row in the table of Orders

public class OrderDetailContainer extends BaseController implements Initializable {

    private ProductDAO productDAO = new ProductDAO();

    @FXML
    Label productNameDetailOrder;

    @FXML
    ImageView productImageDetail;

    @FXML
    ScrollPane detailScroll;

    @FXML
    private TableView<CartItem> cartTable;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        GridPane gridPane = new GridPane();
        // set paddings
        gridPane.setVgap(20);
        gridPane.setHgap(20);

        detailScroll.setContent(gridPane);
        int index = -1;
        for (Product product: productsDetailOrder
             ) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/product_item_order_detail.fxml"));
            VBox vBox = null;
            try {
                vBox = (VBox) loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            vBox.setMaxHeight(250);
            //productNameDetailOrder.setText(x.getName());
            String name = product.getName();
            //put image value en label from DB
            if (product.getImage() != null) {
                // create a background image
                Image image = new Image(new ByteArrayInputStream(product.getImage()));
                // set background image
                ((ImageView) loader.getNamespace().get("productImage")).setImage(image);
            }

            //put name value en label from DB
            ((Label) loader.getNamespace().get("name")).setText(product.getName());
            //add each element in gridpane
            gridPane.add(vBox, index % 2, index / 2);
        }
        productsDetailOrder.forEach(x ->
        {

        });
    }

    // When the user clicked on OK button to close the window
    @FXML
    public void btnAcceptClicked(ActionEvent event) throws IOException {
        closeStage(event);
    }

    // In the finish we close the window
    private void closeStage(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }


    // click on row in the table Order to open the details of order
/*    public void clickOnRowTableOrder(TableView<CartItem> cartTable) throws IOException {

        List<Product> products = productDAO.getAll();

        cartTable.getSelectionModel().setCellSelectionEnabled(true);
        ObservableList selectedCells = cartTable.getSelectionModel().getSelectedCells();

        selectedCells.addListener((ListChangeListener) c -> {
            CartItem rowData = cartTable.getSelectionModel().getSelectedItem();

            if (rowData.getProductIds() != null) {
                List<String> productIds = Arrays.asList(rowData.getProductIds().split(",").clone());
                List<Product> productItems = products.stream().filter(x -> productIds.contains(x.getProductIdString())).collect(Collectors.toList());

                GridPane gridPane = new GridPane();
                // set paddings
                gridPane.setVgap(20);
                gridPane.setHgap(20);

                //cartTab.setContent(gridPane);
                detailScroll.setContent(gridPane);

                int index = -1;

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/product_item_order_detail.fxml"));
                VBox vBox = null;
                try {
                    vBox = (VBox) loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                vBox.setMaxHeight(250);

                VBox finalVBox = vBox;
                productItems.forEach(x ->
                {
                    System.out.println(x.getName());
                    // set name
                    String name = x.getName();
                    //put image value en label from DB
                    if (x.getImage() != null) {
                        // create a background image
                        Image image = new Image(new ByteArrayInputStream(x.getImage()));
                        // set background image
                        ((ImageView) loader.getNamespace().get("productImage")).setImage(image);
                    }

                    //put name value en label from DB
                    ((Label) loader.getNamespace().get("name")).setText(x.getName());
                    //add each element in gridpane
                    gridPane.add(finalVBox, index % 2, index / 2);
                });

                ((Label) loader.getNamespace().get("totalPrice")).setText(String.valueOf(rowData.getTotalPrice()));

            }
        });
    }*/
}
