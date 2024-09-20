package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.OrderDetailBO;
import lk.ijse.dto.OrderDetailsDto;

public class OrderDetailBOImpl implements OrderDetailBO {
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
}
