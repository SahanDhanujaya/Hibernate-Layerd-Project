package lk.ijse.bo.custom;

import lk.ijse.dto.CustomerDto;

public interface CustomerBO {
    public boolean save(CustomerDto customerDto);
    public boolean update(CustomerDto customerDto);
    public boolean delete(String value);
    public CustomerDto get(String value);
}
