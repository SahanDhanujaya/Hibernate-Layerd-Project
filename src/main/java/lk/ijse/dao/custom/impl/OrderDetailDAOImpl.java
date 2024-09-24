package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.OrderDetailDAO;
import lk.ijse.entity.OrderDetails;

import java.util.List;

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
    public boolean delete(OrderDetails value) {
        return false;
    }

    @Override
    public OrderDetails get(OrderDetails value) {
        return null;
    }

    @Override
    public List<OrderDetails> getAll() {
        return List.of();
    }
}
