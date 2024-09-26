package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.OrderDetailsDto;

public interface OrderDetailBO extends SuperBO {
    public boolean save(OrderDetailsDto orderDetailsDto);
    public boolean update(OrderDetailsDto orderDetailsDto);
    public boolean delete(String value);
    public OrderDetailsDto get(String value);
    String getCurrentId();

}
