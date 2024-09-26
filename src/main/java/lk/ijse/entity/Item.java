package lk.ijse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Item {
    @Id
    private String itemCode;
    private String name;
    private double price;
    private int qty;
    @OneToMany(mappedBy = "item")
    private List<OrderDetails> orderDetails;

    public Item(String itemCode, String name, double price, int qty) {
        this.itemCode = itemCode;
        this.name = name;
        this.price = price;
        this.qty = qty;
    }
}
