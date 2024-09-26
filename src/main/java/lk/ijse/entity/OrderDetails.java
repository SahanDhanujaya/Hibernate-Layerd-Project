package lk.ijse.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class OrderDetails {
    @EmbeddedId
    private OrderDetailId orderDetailId;
    @ManyToOne
    @JoinColumn(name = "oId")
    private Orders order;
    @ManyToOne
    @JoinColumn(name = "iId")
    private Item item;
}
