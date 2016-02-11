package com.mediaocean.shoppingcart.dao.mongo.impl;

import com.mediaocean.shopping.model.BillItem;
import com.mediaocean.shopping.model.ItemizedBill;
import com.mediaocean.shoppingcart.dao.BillingDAOService;

public class BillingDAOServiceMongoImpl extends BaseDAOMongoImpl<ItemizedBill> implements BillingDAOService {

    @Override
    public ItemizedBill addItemToBill(String billId, BillItem billItem) {

        return null;
    }

}
