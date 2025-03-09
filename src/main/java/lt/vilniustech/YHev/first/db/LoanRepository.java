package lt.vilniustech.YHev.first.db;

import lt.vilniustech.YHev.first.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for Loan entity.
 * Provides methods for retrieving loans based on different criteria.
 */
@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {

    /**
     * Finds loans whose status contains the specified value (case-insensitive).
     *
     * @param status The loan status to search for (e.g., "approved", "pending", "rejected").
     * @return A list of loans matching the given status.
     */
    List<Loan> findByStatusContainingIgnoreCase(String status);
}
