package lk.ijse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class OrderDetails {
    private String orderId;
    private String itemId;
    private List<Order> orders;
    private List<Item> items;
}
