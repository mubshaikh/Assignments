package com.mediaocean.shopping.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mediaocean.shopping.enums.Category;

@XmlRootElement(name = "item")
@Document(collection = "items")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item extends BaseDO {
    /**
     * 
     */
    private static final long serialVersionUID = -4934394639562918536L;
    private String name;
    Category category;
    private String code;
    private Double cost;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

}