package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.OrderBO;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.CustomerDAO;
import lk.ijse.dao.custom.OrderDAO;
import lk.ijse.dto.OrderDto;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Date;

public class OrderBOImpl implements OrderBO {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAOType(DAOFactory.DAOType.CUSTOMER);
    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAOType(DAOFactory.DAOType.ORDER);
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
    public boolean transaction(String oId, String odId, Date date, String itemId) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        return false;

    }


}
