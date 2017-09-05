package cpm.slp.config;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by sangliping on 2017/9/4.
 */
@Configuration
@EnableTransactionManagement
@EnableNeo4jRepositories(basePackages = { "com.slp.repository" })
@EnableConfigurationProperties(Neo4jSetting.class)
public class Neo4jConfig extends Neo4jConfiguration{
    @Override
    public SessionFactory getSessionFactory() {
        return new SessionFactory("com.slp.domain");
    }
}
