package com.mediaocean.shoppingcart.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.mediaocean.shopping.model.Item;
import com.mediaocean.shoppingcart.dao.ItemDAOService;

public class ItemRESTServiceImpl implements ItemRESTService {

    ItemDAOService itemDAOService;

    @Override
    public List<Item> getAllItems() {
        System.out.println("Hello world....");
        return itemDAOService.list();
    }

    @Override
    public List<Item> addItems(List<Item> items) {
        List<Item> resultItems = new ArrayList<Item>();
        if (!CollectionUtils.isEmpty(items)) {
            for (Item item : items) {
                resultItems.add(itemDAOService.insert(item));
            }
        }
        return resultItems;
    }

    public void setItemDAOService(ItemDAOService itemDAOService) {
        this.itemDAOService = itemDAOService;
    }

}
