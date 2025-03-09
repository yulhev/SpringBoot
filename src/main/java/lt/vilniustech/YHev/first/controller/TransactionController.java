package lt.vilniustech.YHev.first.controller;

import lt.vilniustech.YHev.first.db.TransactionRepository;
import lt.vilniustech.YHev.first.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * REST Controller for handling transaction-related HTTP requests.
 */
@RestController
@RequestMapping("transactions")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    /**
     * Retrieves all transactions from the database.
     *
     * @return A list of all transactions.
     */
    @GetMapping(produces = "application/json")
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    /**
     * Searches for transactions based on provided filters (transaction ID or type).
     * If no filter is provided, returns all transactions.
     *
     * @param id The ID of the transaction to search for (optional).
     * @param type The type of transaction (e.g., "deposit", "withdrawal", "transfer") (optional).
     * @return A list containing matched transactions, or an empty list if none found.
     */
    @GetMapping("/search")
    public ResponseEntity<List<Transaction>> searchTransactions(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String type) {

        // ✅ Search by Transaction ID
        if (id != null) {
            Optional<Transaction> transactionOpt = transactionRepository.findById(id);
            return transactionOpt.map(transaction -> ResponseEntity.ok(Collections.singletonList(transaction)))
                    .orElseGet(() -> ResponseEntity.ok(Collections.emptyList()));
        }

        // ✅ Search by Transaction Type
        if (type != null) {
            return ResponseEntity.ok(transactionRepository.findByTypeContainingIgnoreCase(type));
        }

        // ✅ If no parameters provided, return all transactions
        return ResponseEntity.ok(transactionRepository.findAll());
    }
}
