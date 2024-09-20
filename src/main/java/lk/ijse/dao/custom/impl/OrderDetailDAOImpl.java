package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.OrderDetailDAO;
import lk.ijse.entity.OrderDetails;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    @Override
    public boolean save(OrderDetails object) {
        return false;
    }

    @Override
    public boolean update(OrderDetails object) {
        return false;
    }

    @Override
    public boolean delete(String value) {
        return false;
    }

    @Override
    public OrderDetails get(String value) {
        return null;
    }
}
