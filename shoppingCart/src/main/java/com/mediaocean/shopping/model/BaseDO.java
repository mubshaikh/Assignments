package com.mediaocean.shopping.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class BaseDO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -7632575516314838428L;

    @Id
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
