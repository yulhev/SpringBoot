package lt.vilniustech.YHev.first.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.math.BigInteger;
import java.util.List;

/**
 * Entity class representing an Account in the system.
 * Stores account-related information such as account number, balance, and transactions.
 */
@Entity
@Table(name="account")
@XmlRootElement(name = "account")
@XmlType(propOrder = {"id", "accountNumber", "balance", "transactions"})
public class Account {

    /**
     * Unique identifier for the account.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    /**
     * The account number associated with the account.
     */
    private BigInteger accountNumber;

    /**
     * The current balance of the account.
     */
    private Float balance;

    /**
     * Default constructor required by JPA.
     */
    public Account() {}

    /**
     * Parameterized constructor for initializing an account.
     *
     * @param id The unique ID of the account.
     * @param accountNumber The account number.
     * @param balance The balance of the account.
     */
    public Account(int id, BigInteger accountNumber, Float balance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    /**
     * Gets the ID of the account.
     *
     * @return The account ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the account.
     *
     * @param id The new account ID.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the account number.
     *
     * @return The account number.
     */
    public BigInteger getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the account number.
     *
     * @param accountNumber The new account number.
     */
    public void setAccountNumber(BigInteger accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Gets the balance of the account.
     *
     * @return The account balance.
     */
    public Float getBalance() {
        return balance;
    }

    /**
     * Sets the balance of the account.
     *
     * @param balance The new account balance.
     */
    public void setBalance(Float balance) {
        this.balance = balance;
    }

    /**
     * List of transactions associated with this account.
     */
    @OneToMany
    @JoinTable(
            name="transaction_account",
            joinColumns = @JoinColumn(name="account_id"),
            inverseJoinColumns = @JoinColumn(name="transaction_id")
    )
    private List<Transaction> transactions;

    /**
     * Gets the transactions related to this account.
     *
     * @return A list of transactions.
     */
    @XmlElementWrapper(name="transactions")
    @XmlElement(name="transaction")
    public List<Transaction> getTransactions() {
        return transactions;
    }

    /**
     * Sets the transactions associated with this account.
     *
     * @param transactions The list of transactions to set.
     */
    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
