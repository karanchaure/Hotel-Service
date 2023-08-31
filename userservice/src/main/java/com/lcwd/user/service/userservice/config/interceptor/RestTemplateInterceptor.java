package com.lcwd.user.service.userservice.config.interceptor;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;

public class RestTemplateInterceptor implements ClientHttpRequestInterceptor {

    private OAuth2AuthorizedClientManager manager;
    private Logger log = LoggerFactory.getLogger(RestTemplateInterceptor.class);

    public RestTemplateInterceptor(OAuth2AuthorizedClientManager manager) {
        this.manager = manager;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {
        String tokenValue = manager.authorize(
        OAuth2AuthorizeRequest.withClientRegistrationId("my-internal-client").principal("internal").build())
        .getAccessToken().getTokenValue();
        log.info("Token : {}", tokenValue);
        request.getHeaders().add("Authorization", "Bearer "+tokenValue);
        log.info("Headers : {}",request.getHeaders().toString());
        return execution.execute(request, body);
    }

}
