package lt.vilniustech.YHev.first.db;

import lt.vilniustech.YHev.first.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for Transaction entity.
 * Provides methods for retrieving transactions based on different criteria.
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    /**
     * Finds transactions whose type contains the specified value (case-insensitive).
     *
     * @param type The transaction type to search for (e.g., "deposit", "withdrawal", "transfer").
     * @return A list of transactions matching the given type.
     */
    List<Transaction> findByTypeContainingIgnoreCase(String type);
}
