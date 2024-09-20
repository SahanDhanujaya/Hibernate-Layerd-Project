package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.OrderDAO;
import lk.ijse.entity.Order;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public boolean save(Order object) {
        return false;
    }

    @Override
    public boolean update(Order object) {
        return false;
    }

    @Override
    public boolean delete(String value) {
        return false;
    }

    @Override
    public Order get(String value) {
        return null;
    }
}
