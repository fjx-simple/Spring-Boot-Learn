package com.slp.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sangliping on 2017/8/21.
 */

@PropertySource({"classpath:data-source.properties"})
@EnableMongoRepositories(basePackages = "com.slp.repository")
public class DataSourceConfig extends AbstractMongoConfiguration {
    @Autowired
    Environment environment;
    @Override
    protected String getDatabaseName() {
        return environment.getRequiredProperty("mongo.name");
    }

    @Override
    public Mongo mongo() throws Exception {
        ServerAddress serverAddress = new ServerAddress(environment.getRequiredProperty("mongo.host"));
        List<MongoCredential> credentials = new ArrayList<>();
        return new MongoClient(serverAddress, credentials);
    }
}
