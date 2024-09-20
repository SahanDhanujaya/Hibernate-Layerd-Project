package lk.ijse.dao;

import java.util.List;

public interface CrudDAO<T> {
    public boolean save(T object);
    public boolean update(T object);
    public boolean delete(T object);
    public T get(String value);
    List<T> getAll();
}
