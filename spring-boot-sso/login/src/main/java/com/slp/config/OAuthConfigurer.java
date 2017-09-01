package com.slp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;

/**
 * EnableAuthorizationServer启用OAuth2认证服务器功能
 */
@Configuration
@EnableAuthorizationServer
public class OAuthConfigurer extends AuthorizationServerConfigurerAdapter {

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        KeyPair keyPair = new KeyStoreKeyFactory(new ClassPathResource(
                "keystore.jks"), "testslp".toCharArray()).getKeyPair("tycoonclient");
        converter.setKeyPair(keyPair);
        System.out.println("获取证书keystore.jks中tycoonclient"+converter.toString());
        return converter;
    }

    /**
     * The ClientDetailsServiceConfigurer (a callback from your AuthorizationServerConfigurer) can be used to define an in-memory or JDBC implementation of the client details service. Important attributes of a client are

     clientId: (required) the client id.
     secret: (required for trusted clients) the client secret, if any.
     scope: The scope to which the client is limited. If scope is undefined or empty (the default) the client is not limited by scope.
     authorizedGrantTypes: Grant types that are authorized for the client to use. Default value is empty.
     authorities: Authorities that are granted to the client (regular Spring Security authorities).
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients)
            throws Exception {
        clients.inMemory().withClient("ssoclient").secret("ssosecret")
                .autoApprove(true)//设置自动确认授权 登陆后 不需要再进行一次授权确认操作
                .authorizedGrantTypes("authorization_code", "refresh_token").scopes("openid");
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security)
            throws Exception {
        security.tokenKeyAccess("permitAll()").checkTokenAccess(
                "isAuthenticated()").allowFormAuthenticationForClients();
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints)
            throws Exception {
        endpoints.accessTokenConverter(jwtAccessTokenConverter());
    }

}
