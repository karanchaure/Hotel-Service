package com.lcwd.user.service.userservice.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.web.client.RestTemplate;

import com.lcwd.user.service.userservice.config.interceptor.RestTemplateInterceptor;

@Configuration
public class MyConfig {

    @Autowired
    public ClientRegistrationRepository clientRegistrationRepository;
    @Autowired
    private OAuth2AuthorizedClientRepository auth2AuthorizedClientRepository;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new RestTemplateInterceptor(manager(clientRegistrationRepository, auth2AuthorizedClientRepository)));
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }

    // declare the bean of OAuth2AuthorizedClientManager manager
    @Bean
    public OAuth2AuthorizedClientManager manager(ClientRegistrationRepository repository,
            OAuth2AuthorizedClientRepository clientRepository) {
        DefaultOAuth2AuthorizedClientManager defaultOAuth2AuthorizedClientManager = new DefaultOAuth2AuthorizedClientManager(
                repository, clientRepository);
        OAuth2AuthorizedClientProvider provider = OAuth2AuthorizedClientProviderBuilder.builder().clientCredentials()
                .build();
        defaultOAuth2AuthorizedClientManager.setAuthorizedClientProvider(provider);
        return defaultOAuth2AuthorizedClientManager;
    }

}
