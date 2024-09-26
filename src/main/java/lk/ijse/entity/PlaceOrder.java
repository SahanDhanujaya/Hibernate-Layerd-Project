package lk.ijse.entity;

import lk.ijse.entity.tm.OrderTm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlaceOrder {
    private OrderDetailId orderDetailId;
    private Orders orders;
    private int qty;
    private List<OrderTm>  list;
}
