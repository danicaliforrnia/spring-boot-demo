
package com.dstefanelli.springbootdemo.infrastructure;

import com.dstefanelli.springbootdemo.SpringBootDemoApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = SpringBootDemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProfileMatcherControllerIT {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    void testGetClientConfig() {
        String url = "http://localhost:" + port + "/api/clients/get_client_config/123e4567-e89b-12d3-a456-426614174000";
        var response = restTemplate.getForObject(url, String.class);
        assertThat(response).contains("activeCampaigns");
    }
}
