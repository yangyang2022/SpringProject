package com.yangyang.util;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MongoUtil {

    public static final String defaultHost = "192.168.20.133";
    public static final int defaultPort = 27017;

    private static MongoCollection<Document> collection;

    public static void defaultConnect(String databaseName,String collectionName){
        connect(databaseName,collectionName,defaultHost,defaultPort);
    }
    public static void connect(String databaseName,String collectionName,String host,int port){
        MongoClient mongoClient = new MongoClient(host, port);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        collection = database.getCollection(collectionName);
        System.out.println("connecting ... "+collection);
    }

    public static void insert(Document doc){collection.insertOne(doc);}

    public static List<Document> findAll(){
        ArrayList<Document> results = new ArrayList<>();
        collection.find().map(results::add);
        return results;
    }
    public static List<Document> findBy(Bson filter){
        ArrayList<Document> results = new ArrayList<>();
        collection.find(filter).map(results::add);
        return results;
    }

    public static UpdateResult updateOne(Bson filter, Bson update) {
        return collection.updateOne(filter, update);
    }

    public static UpdateResult updateMany(Bson filter, Bson update) {
        return collection.updateMany(filter, update);
    }
    public static void replace(Bson filter, Document replacement) {
        collection.replaceOne(filter, replacement);
    }
    public static void deleteOne(Bson filter) {
        collection.deleteOne(filter);
    }
    public static void deleteMany(Bson filter) {
        collection.deleteMany(filter);
    }

    private static void printDocuments(MongoCollection<Document> collections){
        collections.find().forEach((Consumer<? super Document>) e-> System.out.println(e.toJson()));
    }
    private void getCollectionCount(MongoCollection<Document> collections){
        System.out.println("count: "+collections.count());
    }
    private void printDocument(Document doc){
        System.out.println(doc.toJson());
    }
}
