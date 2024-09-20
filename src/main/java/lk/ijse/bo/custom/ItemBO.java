package lk.ijse.bo.custom;

import lk.ijse.dto.ItemDto;

public interface ItemBO {
    public boolean save(ItemDto itemDto);
    public boolean update(ItemDto itemDto);
    public boolean delete(String value);
    public ItemDto get(String value);
}
