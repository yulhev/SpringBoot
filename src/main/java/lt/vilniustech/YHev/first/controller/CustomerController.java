package lt.vilniustech.YHev.first.controller;

import lt.vilniustech.YHev.first.db.CustomerRepository;
import lt.vilniustech.YHev.first.model.Customer;
import lt.vilniustech.YHev.first.service.XMLTransformServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * REST Controller for handling customer-related HTTP requests.
 */
@RestController
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private XMLTransformServ xmlTransformServ;

    /**
     * Retrieves all customers from the database and generates an XML file for each customer.
     *
     * @return A list of all customers.
     */
    @GetMapping(produces = "application/json")
    public List<Customer> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();

        // ✅ Generate XML files for each customer
        for (Customer customer : customers) {
            xmlTransformServ.transformXML(customer);
        }

        return customers;
    }

    /**
     * Searches for customers based on provided filters (first name, last name, or email).
     * If no filter is provided, returns all customers.
     *
     * @param firstName The first name to search for (optional).
     * @param lastName The last name to search for (optional).
     * @param email The email to search for (optional).
     * @return A list of customers matching the given criteria.
     */
    @GetMapping("/search")
    public ResponseEntity<List<Customer>> searchCustomers(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String email) {

        if (firstName != null) {
            return ResponseEntity.ok(customerRepository.findByFirstNameContainingIgnoreCase(firstName));
        } else if (lastName != null) {
            return ResponseEntity.ok(customerRepository.findByLastNameContainingIgnoreCase(lastName));
        } else if (email != null) {
            return ResponseEntity.ok(customerRepository.findByEmailContainingIgnoreCase(email));
        } else {
            return ResponseEntity.ok(customerRepository.findAll()); // ✅ Return all customers if no filter is given
        }
    }
}
