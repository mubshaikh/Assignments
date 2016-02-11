package com.mediaocean.shopping.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.CollectionUtils;

@Document(collection = "bills")
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name = "bill")
public class ItemizedBill extends BaseDO {

    private static final long serialVersionUID = 619450486557635438L;

    @JsonProperty("items")
    List<BillItem> items;
    Double totalCost;
    Double totalSalesTax;

    public ItemizedBill() {
    }

    public List<BillItem> getItems() {
        if (CollectionUtils.isEmpty(items)) {
            items = new ArrayList<BillItem>();
        }
        return items;
    }

    public void setItems(List<BillItem> items) {
        this.items = items;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public Double getTotalSalesTax() {
        return totalSalesTax;
    }

    public void setTotalSalesTax(Double totalSalesTax) {
        this.totalSalesTax = totalSalesTax;
    }

}
