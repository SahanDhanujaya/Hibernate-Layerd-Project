package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.Orders;
import org.hibernate.Session;

public interface OrderDAO extends CrudDAO<Orders> {
    String getCurrentId();
    boolean save(Orders orders1, Session session);

}
