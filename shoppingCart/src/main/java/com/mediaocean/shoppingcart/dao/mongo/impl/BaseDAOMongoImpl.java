package com.mediaocean.shoppingcart.dao.mongo.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.util.CollectionUtils;

import com.mediaocean.shopping.model.BaseDO;
import com.mediaocean.shopping.util.MongoUtil;
import com.mediaocean.shoppingcart.dao.BaseDAO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;

public abstract class BaseDAOMongoImpl<T extends BaseDO> implements BaseDAO<T> {

    MongoResource mongoResource;
    MongoUtil mongoUtil;
    String collectionName;

    private Class<T> inferedClass;

    public Class<T> getGenericClass() {
        if (inferedClass == null) {
            Type mySuperclass = getClass().getGenericSuperclass();
            Type tType = ((ParameterizedType) mySuperclass).getActualTypeArguments()[0];
            String className = tType.toString().split(" ")[1];
            try {
                inferedClass = (Class<T>) Class.forName(className);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return inferedClass;
    }

    @Override
    public T insert(T item) {
        item.setId(new ObjectId().toString());
        getCollection().insertOne(mongoUtil.pojoToDocument(item));
        return item;
    }

    @Override
    public T saveOrUpdate(T item) {
        MongoCollection<Document> collection = getCollection();
        collection
                .updateOne(new Document("id", item.getId()), new Document("$set", mongoUtil.pojoToDocument(item)), new UpdateOptions().upsert(true));
        return item;

    }

    private MongoCollection<Document> getCollection() {
        return mongoResource.getDataBase().getCollection(collectionName);
    }

    @Override
    public T getById(String id) {
        Document doc = getCollection().find(Filters.eq("id", id)).first();
        return mongoUtil.documentToPojo(doc, getGenericClass());
    }

    @Override
    public List<T> list() {
        List<Document> docList = getCollection().find().into(new ArrayList<Document>());
        List<T> elements = null;
        Class<T> genericClass = getGenericClass();
        if (!CollectionUtils.isEmpty(docList)) {
            elements = new ArrayList<T>();
            for (Document doc : docList) {
                elements.add(mongoUtil.documentToPojo(doc, genericClass));
            }
        }
        return elements;
    }

    public void setMongoResource(MongoResource mongoResource) {
        this.mongoResource = mongoResource;
    }

    public void setMongoUtil(MongoUtil mongoUtil) {
        this.mongoUtil = mongoUtil;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

}
