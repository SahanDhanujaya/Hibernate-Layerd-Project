package lk.ijse.dao.custom.impl;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.OrderDetailDAO;
import lk.ijse.entity.OrderDetails;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    @Override
    public boolean save(OrderDetails object) {
        return false;
    }

    @Override
    public boolean update(OrderDetails object) {
        return false;
    }

    @Override
    public boolean delete(OrderDetails value) {
        return false;
    }

    @Override
    public OrderDetails get(OrderDetails value) {
        return null;
    }

    @Override
    public List<OrderDetails> getAll() {
        return List.of();
    }

    @Override
    public String getCurrentId() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("select id from OrderDetails order by id desc limit 1");
        String id = (String) query.uniqueResult();
        transaction.commit();
        session.close();
        return id;
    }
}
