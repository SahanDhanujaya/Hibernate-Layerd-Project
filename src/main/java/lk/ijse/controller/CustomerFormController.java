package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.bo.custom.CustomerBO;
import lk.ijse.bo.custom.impl.CustomerBOImpl;
import lk.ijse.dto.CustomerDto;
import lk.ijse.entity.CustomerTm;

import java.util.List;

public class CustomerFormController {

    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtEmail;
    public TextField txtContact;
    public Button btnSave;
    public Button btnUpdate;
    public Button btnDelete;
    public TableView<CustomerTm>tblCustomer;
    public TableColumn<?,?> clmId;
    public TableColumn<?,?> clmName;
    public TableColumn<?,?> clmAddress;
    public TableColumn<?,?> clmEmail;
    public TableColumn<?,?> clmContact;
    CustomerBO customerBO = new CustomerBOImpl();

    public void initialize(){
        setTable();
        setCellValueFactory();
    }

    private void setCellValueFactory() {
        clmId.setCellValueFactory(new PropertyValueFactory<>("id"));
        clmName.setCellValueFactory(new PropertyValueFactory<>("name"));
        clmAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        clmEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        clmContact.setCellValueFactory(new PropertyValueFactory<>("tel"));
    }

    private void setTable() {
        ObservableList<CustomerTm> customerTms = FXCollections.observableArrayList();
        List<CustomerDto> all = customerBO.getAll();
        for (CustomerDto customerDto : all){
            CustomerTm customerTm = new CustomerTm(customerDto.getId(), customerDto.getName(), customerDto.getAddress(), customerDto.getTel(), customerDto.getEmail());
            customerTms.add(customerTm);
        }
        tblCustomer.setItems(customerTms);
    }

    public void txtIdOnAction(ActionEvent actionEvent) {
        txtName.requestFocus();
    }

    public void txtNameOnAction(ActionEvent actionEvent) {
        txtAddress.requestFocus();
    }

    public void txtAddressOnAction(ActionEvent actionEvent) {
        txtEmail.requestFocus();
    }

    public void txtEmailOnAction(ActionEvent actionEvent) {
        txtContact.requestFocus();
    }

    public void txtContactOnAction(ActionEvent actionEvent) {
        btnSaveOnAction(actionEvent);
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        boolean isSaved = customerBO.save(new CustomerDto(txtId.getText(), txtName.getText(), txtAddress.getText(), Integer.parseInt(txtContact.getText()), txtEmail.getText()));
        if (isSaved){
            setTable();
            setCellValueFactory();
            tblCustomer.refresh();
            new Alert(Alert.AlertType.CONFIRMATION,"Customer save successfully").show();
        } else {
            new Alert(Alert.AlertType.ERROR,"Customer save unsuccessfully").show();
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        boolean isUpdated = customerBO.update(new CustomerDto(txtId.getText(), txtName.getText(), txtAddress.getText(), Integer.parseInt(txtContact.getText()), txtEmail.getText()));
        if (isUpdated){
            setTable();
            setCellValueFactory();
            tblCustomer.refresh();
            new Alert(Alert.AlertType.CONFIRMATION,"Customer update successfully").show();
        } else {
            new Alert(Alert.AlertType.ERROR,"Customer update unsuccessfully").show();
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        boolean isDeleted = customerBO.delete(new CustomerDto(txtId.getText(), txtName.getText(), txtAddress.getText(), Integer.parseInt(txtContact.getText()), txtEmail.getText()));
        if (isDeleted){
            setTable();
            setCellValueFactory();
            tblCustomer.refresh();
            new Alert(Alert.AlertType.CONFIRMATION,"Customer delete successfully").show();
        } else {
            new Alert(Alert.AlertType.ERROR,"Customer delete unsuccessfully").show();
        }
    }
}
