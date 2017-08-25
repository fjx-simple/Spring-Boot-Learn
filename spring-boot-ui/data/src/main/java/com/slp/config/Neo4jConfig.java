package com.slp.config;

import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.SessionFactory;
import org.neo4j.ogm.session.event.EventListener;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.data.neo4j.Neo4jDataAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

/**
 * Created by sangliping on 2017/8/24.
 */
@org.springframework.context.annotation.Configuration
@EnableTransactionManagement
@EnableNeo4jRepositories(basePackages = { "com.test.data.repositories" })
public class Neo4jConfig extends Neo4jDataAutoConfiguration  {
    @Override
    public SessionFactory sessionFactory(Configuration configuration, ApplicationContext applicationContext, ObjectProvider<List<EventListener>> eventListeners) {
        return super.sessionFactory(configuration, applicationContext, eventListeners);
    }
}
