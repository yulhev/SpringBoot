package lt.vilniustech.YHev.first.controller;

import lt.vilniustech.YHev.first.db.LoanRepository;
import lt.vilniustech.YHev.first.model.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * REST Controller for handling loan-related HTTP requests.
 */
@RestController
@RequestMapping("loans")
public class LoanController {

    @Autowired
    private LoanRepository loanRepository;

    /**
     * Retrieves all loans from the database.
     *
     * @return A list of all loans.
     */
    @GetMapping(produces = "application/json")
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    /**
     * Searches for loans based on provided filters (loan ID or status).
     * If no filter is provided, returns all loans.
     *
     * @param id The ID of the loan to search for (optional).
     * @param status The loan status to search for (optional).
     * @return A list containing matched loans, or an empty list if none found.
     */
    @GetMapping("/search")
    public ResponseEntity<List<Loan>> searchLoans(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String status) {

        // ✅ Search by Loan ID
        if (id != null) {
            Optional<Loan> loanOpt = loanRepository.findById(id);
            return loanOpt.map(loan -> ResponseEntity.ok(Collections.singletonList(loan)))
                    .orElseGet(() -> ResponseEntity.ok(Collections.emptyList()));
        }

        // ✅ Search by Loan Status
        if (status != null) {
            return ResponseEntity.ok(loanRepository.findByStatusContainingIgnoreCase(status));
        }

        // ✅ If no parameters provided, return all loans
        return ResponseEntity.ok(loanRepository.findAll());
    }
}
