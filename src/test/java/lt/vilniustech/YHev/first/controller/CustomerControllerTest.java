package lt.vilniustech.YHev.first.controller;

import lt.vilniustech.YHev.first.model.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetAllCustomers() {
        ResponseEntity<Customer[]> response = restTemplate.getForEntity("/customers", Customer[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().length > 0, "Expected at least one customer");
    }

    @Test
    public void testSearchCustomerByFirstName() {
        ResponseEntity<Customer[]> response = restTemplate.getForEntity("/customers/search?firstName=Ava", Customer[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().length > 0, "Expected at least one customer with first name 'John'");
    }

}
