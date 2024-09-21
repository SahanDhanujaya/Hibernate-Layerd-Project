package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.ItemDto;

public interface ItemBO extends SuperBO {
    public boolean save(ItemDto itemDto);
    public boolean update(ItemDto itemDto);
    public boolean delete(String value);
    public ItemDto get(String value);
}
