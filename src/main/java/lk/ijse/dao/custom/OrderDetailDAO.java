package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.OrderDetails;
import org.hibernate.Session;

public interface OrderDetailDAO extends CrudDAO<OrderDetails> {
    String getCurrentId();
    boolean save(OrderDetails object, Session session);
}
