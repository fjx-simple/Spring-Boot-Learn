package com.slp.config;
import org.neo4j.ogm.session.SessionFactory;
import org.neo4j.ogm.session.event.EventListener;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.data.neo4j.Neo4jDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.neo4j.Neo4jProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

/**
 * Created by sangliping on 2017/8/23.
 */
@Configuration
@EnableTransactionManagement
@EnableNeo4jRepositories(basePackages = { "com.slp.repository" })
public class Neo4jConfig extends Neo4jDataAutoConfiguration {
//SDN 升级到4.1.5，连接服务器的配置改在ogm.properties中设定，这样可以访问Neo4j 2.x 到 3.x 版本
//    @Override
//    public Neo4jServer neo4jServer() {
//        return new RemoteServer("http://192.168.1.221:7474","neo4j","12345678");
//    }


    @Override
    public org.neo4j.ogm.config.Configuration configuration(Neo4jProperties properties) {
        return super.configuration(properties);
    }

    @Override
    public SessionFactory sessionFactory(org.neo4j.ogm.config.Configuration configuration, ApplicationContext applicationContext, ObjectProvider<List<EventListener>> eventListeners) {
        return super.sessionFactory(configuration, applicationContext, eventListeners);
    }
}
