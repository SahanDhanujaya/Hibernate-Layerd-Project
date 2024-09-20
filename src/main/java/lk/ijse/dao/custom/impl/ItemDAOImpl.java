package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.ItemDAO;
import lk.ijse.entity.Item;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public boolean save(Item object) {
        return false;
    }

    @Override
    public boolean update(Item object) {
        return false;
    }

    @Override
    public boolean delete(String value) {
        return false;
    }

    @Override
    public Item get(String value) {
        return null;
    }
}
