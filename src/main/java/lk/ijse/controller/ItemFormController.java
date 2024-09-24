package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.ItemBO;
import lk.ijse.dto.ItemDto;
import lk.ijse.entity.tm.ItemTm;

import java.util.List;

public class ItemFormController {

    public AnchorPane rootNode;
    @FXML
    private TableColumn<?, ?> clmId;

    @FXML
    private TableColumn<?, ?> clmItem;

    @FXML
    private TableColumn<?, ?> clmPrice;

    @FXML
    private TableColumn<?, ?> clmQty;

    @FXML
    private TableView<ItemTm> tblItem;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtItem;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtQty;

    ItemBO itemBO = (ItemBO) BOFactory.getBOFactory().getBOType(BOFactory.BOType.ITEM);

    public void initialize(){
        setItemTable();
        setCellValueFactory();
        tableSelection();
        generateItemId();
    }
    void clearFields(){
        txtId.clear();
        txtItem.clear();
        txtPrice.clear();
        txtQty.clear();
    }
    private String generateItemId() {
        try {
            String currentId = itemBO.getCurrentId();
            if (currentId != null) {
                String[] split = currentId.split("I00");
                int idNum = Integer.parseInt(split[1]);
                 String availableId = "I00" + ++idNum;
                 txtId.setText(availableId);
                 return availableId;
            } else {
                txtId.setText("I001");
                return "I001";
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    private void tableSelection() {
        tblItem.setOnMouseClicked(event -> {
            int index = tblItem.getSelectionModel().getSelectedIndex();
            txtId.setText(String.valueOf(clmId.getCellData(index)));
            txtItem.setText(String.valueOf(clmItem.getCellData(index)));
            txtPrice.setText(String.valueOf(clmPrice.getCellData(index)));
            txtQty.setText(String.valueOf(clmQty.getCellData(index)));
        });
    }

    private void setCellValueFactory() {
        clmId.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        clmItem.setCellValueFactory(new PropertyValueFactory<>("name"));
        clmPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        clmQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
    }

    private void setItemTable() {
        ObservableList<ItemTm> obList = FXCollections.observableArrayList();
        List<ItemDto> items = itemBO.getAll();
        for (ItemDto itemDto : items){
            ItemTm itemTm = new ItemTm(
                    itemDto.getItemCode(),
                    itemDto.getName(),
                    itemDto.getPrice(),
                    itemDto.getQty()
            );
            obList.add(itemTm);
        }
        tblItem.setItems(obList);
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        boolean isDeleted = itemBO.delete(new ItemDto(txtItem.getText(), txtItem.getText(), Double.parseDouble(txtPrice.getText()), Integer.parseInt(txtQty.getText())));
        if (isDeleted) {
            clearFields();
            setItemTable();
            setCellValueFactory();
            tblItem.refresh();
            new Alert(Alert.AlertType.CONFIRMATION, "Item deleted successfully").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Item deleted unsuccessfully");
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        boolean isSaved = itemBO.save(new ItemDto(txtId.getText(), txtItem.getText(), Double.parseDouble(txtPrice.getText()), Integer.parseInt(txtQty.getText())));
        if (isSaved) {
            clearFields();
            txtId.setText(generateItemId());
            setItemTable();
            setCellValueFactory();
            tblItem.refresh();
            new Alert(Alert.AlertType.CONFIRMATION, "Item saved successfully").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Item saved unsuccessfully");
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        boolean isUpdated = itemBO.update(new ItemDto(txtId.getText(), txtItem.getText(), Double.parseDouble(txtPrice.getText()), Integer.parseInt(txtQty.getText())));
        if (isUpdated) {
            clearFields();
            setItemTable();
            setCellValueFactory();
            tblItem.refresh();
            new Alert(Alert.AlertType.CONFIRMATION, "Item updated successfully").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Item updated unsuccessfully");
        }
    }

    @FXML
    void txtIdOnAction(ActionEvent event) {
        txtItem.requestFocus();
    }

    @FXML
    void txtItemOnAction(ActionEvent event) {
        txtPrice.requestFocus();
    }

    @FXML
    void txtPriceOnAction(ActionEvent event) {
        txtQty.requestFocus();
    }

    @FXML
    void txtQtyOnAction(ActionEvent event) {
        btnSaveOnAction(event);
    }

}
