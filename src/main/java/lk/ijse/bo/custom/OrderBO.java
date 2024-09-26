package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.OrderDto;

import java.sql.Date;

public interface OrderBO extends SuperBO {
    public boolean save(OrderDto orderDto);
    public boolean update(OrderDto orderDto);
    public boolean delete(String value);
    public OrderDto get(String value);
    String getCurrentId();

    boolean transaction(String oId, String odId, Date date, String itemId);
}
