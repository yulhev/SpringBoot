package lt.vilniustech.YHev.first.controller;

import lt.vilniustech.YHev.first.model.Loan;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoanControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetAllLoans() {
        ResponseEntity<Loan[]> response = restTemplate.getForEntity("/loans", Loan[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().length > 0, "Expected at least one loan");
    }

    @Test
    public void testSearchLoanByStatus() {
        ResponseEntity<Loan[]> response = restTemplate.getForEntity("/loans/search?status=approved", Loan[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().length > 0, "Expected at least one loan with status 'approved'");
    }
}
