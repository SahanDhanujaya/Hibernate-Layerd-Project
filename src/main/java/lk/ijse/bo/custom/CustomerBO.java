package lk.ijse.bo.custom;

import lk.ijse.dto.CustomerDto;

import java.util.List;

public interface CustomerBO {
    public boolean save(CustomerDto customerDto);
    public boolean update(CustomerDto customerDto);
    public boolean delete(CustomerDto object);
    public CustomerDto get(String value);

    List<CustomerDto> getAll();
}
