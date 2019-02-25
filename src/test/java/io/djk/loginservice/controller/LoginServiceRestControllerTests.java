package io.djk.loginservice.controller;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by dkothari on 2/18/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class LoginServiceRestControllerTests {

    @LocalServerPort
    private int port;

    private String host = "http://localhost";


    @Autowired
    private TestRestTemplate restTemplate;

    @Before

    @Test
    public void whenUserCallsDefaultEndpoint_thenReturnHelloWorld() throws URISyntaxException {
        URI uri = new URI(host + ":" + port + "/");
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("Hello World!");
    }

    @Test
    public void givenUsernameAndPassword_whenUserPUTSCreateUserEndpoint_thenCreateNewUser() throws URISyntaxException, JSONException {
        URI uri = new URI(host + ":" + port + "/create");
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("username", "testUser");
        requestBody.put("password", "testPassword");
        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(requestBody);
        ResponseEntity<Void> response = restTemplate.exchange(uri, HttpMethod.PUT, httpEntity, Void.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNull();
    }

    @Test
    public void givenANullPassword_whenUserPUTSCreateUserEndpoint_thenReturnBadHTTPRequest() throws URISyntaxException {
        URI uri = new URI(host + ":" + port + "/create");
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("username", "testUser");
        requestBody.put("password", null);
        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(requestBody);
        ResponseEntity<Void> response = restTemplate.exchange(uri, HttpMethod.PUT, httpEntity, Void.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(response.getBody()).isEqualTo("No Password Field Provided");
    }
}
