package cpm.slp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by sangliping on 2017/9/4.
 */
@ConfigurationProperties(prefix = "neo4j.datasource")
public class Neo4jSetting {
    private String username;
    private String url;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
