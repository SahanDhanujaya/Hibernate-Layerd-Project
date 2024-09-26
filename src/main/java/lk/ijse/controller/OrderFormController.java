package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.CustomerBO;
import lk.ijse.bo.custom.ItemBO;
import lk.ijse.entity.tm.OrderTm;

import java.time.LocalDate;
import java.util.List;

public class OrderFormController {
    @FXML
    public TextField txtName;
    public TableColumn clmId;
    public TextField txtDate;
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
    private TableView<OrderTm> tblCart;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtQty;

    CustomerBO customerBO = (CustomerBO) BOFactory.getBOFactory().getBOType(BOFactory.BOType.CUSTOMER);
    ItemBO itemBO = (ItemBO) BOFactory.getBOFactory().getBOType(BOFactory.BOType.ITEM);
    public void initialize(){
        setComboCustomer();
        setComboItem();
        setDate();

    }

    private void setDate() {
        txtDate.setText(String.valueOf(LocalDate.now()));
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
        System.out.println("Hiiiiiii");
        OrderTm orderTm = new OrderTm(String.valueOf(cmbItemId.getValue()),txtName.getText(),Double.parseDouble(txtPrice.getText()),Integer.parseInt(txtQty.getText()),new JFXButton("remove"));
        ObservableList<OrderTm> orderTms = FXCollections.observableArrayList();
        int size = tblCart.getItems().size();
        for (int i = 0;i < size; i++){
            OrderTm orderTm1 = tblCart.getItems().get(i);
            orderTms.add(orderTm1);
        }
        orderTms.add(orderTm);
        tblCart.setItems(orderTms);
        setCellValueFactory();
    }

    private void setCellValueFactory() {
        clmId.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        clmItem.setCellValueFactory(new PropertyValueFactory<>("item"));
        clmPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        clmQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        clmRemove.setCellValueFactory(new PropertyValueFactory<>("button"));
    }

    private void setTable(List<OrderTm> order) {
        ObservableList<OrderTm> obList = FXCollections.observableArrayList();
        for (OrderTm orderTm : order) {
            obList.add(new OrderTm(orderTm.getItemCode(), orderTm.getItem(), orderTm.getPrice(), orderTm.getQty(), orderTm.getButton()));

        }
        tblCart.setItems(obList);
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

    public void txtItemOnAction(ActionEvent actionEvent) {
    }
}
