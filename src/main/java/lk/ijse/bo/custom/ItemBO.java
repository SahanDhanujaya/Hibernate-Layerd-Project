package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.ItemDto;

import java.util.List;

public interface ItemBO extends SuperBO {
    public boolean save(ItemDto itemDto);
    public boolean update(ItemDto itemDto);
    public boolean delete(ItemDto itemDto);
    public ItemDto get(String value);

    List<String> getIds();

    List<ItemDto> getAll();

    String getCurrentId();
}
