import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.yangyang.util.MongoUtil;
import org.bson.Document;
import org.junit.Test;

import java.util.function.Consumer;

public class MongoTest {

    private static final String HOST = "192.168.20.133";

    private static void printDocuments(MongoCollection<Document> collections){
        collections.find().forEach((Consumer<? super Document>) e-> System.out.println(e.toJson()));
    }
    private void getCollectionCount(MongoCollection<Document> collections){
        System.out.println("count: "+collections.count());
    }
    private void printDocument(Document doc){
        System.out.println(doc.toJson());
    }
    @Test
    public void testMongoConnection() {

        MongoClientOptions options = MongoClientOptions.builder().connectionsPerHost(6).connectTimeout(1000).build();

        MongoClient mongo = new MongoClient(HOST,options);
        MongoDatabase mydb = mongo.getDatabase("mydb");
        MongoCollection<Document> users = mydb.getCollection("users");

        int ccph = mongo.getMongoClientOptions().getConnectionsPerHost();
        int cctime = mongo.getMongoClientOptions().getConnectTimeout();
        System.out.println("perhost: "+ccph+" -> "+cctime);

        //mongo.getDatabase("yang").createCollection("users");

        //Random random = new Random();
        //Document doc1 = new Document();
        //
        //for (int i = 0; i < 100; ++i) {
        //    doc1.append("userid", "myu"+i).append("name", "yangyang").append("age",random.nextInt(100)).append("address","anhui");
        //    users.insertOne(doc1);//
        //    doc1.clear();
        //}

        //users.deleteOne(new Document("myuu","yangyang"));

        //users.deleteMany(new BasicDBObject());
        //users.deleteOne(new BasicDBObject("name","yangyang"));
        //users.deleteOne(new Document("name","yangyang"));

        //Document filter = new Document("userid","myu0");
        //Document updateBson = new Document("userid","myu0");
        //updateBson.append("name","xijingping").append("age",998);
        //
        //Document update = new Document();
        //update.append("$set",updateBson);
        //users.updateOne(filter,update);

        //printDatabase(users);
        //getCollectionCount(users);
        //{userid:myu1,{age:{$gt:60,$lt:80}}}
        Document filter = new Document("userid", "myu16").append("age", new Document("$gte", 60).append("$lte", 80));
        Document show = new Document("userid", 1).append("age", 1).append("_id", 0);

        FindIterable<Document> docs = users.find(filter);

        docs.forEach((Consumer<? super Document>) e-> System.out.println(e.toJson()));

        mongo.close();
    }

    @Test
    public void testDemo2() {

        MongoUtil.defaultConnect("mydb", "users");
        MongoUtil.insert(new Document("test","helloworld"));
    }
}
