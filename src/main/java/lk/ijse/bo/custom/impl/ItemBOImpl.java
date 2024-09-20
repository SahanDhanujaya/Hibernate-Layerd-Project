package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.ItemBO;
import lk.ijse.dto.ItemDto;

public class ItemBOImpl implements ItemBO {
    @Override
    public boolean save(ItemDto itemDto) {
        return false;
    }

    @Override
    public boolean update(ItemDto itemDto) {
        return false;
    }

    @Override
    public boolean delete(String value) {
        return false;
    }

    @Override
    public ItemDto get(String value) {
        return null;
    }
}
