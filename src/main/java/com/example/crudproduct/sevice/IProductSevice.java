package com.example.crudproduct.sevice;

import com.example.crudproduct.model.Phone;

import java.util.List;

public interface IProductSevice {
    List<Phone> finAll();
    void add(Phone phone);
    Phone fileById(int id);
    void update(int id,Phone phone);
    void delete(int id);
    List<Phone> search(String name);
}
