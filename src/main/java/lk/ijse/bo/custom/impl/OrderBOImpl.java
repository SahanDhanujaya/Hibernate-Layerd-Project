package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.OrderBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.CustomerDAO;
import lk.ijse.dto.OrderDto;

public class OrderBOImpl implements OrderBO {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAOType(DAOFactory.DAOType.CUSTOMER);
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


}
