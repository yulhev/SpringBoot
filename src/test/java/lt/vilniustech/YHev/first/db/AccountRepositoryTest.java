package lt.vilniustech.YHev.first.db;

import lt.vilniustech.YHev.first.model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.math.BigInteger;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @BeforeEach
    void setUp() {
        accountRepository.save(new Account(1, new BigInteger("4556123478903456"), 1000.0f));
        accountRepository.save(new Account(2, new BigInteger("4556987654321010"), 2500.0f));
    }

    @Test
    void testFindByAccountNumber() {
        List<Account> results = accountRepository.findByAccountNumber(new BigInteger("4556123478903456"));
        assertThat(results).hasSize(1);
        assertThat(results.get(0).getAccountNumber()).isEqualTo(new BigInteger("4556123478903456"));
    }
}
