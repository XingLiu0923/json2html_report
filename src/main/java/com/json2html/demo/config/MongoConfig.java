package com.json2html.demo.config;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MongoConfig {

    // 服务器uri
    private String MONGO_CONNECTION_ADDRESS = "J2H_MONGODB_ADDRESS";
    private String MONGO_CONNECTION_PROT = "J2H_MONGODB_PORT";

    // 数据库名字
    private static final String DEFAULT_DATABASE_NAME = "J2H_REPORT";

    @Autowired
    private Environment environment;

    public MongoDatabase getMongoDatabase() {
        List<ServerAddress> adds = new ArrayList<>();
        String mongoAddress = this.environment.getProperty(MONGO_CONNECTION_ADDRESS);
        Integer mongoPort = Integer.valueOf(this.environment.getProperty(MONGO_CONNECTION_PROT));
        ServerAddress serverAddress = new ServerAddress(mongoAddress, mongoPort);
        adds.add(serverAddress);

        // MongoClient client = this.application.getBean(MongoClient.class);
        MongoClient client = new MongoClient(adds);
        MongoDatabase mongoDatabase = client.getDatabase(DEFAULT_DATABASE_NAME);
        return mongoDatabase;
    }
}
