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
import lk.ijse.bo.custom.OrderBO;
import lk.ijse.bo.custom.OrderDetailBO;
import lk.ijse.dto.ItemDto;
import lk.ijse.entity.tm.OrderTm;

import java.time.LocalDate;
import java.util.ArrayList;
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
    OrderBO orderBO = (OrderBO) BOFactory.getBOFactory().getBOType(BOFactory.BOType.ORDER);
    OrderDetailBO orderDetailBO = (OrderDetailBO) BOFactory.getBOFactory().getBOType(BOFactory.BOType.ORDER_DETAIL);
    public void initialize(){
        setComboCustomer();
        setComboItem();
        setDate();
        lblNetTotal.setText("00.0");
        lblQty.setText("000");

    }

    private void setDetails(String value) {
        ItemDto itemDto = itemBO.get(value);
        txtName.setText(itemDto.getName());
        txtPrice.setText(String.valueOf(itemDto.getPrice()));
        lblQty.setText(String.valueOf(itemDto.getQty()));
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
        OrderTm orderTm = new OrderTm(String.valueOf(cmbItemId.getValue()), txtName.getText(), Double.parseDouble(txtPrice.getText()), Integer.parseInt(txtQty.getText()), new JFXButton("remove"));
        ObservableList<OrderTm> obList = FXCollections.observableArrayList();
        int size = tblCart.getItems().size();
        for (int i = 0; i < size; i++) {
            OrderTm orderTm1 = tblCart.getItems().get(i);
            obList.add(orderTm1);
            if (orderTm.getItemCode().equals(clmId.getCellData(i))) {
                int qty = orderTm1.getQty() + Integer.parseInt(txtQty.getText());
                orderTm1.setQty(qty);
                obList.add(orderTm1);
                setCellValueFactory();
                tblCart.refresh();
                calculateNetTotal();
                return;
            }
        }
        obList.add(orderTm);
        tblCart.setItems(obList);
        setCellValueFactory();
        calculateNetTotal();

    }

    private void clearTextFields() {
        txtPrice.clear();
        txtName.clear();
        txtQty.clear();
        lblQty.setText("");
    }

    private void calculateNetTotal() {
        double total = 0;
        for (int i = 0 ; i<tblCart.getItems().size() ; i++){
            int qty = (int) clmQty.getCellData(i);
            double price = (double) clmPrice.getCellData(i);
            total += qty*price;
        }
        lblNetTotal.setText(String.valueOf(total));
    }

    private void setCellValueFactory() {
        clmId.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        clmItem.setCellValueFactory(new PropertyValueFactory<>("item"));
        clmPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        clmQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        clmRemove.setCellValueFactory(new PropertyValueFactory<>("button"));
    }


    @FXML
    void btnPayOnAction(ActionEvent event) {
        String customerId = cmbCustomerId.getValue();
        String total = lblNetTotal.getText();
        String qty = lblQty.getText();
        List<OrderTm> orders = new ArrayList<>();
        for (int i = 0 ; i<tblCart.getItems().size();i++){
            orders.add(tblCart.getItems().get(i));
        }
        orderBO.placeOrder(orders,customerId,total,qty);

    }

    private String createNextId(String currentId) {
        if (currentId != null){
            String[] split = currentId.split("O");
            int idNum = Integer.parseInt(split[1]);
            return split[0] + ++idNum;
        }
        return "O1";
    }

    @FXML
    void cmbIdOnAction(ActionEvent event) {
        setDetails(cmbItemId.getValue());
    }

    @FXML
    void txtPriceOnAction(ActionEvent event) {

    }

    @FXML
    void txtQtyOnAction(ActionEvent event) {
        int currentQty = Integer.parseInt(lblQty.getText());
        int availableQty = currentQty - Integer.parseInt(txtQty.getText());
        lblQty.setText(String.valueOf(availableQty));
        btnAddToCartOnAction(event);

    }

    public void txtItemOnAction(ActionEvent actionEvent) {
    }
}
