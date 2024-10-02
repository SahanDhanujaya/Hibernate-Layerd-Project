package lk.ijse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Orders {
    @Id
    private String id;
    private Date date;
    @OneToMany(mappedBy = "order")
    private List<OrderDetails> orderDetails;
    @ManyToOne
    private Customer customer;
}
