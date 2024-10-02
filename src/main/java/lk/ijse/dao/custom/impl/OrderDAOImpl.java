package lk.ijse.dao.custom.impl;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.OrderDAO;
import lk.ijse.entity.Orders;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class OrderDAOImpl implements OrderDAO {

    @Override
    public boolean save(Orders object) {
        return false;
    }

    @Override
    public boolean update(Orders object) {
        return false;
    }


    @Override
    public boolean delete(Orders value) {
        return false;
    }

    @Override
    public Orders get(Orders value) {
        return null;
    }

    @Override
    public List<Orders> getAll() {
        return List.of();
    }

    @Override
    public String getCurrentId() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("select id from Orders order by id desc limit 1");
        String id = (String) query.uniqueResult();
        transaction.commit();
        session.close();
        return id;
    }
    @Override
    public boolean save(Orders orders1, Session session) {
        session.save(orders1);
        return true;
    }
}
