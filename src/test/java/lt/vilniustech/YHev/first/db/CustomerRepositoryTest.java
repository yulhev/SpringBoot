package lt.vilniustech.YHev.first.db;

import lt.vilniustech.YHev.first.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        // Save test data in an in-memory database before each test
        customerRepository.save(new Customer(1, "John", "Doe", "john.doe@example.com"));
        customerRepository.save(new Customer(2, "Alice", "Smith", "alice.smith@example.com"));
    }

    @Test
    void testFindByFirstNameContainingIgnoreCase() {
        List<Customer> results = customerRepository.findByFirstNameContainingIgnoreCase("john");
        assertThat(results).hasSize(1);
        assertThat(results.get(0).getFirstName()).isEqualTo("John");
    }

    @Test
    void testFindByLastNameContainingIgnoreCase() {
        List<Customer> results = customerRepository.findByLastNameContainingIgnoreCase("smith");
        assertThat(results).hasSize(1);
        assertThat(results.get(0).getLastName()).isEqualTo("Smith");
    }

    @Test
    void testFindByEmailContainingIgnoreCase() {
        List<Customer> results = customerRepository.findByEmailContainingIgnoreCase("example");
        assertThat(results).hasSize(2); // Both emails contain "example"
    }
}
