package lk.ijse.bo.custom;

import lk.ijse.dto.OrderDetailsDto;

public interface OrderDetailBO {
    public boolean save(OrderDetailsDto orderDetailsDto);
    public boolean update(OrderDetailsDto orderDetailsDto);
    public boolean delete(String value);
    public OrderDetailsDto get(String value);
}
