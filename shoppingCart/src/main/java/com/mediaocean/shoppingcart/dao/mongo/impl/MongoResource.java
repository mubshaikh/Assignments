package com.mediaocean.shoppingcart.dao.mongo.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientOptions.Builder;
import com.mongodb.MongoClientURI;
import com.mongodb.ReadPreference;
import com.mongodb.client.MongoDatabase;

/**
 * The Class MongoResource.
 */
public class MongoResource implements InitializingBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(MongoResource.class);

    private String dbUri;
    private String dbName;
    private MongoClient mongoClient;
    private MongoDatabase dataBase;
    private String dbUser;
    private String dbPassword;
    private static final String PREFIX = "mongodb://";

    @Override
    public void afterPropertiesSet() throws Exception {

        String uri = dbUri;

        if (dbUser != null && !dbUser.isEmpty() && dbPassword != null && !dbPassword.isEmpty()) {
            uri = insertCredentials(dbUri, dbUser, dbPassword, dbName);
        } else {
            uri = dbUri;
        }

        mongoClient = getClient(uri);
        LOGGER.info("mongo client" + mongoClient);
        dataBase = mongoClient.getDatabase(dbName);
        LOGGER.info("db name" + dbName);
    }

    // call it on your shutdown hook for example
    public void close() {
        mongoClient.close();
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public static MongoClient getClient(String uri) {

        MongoClient client = null;
        Builder options;
        try {
            options = new MongoClientOptions.Builder().connectionsPerHost(100).readPreference(ReadPreference.primary())
            // .writeConcern(WriteConcern.ACKNOWLEDGED)
            ;
            MongoClientURI uriObj = new MongoClientURI(uri, options);
            client = new MongoClient(uriObj);
        } catch (Exception ex) {
            LOGGER.error("Unknown Host", ex);
        }
        return client;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public MongoDatabase getDataBase() {
        return dataBase;
    }

    public void setDbUri(String dbUri) {
        this.dbUri = dbUri;
    }

    private static String insertCredentials(String uri, String dbUser, String dbPassword, String dbName) {
        System.out.println(PREFIX + dbUser + ":" + "PASSWORD_NOT_LOGGED" + "@" + uri);
        return PREFIX + dbUser + ":" + dbPassword + "@" + uri; // .substring(PREFIX.length())
                                                               // + "/" +
                                                               // dbName;
    }
}
