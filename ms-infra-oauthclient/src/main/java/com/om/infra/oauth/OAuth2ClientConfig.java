package com.om.infra.oauth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;


@Configuration
@EnableOAuth2Client
public class OAuth2ClientConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(OAuth2ClientConfig.class);
	
	@Bean(name="oAuth2RestTemplate")
	public OAuth2RestTemplate oauth2RestTemplate(
			OAuth2ProtectedResourceDetails details) {
		
		OAuth2RestTemplate template =  new OAuth2RestTemplate(details);
	
		LOGGER.info("oauth2RestTemplate has been built");
		
		LOGGER.info("oauth2RestTemplate.AccessToken: {}",template.getAccessToken());

		return template;
	}
	
	@Bean
    protected OAuth2ProtectedResourceDetails details() {

		ResourceOwnerPasswordResourceDetails details = new ResourceOwnerPasswordResourceDetails();
		details.setClientId("my-client");
		details.setClientSecret("my-secret");
		details.setAccessTokenUri("http://localhost:8080/oauth/token");
		details.setUsername("user1@test.com");
		details.setPassword("user123");
		details.setGrantType("password");
        details.setTokenName("oauth_token");
		details.setClientAuthenticationScheme(AuthenticationScheme.header);
        
        return details;
    }
	
}
