package com.example.crudproduct.sevice;

import com.example.crudproduct.model.Phone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductSevice implements IProductSevice{
    public static Map<Integer, Phone> products ;
    static {
        products= new HashMap<>();
        products.put(1,new Phone(1,"iphone 13",23000,2021));
        products.put(2,new Phone(2,"iphone 14",26000,2022));
        products.put(3,new Phone(3,"iphone 15",35000,2023));
    }
    @Override
    public List<Phone> finAll(){
        return new ArrayList<>(products.values());
    }
    @Override
    public void add(Phone phone){
        products.put(phone.getId(),phone);
    }
    @Override
    public Phone fileById(int id){
        return products.get(id);
    }
    @Override
public void update(int id,Phone phone){
products.put(id,phone);
    }
    @Override
    public void delete(int id) {
        products.remove(id);
    }
    @Override
    public List<Phone> search(String name) {
        List<Phone> searchResults = new ArrayList<>();

        for (Phone phone : products.values()) {
            if (phone.getName().equals(name)) {
                searchResults.add(phone);
            }
        }


        return searchResults;
    }

}
