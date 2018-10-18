package com.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@ConfigurationProperties("security.oauth2.client")
public class SecurityOAuth2ClientProperties {
    private String clientId;
    private String clientSecret;
    private Set<String> authorizedGrantTypes;
    private List<String> scope;
    private List<String> authorities;
    private Integer accessTokenValiditySeconds;
    private Integer refreshTokenValiditySeconds;
}