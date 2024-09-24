package lk.ijse.entity.tm;

import com.jfoenix.controls.JFXButton;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderTm {
    private String itemCode;
    private String item;
    private double price;
    private int qty;
    private JFXButton button;
}
