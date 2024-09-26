package lk.ijse.entity;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetails {
    @OneToMany
    private List<Order> orders;
    @OneToMany
    private List<Item> items;
}
