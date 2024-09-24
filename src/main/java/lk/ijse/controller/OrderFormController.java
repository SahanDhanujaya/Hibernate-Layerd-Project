package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.CustomerBO;
import lk.ijse.bo.custom.ItemBO;

import java.util.List;

public class OrderFormController {

    @FXML
    private TableColumn<?, ?> clmItem;

    @FXML
    private TableColumn<?, ?> clmPrice;

    @FXML
    private TableColumn<?, ?> clmQty;

    @FXML
    private TableColumn<?, ?> clmRemove;

    @FXML
    private ComboBox<String> cmbCustomerId;

    @FXML
    private ComboBox<String> cmbItemId;

    @FXML
    private DatePicker date;

    @FXML
    private Label lblNetTotal;

    @FXML
    private Label lblQty;

    @FXML
    private AnchorPane pane;

    @FXML
    private TableView<?> tblCart;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtQty;

    CustomerBO customerBO = (CustomerBO) BOFactory.getBOFactory().getBOType(BOFactory.BOType.CUSTOMER);
    ItemBO itemBO = (ItemBO) BOFactory.getBOFactory().getBOType(BOFactory.BOType.ITEM);
    public void initialize(){
        setComboCustomer();
        setComboItem();
    }

    private void setComboItem() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        List<String> ids = itemBO.getIds();
        for (String id : ids){
            obList.add(id);
        }
        cmbItemId.setItems(obList);
    }

    private void setComboCustomer() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        List<String> ids = customerBO.getIds();
        for (String id : ids){
            obList.add(id);
        }
        cmbCustomerId.setItems(obList);
    }

    @FXML
    void btnAddToCartOnAction(ActionEvent event) {

    }

    @FXML
    void btnPayOnAction(ActionEvent event) {

    }

    @FXML
    void cmbIdOnAction(ActionEvent event) {

    }

    @FXML
    void txtPriceOnAction(ActionEvent event) {

    }

    @FXML
    void txtQtyOnAction(ActionEvent event) {

    }

}
