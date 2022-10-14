package edu.ucsb.cs156.spring.backenddemo.services;

import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@Slf4j
@Service
public class RedditQueryService {

    private final RestTemplate restTemplate;

    public RedditQueryService(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public static final String ENDPOINT = "https://www.reddit.com/r/{subreddit}.json";

    public String getJSON(String subreddit) throws HttpClientErrorException {
        log.info("subreddit={}", subreddit);
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        
        return "";
    }
   

}