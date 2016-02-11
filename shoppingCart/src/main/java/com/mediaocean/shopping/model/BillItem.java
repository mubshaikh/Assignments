package com.mediaocean.shopping.model;

import java.io.Serializable;

public class BillItem implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -330264521259639896L;
    Integer quantity;
    Item item;
    Double totalsalesTaxForItem;

    public BillItem() {
    }

    public BillItem(Item item, Integer quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Double getTotalsalesTaxForItem() {
        return totalsalesTaxForItem;
    }

    public void setTotalsalesTaxForItem(Double totalsalesTaxForItem) {
        this.totalsalesTaxForItem = totalsalesTaxForItem;
    }
}
