package edu.ucsb.cs156.spring.backenddemo.services;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.test.web.client.MockRestServiceServer;

import com.fasterxml.jackson.core.JsonProcessingException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.header;

@RestClientTest(RedditQueryService.class)
public class RedditQueryServiceTests {
    
    @Autowired
    private MockRestServiceServer mockRestServiceServer;

    @Autowired
    private RedditQueryService redditQueryService;

    @Test
    public void test_getJSON() throws URISyntaxException, UnsupportedEncodingException, JsonProcessingException {
        
        String subreddit = "UCSantaBarbara";
        String expectedURL = RedditQueryService.ENDPOINT.replace("{subreddit}", subreddit);
        String fakeJSONResult = "{ \"fake\" : \"result\" }";

        this.mockRestServiceServer.expect(requestTo(expectedURL))
                .andExpect(header("Accept", MediaType.APPLICATION_JSON.toString()))
                .andExpect(header("Content-Type", MediaType.APPLICATION_JSON.toString()))
                .andExpect(header("User-Agent", "spring-boot:cs156-team01:f22 (by /u/cgaucho)"))
                .andRespond(withSuccess(fakeJSONResult, MediaType.APPLICATION_JSON));
        
        String actualResult = redditQueryService.getJSON(subreddit);
        assertEquals(fakeJSONResult, actualResult);
    }
}
