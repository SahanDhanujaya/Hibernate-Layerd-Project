package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.ItemBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.ItemDAO;
import lk.ijse.dto.ItemDto;
import lk.ijse.entity.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemBOImpl implements ItemBO {
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAOType(DAOFactory.DAOType.ITEM);
    @Override
    public boolean save(ItemDto itemDto) {
        return itemDAO.save(new Item(itemDto.getItemCode(), itemDto.getName(), itemDto.getPrice(), itemDto.getQty()));
    }

    @Override
    public boolean update(ItemDto itemDto) {
        return itemDAO.update( new Item(itemDto.getItemCode(), itemDto.getName(), itemDto.getPrice(), itemDto.getQty()));
    }

    @Override
    public boolean delete(ItemDto itemDto) {
        return itemDAO.delete(new Item(itemDto.getItemCode(), itemDto.getName(), itemDto.getPrice(), itemDto.getQty()));
    }

    @Override
    public ItemDto get(String value) {
        Item item = itemDAO.getObject(value);
        return new ItemDto(item.getItemCode(), item.getName(), item.getPrice(), item.getQty());
    }

    @Override
    public List<String> getIds() {
        return itemDAO.getIds();
    }

    @Override
    public List<ItemDto> getAll() {
        List<Item> all = itemDAO.getAll();
        List<ItemDto> itemDtos = new ArrayList<>();
        for (Item item : all){
            itemDtos.add(new ItemDto(item.getItemCode(), item.getName(), item.getPrice(), item.getQty()));
        }
        return itemDtos;
    }

    @Override
    public String getCurrentId() {
        return itemDAO.getCurrentId();
    }
}
