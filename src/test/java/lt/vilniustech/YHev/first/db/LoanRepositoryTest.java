package lt.vilniustech.YHev.first.db;

import lt.vilniustech.YHev.first.model.Loan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class LoanRepositoryTest {

    @Autowired
    private LoanRepository loanRepository;

    @BeforeEach
    void setUp() {
        loanRepository.save(new Loan(1, 10000.0f, 5.5f, "approved"));
        loanRepository.save(new Loan(2, 5000.0f, 4.0f, "pending"));
    }

    @Test
    void testFindByStatusContainingIgnoreCase() {
        List<Loan> results = loanRepository.findByStatusContainingIgnoreCase("approved");
        assertThat(results).hasSize(17);
        assertThat(results.get(0).getStatus()).isEqualTo("approved");
    }
}
