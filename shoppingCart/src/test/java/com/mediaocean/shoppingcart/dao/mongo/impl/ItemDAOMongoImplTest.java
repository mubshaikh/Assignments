package com.mediaocean.shoppingcart.dao.mongo.impl;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mediaocean.shopping.enums.Category;
import com.mediaocean.shopping.model.Item;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-tests.xml" })
public class ItemDAOMongoImplTest {

    @Autowired
    ItemDAOMongoImpl itemDAOMongoImpl;

    public static void test() {
        System.out.println("Works .......");
    }

    @Test
    public void testAddItem() {
        Item item = new Item();
        item.setCategory(Category.A);
        item.setCode("0A0ER1");
        item.setCost(200.50);
        Item insertedItem = itemDAOMongoImpl.insert(item);
        Assert.assertNotNull(insertedItem);
        Assert.assertNotNull(insertedItem.getId());
    }
}
