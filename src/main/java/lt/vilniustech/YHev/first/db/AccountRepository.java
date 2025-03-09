package lt.vilniustech.YHev.first.db;

import lt.vilniustech.YHev.first.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

/**
 * Repository interface for Account entity.
 * Provides methods for interacting with the database.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    /**
     * Finds accounts by account number.
     *
     * @param accountNumber The account number to search for.
     * @return A list of accounts that match the given account number.
     */
    List<Account> findByAccountNumber(BigInteger accountNumber);
}
