package lt.vilniustech.YHev.first.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration tests for the DisplayPathController.
 * These tests verify that the /serviceA/displayPath endpoint responds correctly.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DisplayPathControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testDisplayPath() {
        // Arrange + Act
        ResponseEntity<String> response = restTemplate.getForEntity("/serviceA/displayPath", String.class);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().contains("Microservice 1 controller executed"), "Expected response to contain service execution message");
    }
}
