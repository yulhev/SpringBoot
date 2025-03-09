package lt.vilniustech.YHev.first.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Entity class representing a Loan in the system.
 * Stores loan-related information such as loan amount, interest rate, and loan status.
 */
@Entity
@Table(name="loan")
@XmlRootElement
@XmlType(propOrder = {"id", "loanAmount", "interestRate", "status"})
public class Loan {

    /**
     * Unique identifier for the loan.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private int id;

    /**
     * The amount borrowed for the loan.
     */
    @Column(name="LOANAMOUNT")
    private Float loanAmount;

    /**
     * The interest rate applied to the loan.
     */
    @Column(name="INTERESTRATE")
    private Float interestRate;

    /**
     * The status of the loan (e.g., "approved", "pending", "rejected").
     */
    @Column(name = "STATUS")
    private String status;

    /**
     * Default constructor required by JPA.
     */
    public Loan() {}

    /**
     * Parameterized constructor for initializing a loan.
     *
     * @param id The unique ID of the loan.
     * @param loanAmount The amount borrowed.
     * @param interestRate The interest rate applied to the loan.
     * @param status The status of the loan (approved, pending, rejected).
     */
    public Loan(int id, Float loanAmount, Float interestRate, String status) {
        this.id = id;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.status = status;
    }

    /**
     * Gets the ID of the loan.
     *
     * @return The loan ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the loan.
     *
     * @param id The new loan ID.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the loan amount.
     *
     * @return The amount borrowed.
     */
    public Float getLoanAmount() {
        return loanAmount;
    }

    /**
     * Sets the loan amount.
     *
     * @param loanAmount The new loan amount.
     */
    public void setLoanAmount(Float loanAmount) {
        this.loanAmount = loanAmount;
    }

    /**
     * Gets the interest rate of the loan.
     *
     * @return The interest rate.
     */
    public Float getInterestRate() {
        return interestRate;
    }

    /**
     * Sets the interest rate of the loan.
     *
     * @param interestRate The new interest rate.
     */
    public void setInterestRate(Float interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * Gets the status of the loan.
     *
     * @return The loan status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the loan.
     *
     * @param status The new loan status (approved, pending, rejected).
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
