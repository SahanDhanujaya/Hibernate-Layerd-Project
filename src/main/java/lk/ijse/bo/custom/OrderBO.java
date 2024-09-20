package lk.ijse.bo.custom;

import lk.ijse.dto.OrderDto;

public interface OrderBO {
    public boolean save(OrderDto orderDto);
    public boolean update(OrderDto orderDto);
    public boolean delete(String value);
    public OrderDto get(String value);
}
