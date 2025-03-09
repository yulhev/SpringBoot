package lt.vilniustech.YHev.first.controller;

import lt.vilniustech.YHev.first.db.AccountRepository;
import lt.vilniustech.YHev.first.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * REST Controller for handling account-related HTTP requests.
 */
@RestController
@RequestMapping("accounts")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    /**
     * Retrieves all accounts from the database.
     *
     * @return A list of all accounts.
     */
    @GetMapping(produces = "application/json")
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    /**
     * Searches for accounts based on provided filters (ID or account number).
     *
     * @param id The ID of the account to search for (optional).
     * @param accountNumber The account number to search for (optional).
     * @return A list containing the matched accounts, or an empty list if none found.
     */
    @GetMapping("/search")
    public ResponseEntity<List<Account>> searchAccounts(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String accountNumber) {

        // ✅ Search by ID
        if (id != null) {
            Optional<Account> accountOpt = accountRepository.findById(id);
            if (accountOpt.isPresent()) {
                return ResponseEntity.ok(Collections.singletonList(accountOpt.get()));
            } else {
                return ResponseEntity.ok(Collections.emptyList()); // No account found
            }
        }

        // ✅ Search by Account Number
        if (accountNumber != null) {
            try {
                BigInteger accNum = new BigInteger(accountNumber);
                return ResponseEntity.ok(accountRepository.findByAccountNumber(accNum));
            } catch (NumberFormatException e) {
                return ResponseEntity.badRequest().body(Collections.emptyList()); // Invalid number format
            }
        }

        // ✅ If no parameters provided, return all accounts
        return ResponseEntity.ok(accountRepository.findAll());
    }
}
