package lt.vilniustech.YHev.first.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

import java.util.List;

/**
 * Entity class representing a Customer in the system.
 * Stores customer-related information such as name, email, accounts, and loans.
 */
@Entity
@Table(name="customer")
@XmlRootElement
@XmlType(propOrder = {"id", "firstName", "lastName", "email", "accounts", "loans"})
public class Customer {

    /**
     * Unique identifier for the customer.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    /**
     * First name of the customer.
     */
    private String firstName;

    /**
     * Last name of the customer.
     */
    private String lastName;

    /**
     * Email address of the customer.
     */
    private String email;

    /**
     * Default constructor required by JPA.
     */
    public Customer() {}

    /**
     * Parameterized constructor for initializing a customer.
     *
     * @param id The unique ID of the customer.
     * @param firstName The first name of the customer.
     * @param lastName The last name of the customer.
     * @param email The email address of the customer.
     */
    public Customer(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /**
     * Gets the ID of the customer.
     *
     * @return The customer ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the customer.
     *
     * @param id The new customer ID.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the first name of the customer.
     *
     * @return The first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the customer.
     *
     * @param firstName The new first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the customer.
     *
     * @return The last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the customer.
     *
     * @param lastName The new last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the email address of the customer.
     *
     * @return The email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the customer.
     *
     * @param email The new email address.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * List of accounts associated with the customer.
     */
    @OneToMany
    @JoinTable(
            name="Customer_Account",
            joinColumns = @JoinColumn(name="customer_id"),
            inverseJoinColumns = @JoinColumn(name="account_id")
    )
    private List<Account> accounts;

    /**
     * Gets the list of accounts linked to this customer.
     *
     * @return A list of accounts.
     */
    @XmlElementWrapper(name="accounts")
    @XmlElement(name="account")
    public List<Account> getAccounts() {
        return accounts;
    }

    /**
     * Sets the list of accounts associated with the customer.
     *
     * @param accounts The list of accounts to set.
     */
    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    /**
     * List of loans associated with the customer.
     */
    @OneToMany
    @JoinTable(
            name="Loan_Customer",
            joinColumns = @JoinColumn(name="customer_id"),
            inverseJoinColumns = @JoinColumn(name="loan_id")
    )
    private List<Loan> loans;

    /**
     * Gets the list of loans linked to this customer.
     *
     * @return A list of loans.
     */
    @XmlElementWrapper(name="loans")
    @XmlElement(name="loan")
    public List<Loan> getLoans() {
        return loans;
    }

    /**
     * Sets the list of loans associated with the customer.
     *
     * @param loans The list of loans to set.
     */
    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }
}
