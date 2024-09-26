package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.OrderDetails;

public interface OrderDetailDAO extends CrudDAO<OrderDetails> {
    String getCurrentId();
}
