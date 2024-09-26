package lk.ijse.bo.custom.impl;

import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.OrderDetailBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.OrderDAO;
import lk.ijse.dao.custom.OrderDetailDAO;
import lk.ijse.dto.OrderDetailsDto;

public class OrderDetailBOImpl implements OrderDetailBO {
    OrderDetailDAO orderDetailDAO = (OrderDetailDAO) DAOFactory.getDaoFactory().getDAOType(DAOFactory.DAOType.ORDER_DETAIL);
    @Override
    public boolean save(OrderDetailsDto orderDetailsDto) {
        return false;
    }

    @Override
    public boolean update(OrderDetailsDto orderDetailsDto) {
        return false;
    }

    @Override
    public boolean delete(String value) {
        return false;
    }

    @Override
    public OrderDetailsDto get(String value) {
        return null;
    }

    @Override
    public String getCurrentId() {
        return orderDetailDAO.getCurrentId();
    }

}
