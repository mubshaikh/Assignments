package com.mediaocean.shopping.util;

import java.io.IOException;

import org.bson.Document;
import org.codehaus.jackson.map.ObjectMapper;

public class MongoUtil {

    ObjectMapper objectMapper = new ObjectMapper();

    public <T> Document pojoToDocument(T pojo) {
        Document document = null;
        try {
            String jsonString = objectMapper.writeValueAsString(pojo);
            document = Document.parse(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    public <T> T documentToPojo(Document doc, Class<T> clazz) {
        String jsonString = doc.toJson();
        T pojo = null;
        try {
            pojo = objectMapper.readValue(jsonString, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pojo;
    }
}
