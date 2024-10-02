package lk.ijse.bo.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.bo.custom.OrderBO;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.CustomerDAO;
import lk.ijse.dao.custom.ItemDAO;
import lk.ijse.dao.custom.OrderDAO;
import lk.ijse.dao.custom.OrderDetailDAO;
import lk.ijse.dto.OrderDto;
import lk.ijse.entity.Customer;
import lk.ijse.entity.Item;
import lk.ijse.entity.OrderDetails;
import lk.ijse.entity.Orders;
import lk.ijse.entity.tm.OrderTm;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderBOImpl implements OrderBO {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAOType(DAOFactory.DAOType.CUSTOMER);
    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAOType(DAOFactory.DAOType.ORDER);
    OrderDetailDAO orderDetailsDAO = (OrderDetailDAO) DAOFactory.getDaoFactory().getDAOType(DAOFactory.DAOType.ORDER_DETAIL);
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAOType(DAOFactory.DAOType.ITEM);
    @Override
    public boolean save(OrderDto orderDto) {
        return false;
    }

    @Override
    public boolean update(OrderDto orderDto) {
        return false;
    }

    @Override
    public boolean delete(String value) {
        return false;
    }

    @Override
    public OrderDto get(String value) {
        return null;
    }

    @Override
    public String getCurrentId() {
       return orderDAO.getCurrentId();
    }

    @Override
    public void placeOrder(List<OrderTm> orders, String customerId, String total, String qty) {
        List<OrderDetails> odList = new ArrayList<>();
        Orders orders1 = new Orders();
        String orderCurrentId = getOrderCurrentId();
        String availableId = setAvailableId(orderCurrentId);
        System.out.println("available id:"+availableId);
        orders1.setId(availableId);
        orders1.setOrderDetails(odList);
        orders1.setDate(Date.valueOf(LocalDate.now()));
        Customer customer = customerDAO.getObject(customerId);
        orders1.setCustomer(customer);
        for (OrderTm order : orders){
            odList.add(new OrderDetails(1,orders1,new Item(order.getItemCode(),order.getItem(),order.getPrice(),order.getQty(),odList)));
        }
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        boolean isSaved = saveOrder(orders1, session);
        if (isSaved){
            for (int i = 0; i < odList.size(); i++) {
                boolean isSave = saveOrderDetails(odList.get(i), session);
                if (isSave){
                    boolean isUpdated = updateItems(session, odList.get(i).getItem().getItemCode(),qty);
                    if (isUpdated){
                        new Alert(Alert.AlertType.CONFIRMATION,"Order placed successfully").show();
                        transaction.commit();
                    }else {
                        new Alert(Alert.AlertType.ERROR,"Order placed unsuccessfully").show();
                        transaction.rollback();
                        session.close();
                    }
                }else {
                    new Alert(Alert.AlertType.ERROR,"Order placed unsuccessfully").show();
                    transaction.rollback();
                    session.close();
                }
            }
        }else {
            new Alert(Alert.AlertType.ERROR,"Order placed unsuccessfully").show();
            transaction.rollback();
            session.close();
        }
        session.close();
    }

    private Item getItem(String itemCode) {
        return itemDAO.getObject(itemCode);
    }

    private boolean updateItems(Session session, String itemCode, String qty) {
        Item item = itemDAO.getObject(itemCode);
        item.setQty(Integer.parseInt(qty));
        return itemDAO.update(session, item);
    }


    private boolean saveOrderDetails(OrderDetails orderDetails, Session session) {
        return orderDetailsDAO.save(orderDetails,session);
    }

    private boolean saveOrder(Orders orders1, Session session) {
        return orderDAO.save(orders1, session);
    }


    private String setAvailableId(String currentId) {
        if (currentId != null){
            String[] split = currentId.split("O");
            int Idnum = Integer.parseInt(split[1]);
            return split[0] + ++Idnum;
        }
        return "O1";
    }

    private String getOrderCurrentId() {
        return orderDAO.getCurrentId();
    }


}
