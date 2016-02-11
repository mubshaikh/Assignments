package com.mediaocean.shoppingcart.rest.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.util.CollectionUtils;

import com.mediaocean.shopping.enums.Category;
import com.mediaocean.shopping.model.BillItem;
import com.mediaocean.shopping.model.Item;
import com.mediaocean.shopping.model.ItemizedBill;
import com.mediaocean.shoppingcart.dao.BillingDAOService;
import com.mediaocean.shoppingcart.dao.ItemDAOService;

public class BillingRESTServiceImpl implements BillingRESTService {

    // TODO: The business logic should be moved to a Service layer from where
    // this DAO service layer should be called, taking this shortcut for the
    // lack of time
    BillingDAOService billingDAOService;
    ItemDAOService itemDAOService;

    @Override
    public List<ItemizedBill> getAllBills() {
        return billingDAOService.list();
    }

    @Override
    public String createBill() {
        ItemizedBill item = new ItemizedBill();
        item.setId(new ObjectId().toString());
        billingDAOService.insert(item);
        return item.getId();
    }

    @Override
    public ItemizedBill addBillItem(String billId, String itemId, int quantity) {
        Item item = itemDAOService.getById(itemId);
        BillItem billItem = new BillItem(item, quantity);
        billItem.setTotalsalesTaxForItem(calculateSalesTax(item, quantity));
        ItemizedBill itemizedBill = billingDAOService.getById(billId);
        itemizedBill.getItems().add(billItem);
        updateCostAndTax(itemizedBill);
        billingDAOService.saveOrUpdate(itemizedBill);
        return itemizedBill;
    }

    protected void updateCostAndTax(ItemizedBill itemizedBill) {
        List<BillItem> allItems = itemizedBill.getItems();
        Double totalCost = 0.00;
        Double totalSalesTax = 0.00;
        if (!CollectionUtils.isEmpty(allItems)) {
            for (BillItem billItm : allItems) {
                totalCost = totalCost + (billItm.getItem().getCost() * billItm.getQuantity()) + billItm.getTotalsalesTaxForItem();
                totalSalesTax = totalSalesTax + billItm.getTotalsalesTaxForItem();
            }
            itemizedBill.setTotalCost(totalCost);
            itemizedBill.setTotalSalesTax(totalSalesTax);
        }
    }

    protected Double calculateSalesTax(Item item, Integer quantity) {
        Category category = item.getCategory();
        Double tax = null;
        switch (category) {
        case A:
            tax = (10.00 / item.getCost()) * 100;
            tax = tax * quantity;
            break;
        case B:
            tax = (20.00 / item.getCost()) * 100;
            tax = tax * quantity;
            break;
        default:
            tax = 0.00;
            break;
        }
        return tax;
    }

    public void setItemDAOService(ItemDAOService itemDAOService) {
        this.itemDAOService = itemDAOService;
    }

    public void setBillingDAOService(BillingDAOService billingDAOService) {
        this.billingDAOService = billingDAOService;
    }

}
