package edu.ucsb.cs156.spring.backenddemo.services;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.test.web.client.MockRestServiceServer;

import com.fasterxml.jackson.core.JsonProcessingException;

@RestClientTest(RedditQueryService.class)
public class RedditQueryServiceTests {
    
    @Autowired
    private MockRestServiceServer mockRestServiceServer;

    @Autowired
    private RedditQueryService redditQueryService;

    @Test
    public void test_getJSON() throws URISyntaxException, UnsupportedEncodingException, JsonProcessingException {
        
        String expectedURL = redditQueryService.ENDPOINT;
        String fakeJSONResult = "{ \"fake\" : \"result\" }";


    }
}
