package dao;

import java.util.List;

public interface DAO<T, I> {
    int add(T t);
    int update(T t);
    int delete(I id);
    T get(I id);
    List<T> getAll();
}

