package lt.vilniustech.YHev.first.controller;

import lt.vilniustech.YHev.first.model.Account;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetAllAccounts() {
        ResponseEntity<Account[]> response = restTemplate.getForEntity("/accounts", Account[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().length > 0, "Expected at least one account");
    }

    @Test
    public void testSearchAccountByAccountNumber() {
        ResponseEntity<Account[]> response = restTemplate.getForEntity("/accounts/search?accountNumber=4556123478903456", Account[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().length > 0, "Expected at least one account with accountNumber");
    }
}
