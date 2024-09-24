package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.OrderDAO;
import lk.ijse.entity.Order;

import java.util.List;

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
    public boolean delete(Order value) {
        return false;
    }

    @Override
    public Order get(Order value) {
        return null;
    }

    @Override
    public List<Order> getAll() {
        return List.of();
    }
}
