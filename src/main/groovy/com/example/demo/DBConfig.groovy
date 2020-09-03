package com.example.demo

import com.gmongo.GMongo
import com.mongodb.DB
import com.mongodb.MongoClient
import com.mongodb.ServerAddress
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DBConfig {

    @Bean
    DB mongoDB(){
//        String host = "127.0.0.1"
//        int dk = "27017"
        MongoClient mongoClient = new MongoClient(new ServerAddress("127.0.0.1",27017))
        def mongo = new GMongo(mongoClient)
        def db = mongo.getDB("guogai");

        return db
    }
}
