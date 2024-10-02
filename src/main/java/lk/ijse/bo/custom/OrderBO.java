package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.OrderDto;
import lk.ijse.entity.tm.OrderTm;

import java.util.List;

public interface OrderBO extends SuperBO {
    public boolean save(OrderDto orderDto);
    public boolean update(OrderDto orderDto);
    public boolean delete(String value);
    public OrderDto get(String value);
    String getCurrentId();
    void placeOrder(List<OrderTm> orders, String customerId, String total, String qty);
}
