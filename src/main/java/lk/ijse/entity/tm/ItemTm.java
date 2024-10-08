package lk.ijse.entity.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemTm {
    private String itemCode;
    private String name;
    private double price;
    private int qty;
}
