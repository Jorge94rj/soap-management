package com.spring.soap.webservices.soapmanagement.soap.service;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.stereotype.Component;

import java.util.List;

import com.spring.soap.webservices.soapmanagement.soap.bean.Item;

@Component
public class ItemDetailsService {
    private static List<Item> items = new ArrayList<>();

    public enum STATUS {SUCCESS, FAILURE}

    static {
        Item item1 = new Item(1, "a", "descripcion1");
        items.add(item1);
        Item item2 = new Item(1, "b", "descripcion2");
        items.add(item2);
        Item item3 = new Item(1, "c", "descripcion3");
        items.add(item3);
    }

    // find by id
    public Item findById(int id) {
        for (Item item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    // findAll items
    public List<Item> findAll() {
        return items;
    }

    // delete item
    public STATUS deleteItemById(int id) {
        Iterator<Item> iterator = items.iterator();
        while(iterator.hasNext()) {
            Item item = iterator.next();
            if(item.getId() == id) {
                iterator.remove();
                return STATUS.SUCCESS;
            }
        }
        return STATUS.FAILURE;
    }

    // update item
}