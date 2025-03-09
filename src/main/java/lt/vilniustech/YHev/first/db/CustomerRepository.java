package lt.vilniustech.YHev.first.db;

import lt.vilniustech.YHev.first.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for Customer entity.
 * Provides methods for retrieving customers based on different criteria.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    /**
     * Finds customers whose first name contains the specified value (case-insensitive).
     *
     * @param firstName The first name to search for.
     * @return A list of customers matching the given first name.
     */
    List<Customer> findByFirstNameContainingIgnoreCase(String firstName);

    /**
     * Finds customers whose last name contains the specified value (case-insensitive).
     *
     * @param lastName The last name to search for.
     * @return A list of customers matching the given last name.
     */
    List<Customer> findByLastNameContainingIgnoreCase(String lastName);

    /**
     * Finds customers whose email contains the specified value (case-insensitive).
     *
     * @param email The email to search for.
     * @return A list of customers matching the given email.
     */
    List<Customer> findByEmailContainingIgnoreCase(String email);
}
