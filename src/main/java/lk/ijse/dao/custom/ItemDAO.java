package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.Item;
import org.hibernate.Session;

import java.util.List;

public interface ItemDAO extends CrudDAO<Item> {
    List<String> getIds();

    String getCurrentId();

    Item getObject(String value);
    boolean update(Session session, Item object);
}
