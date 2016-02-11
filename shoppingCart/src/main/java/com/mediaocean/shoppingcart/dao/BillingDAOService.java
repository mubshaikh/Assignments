package com.mediaocean.shoppingcart.dao;

import com.mediaocean.shopping.model.BillItem;
import com.mediaocean.shopping.model.ItemizedBill;

public interface BillingDAOService extends BaseDAO<ItemizedBill> {

    public ItemizedBill addItemToBill(String billId, BillItem billItem);

}
