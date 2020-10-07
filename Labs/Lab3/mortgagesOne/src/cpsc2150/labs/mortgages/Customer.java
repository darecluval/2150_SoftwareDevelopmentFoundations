package cpsc2150.labs.mortgages;

/**
 * Created by kplis on 1/23/2018.
 */

/**
 *
 * @invariant (income >= 0 and [name is valid] and 0 <= creditScore <= 850
 *            and monthlyDebtPayments >= 0)
 *
 */
public class Customer {
    private String name;

    private double monthlyDebtPayments;
    private double income;
    private int creditScore;
    private Mortgage loan;

    /**
     *
     * @param debt is the monthly debt payments
     * @param inc if the customer's income
     * @param score is the customer's credit score
     * @param n is the customer's name
     *
     * @pre (debt > 0.0 and inc >= 0.0 and 0 <= score <= 850 and n is valid)
     *
     */
    Customer( double debt, double inc, int score, String n)
    {

        monthlyDebtPayments = debt;
        income = inc;
        creditScore = score;
        name = n;

        /*
        Set the monthly debt payments, income, credit score and name
        Credit scores range from 0 - 850
         */


    }

    /**
     *
     * @param downPayment a double that contains customer's down payment
     * @param houseCost a double of the cost of a customer's house
     * @param years number of years for the span of the loan
     * @return true if the loan is approved or false if the loan is not approved
     *
     * @pre
     *      [ downPayment > 0.0 and
     *      houseCost > 0.0 and
     *      yeasrs > 0 ]
     *
     * @post [applyForLoan returns true or false if the loan was approved or not]
     *
     */
    public boolean applyForLoan(double downPayment, double houseCost, int years)
    {
        //Take the parameters and apply for a loan. Save the loan details as the customers current loan
        loan = new Mortgage(houseCost, downPayment, years, this);

        // Return whether or not the loan was approved
        return loan.loanApproved();

    }

    /**
     *
     * @return interest rate on the current loan
     *
     * @post
     *      [ interestRate > 0.0 ]
     *
     */
    public double getRate()
    {
        //return the interest rate on the current loan
        return loan.getRate();
    }


    /**
     *
     * @return monthly payment on the current loan
     *
     * @post
     *      [ monthlyPayment > 0.0 ]
     *
     */
    public double getMonthlyPay()
    {
        //return the monthly payment on the current loan
        return loan.getPayment();
    }

    /**
     *
     * @return a monthly debt payment
     *
     * @post
     *      [ monthlyDebtPayment > 0.0 ]
     *
     */
    public double getMonthlyDebtPayments()
    {
        //return the customers monthly debt payments
        return monthlyDebtPayments;
    }

    /**
     *
     * @return a double >= 0 (maybe unemployed?) representing the customer's income
     *
     * @post
     *      [ income > 0.0]
     *
     */
    public double getIncome()
    {
        //return the customers income
        return income;
    }

    /**
     *
     * @return the customer's credit score
     *
     * @post
     *      [ 0 <= creditScore <= 850 ]
     *
     */
    public int getCreditScore()
    {
        //return the customers credit score
        return creditScore;
    }


    // No contracts are needed.
    /**
     *
     * @return a string displaying the customer's information
     *
     * @post
     *      [ str must be valid ]
     *
     */
    @Override
    public String toString()
    {
        String str = "";
        str += "Name: " + name + "\n";
        str += "Income: $" + income + "\n";
        str += "Credit Score: " + creditScore + "\n";
        str += "Monthly Debt: $" + monthlyDebtPayments + "\n";
        str += "Mortgage info: \n";
        if( loan != null) {
            str += loan.toString();
        }
        return str; }
}
