package lt.vilniustech.YHev.first.service;

import lt.vilniustech.YHev.first.model.Account;
import lt.vilniustech.YHev.first.model.Customer;
import lt.vilniustech.YHev.first.model.Loan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class XMLTransformServTest {

    private XMLTransformServ xmlTransformServ;

    @BeforeEach
    void setUp() {
        xmlTransformServ = new XMLTransformServ();
    }

    @Test
    void testTransformXML_CreatesFileSuccessfully() {
        // Arrange: Create a sample customer with an account and a loan
        Customer customer = new Customer(1, "John", "Doe", "john.doe@example.com");

        Account account = new Account(1, new BigInteger("1234567890123456"), 5000.0f);
        Loan loan = new Loan(1, 10000.0f, 5.0f, "approved");

        customer.setAccounts(Collections.singletonList(account));
        customer.setLoans(Collections.singletonList(loan));

        // Act: Transform customer to XML
        String filePath = xmlTransformServ.transformXML(customer);

        // Assert: Check if the file is created
        assertNotNull(filePath, "The returned file path should not be null");
        File file = new File(filePath);
        assertTrue(file.exists(), "The XML file should be created at the specified path");

        // Cleanup: Delete the test file after checking
        file.delete();
    }
}

