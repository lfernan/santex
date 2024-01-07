package com.santex.santex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Component
public class BaseService {
    @Autowired
    private RestTemplate template;

    @Value("${football-data-token}")
    private String token;

    @Value("${football-data-endpoint}")
    private String apiURL;

    private final String HEADER_AUTH = "X-Auth-Token";

    protected ResponseEntity<?> doExchange(String method, Class<?> tClass) {
        return template.exchange(apiURL.concat(method), HttpMethod.GET, getHeader(), tClass);
    }

    private HttpEntity getHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set(HEADER_AUTH, token);

        return new HttpEntity<>(headers);
    }
}
