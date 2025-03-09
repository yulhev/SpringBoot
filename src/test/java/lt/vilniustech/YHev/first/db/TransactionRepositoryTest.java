package lt.vilniustech.YHev.first.db;

import lt.vilniustech.YHev.first.model.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Date;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class TransactionRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TransactionRepository transactionRepository;

    private Transaction transaction1;
    private Transaction transaction2;


    @Test
    void testFindByTypeContainingIgnoreCase() {
        List<Transaction> results = transactionRepository.findByTypeContainingIgnoreCase("deposit");

        assertThat(results).hasSize(16);
        assertThat(results.get(0).getType()).isEqualToIgnoringCase("deposit");
    }
    @Test
    void testFindByExactType() {
        List<Transaction> results = transactionRepository.findByTypeContainingIgnoreCase("withdrawal");

        assertThat(results).hasSize(11);
        assertThat(results.get(0).getType()).isEqualTo("withdrawal");
    }

    // ✅ Test: Find transactions by non-existing type
    @Test
    void testFindByNonExistingType() {
        List<Transaction> results = transactionRepository.findByTypeContainingIgnoreCase("transfer");

        assertThat(results).isEmpty();
    }


}
