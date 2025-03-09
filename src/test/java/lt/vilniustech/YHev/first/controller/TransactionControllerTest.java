package lt.vilniustech.YHev.first.controller;

import lt.vilniustech.YHev.first.model.Transaction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TransactionControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetAllTransactions() {
        ResponseEntity<Transaction[]> response = restTemplate.getForEntity("/transactions", Transaction[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().length > 0, "Expected at least one transaction");
    }

    @Test
    public void testSearchTransactionByType() {
        ResponseEntity<Transaction[]> response = restTemplate.getForEntity("/transactions/search?type=deposit", Transaction[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().length > 0, "Expected at least one transaction with type 'deposit'");
    }
}
