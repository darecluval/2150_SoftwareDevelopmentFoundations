package cpsc2150.labs.mortgages;


/**
 * Created by kplis on 1/23/2018.
 */

/**
 *
 * @invariant (houseCost > 0.0 and downPayment > 0.0 and percentDown > 0.0 and years > 0 and interestRate > 0.0
 *            and payment > 0.0)
 *
 */
public class Mortgage {



    private double houseCost;
    private double downPayment;
    private double percentDown;
    private int years;
    private double interestRate;
    private double payment;
    private Customer customer;

    //Const Variables
    double BASE_RATE = 0.025, MAX_RATE = 0.1, MIN_PERDOWN = 0.035, DBT_INCRATIO = 0.40;
    int YEARS_CONV = 12, PERC_CONV = 100;

    //Pairs of Levels
    int [] credit_levels = {500, 600, 700, 750};
    double [] interest_levels = {0.1, 0.05, 0.01, .005, 0.0};
    double [] dp_rate = {0.2, 0.005};
    double [] yrs_rate = {30.0, 0.01, 0.005};

    /**
     *
     * @param cost is the house cost
     * @param dp is the down payment of the house
     * @param y is the amount of years the loan will be paid over
     * @param cust holds the customer's information in a Customer class
     *
     * @pre (cost > 0.0 and dp > 0.0 and y > 0, and customer is a valid class)
     *
     */
    Mortgage(double cost, double dp, int y, Customer cust)
    {
        /*
        Sets the house cost, down payment, years and customer. Calculates the percent down, rate, and payment
         */

        //Basic Setters
        houseCost = cost;
        downPayment = dp;
        years = y;
        customer = cust;

        percentDown = downPayment / houseCost;
        calcRate();
        calcPayment();
    }

    // No return - void. Calculates the interest rate by accessing the current loan
    // application's variables.
    /**
     *
     * @pre ( years == 15 || years == 20 || years == 25 || years == 30
     *             <= creditScore <= 850 and priceOfHouse > 0.0)
     *
     * @post [interestRate >= .025]
     *
     */
    private void calcRate()
    {
        //The rate starts at the base rate of 2.5%
        interestRate = BASE_RATE;

        // If the loan is for 30 years, add the normal addition of 1%
        // If the loan is for for less than 30 years, add the good addition of .5%
        // The loan must be for 15, 20, 25 or 30 years
        if (years == (int)yrs_rate[0]) {
            interestRate += yrs_rate[1];
        } else {
            interestRate += yrs_rate[2];
        }

        //Add the rate for the credit score based on the following table
        //        Credit rating | Credit score | add to rate
        //        Bad           | 0 - 500      | 10%
        //        Fair          | 500 - 599    | 5%
        //        Good          | 600 - 699    | 1%
        //        Great         | 700 - 749    | .5%
        //        Excellent     | 750 - 850    | 0%
        int s = customer.getCreditScore();
        if (s <= credit_levels[0]) {
            interestRate += interest_levels[0];
        } else if (s < credit_levels[1]) {
            interestRate += interest_levels[1];
        } else if (s < credit_levels[2]) {
            interestRate += interest_levels[2];
        } else if (s < credit_levels[3]) {
            interestRate += interest_levels[3];
        } else {
            interestRate += interest_levels[4];
        }

        //If the down payment is less than 20% of the price of the house, add .5%
        if (downPayment < (dp_rate[0] * houseCost)) {
            interestRate += dp_rate[1];
        }
    }

    // No return. Calculates monthly payment from the current loan's monthly rate
    // principal payment, and number of payments.
    /**
     *
     * @pre (monthlyRate > 0.0, principalBalance > 0.0, and numberPayments > 0)
     *
     * @post [ monthlyPayment > 0.0 ]
     *
     */
    private void calcPayment()
    {
        /*
        Calculate the monthly payment
        terms:
        r - monthly rate - the interest rate divided by 12
        p - principal balance - the cost of the house minus the down payment
        n - number of payments - the total number of monthly payments

        monthly payment is (rp)/(1-(1+r)^-n)
         */

        double r = interestRate / YEARS_CONV;
        double p = houseCost - downPayment;
        int n = years * YEARS_CONV;

        payment = (r * p) / (1 - (Math.pow((1 + r), -n)));
    }

    /**
     *
     * @return a boolen: true if the loan has been approved, or false if the loan has not been approved
     *
     * @pre (downPayment > 0.0 and income > 0.0)
     *
     * @post [
     *      true if (interestRate < 10)
     *      false if (interestRate >= 10) ]
     *
     */
    public boolean loanApproved()
    {
        //If the interest rate is too high (10% or higher) the loan is denied
        if (getRate() >= MAX_RATE) {
            return false;
        }

        //If the down payment is less than 3.5% of the price of the house then the loan is denied
        if (percentDown < MIN_PERDOWN) {
            return false;
        }

        //If the Debt to income ratio is above 40% the loan is denied
        //The debt to income ratio is the total monthly debt payments (including the mortgage payment) / monthly income
        if ((((customer.getMonthlyDebtPayments()) + getPayment()) / (customer.getIncome()/YEARS_CONV)) >= DBT_INCRATIO) {
            return false;
        }

        //Otherwise return true
        return true;
    }

    /**
     *
     * @return the monthly payment on the current loan
     *
     * @post [
     *      payment > 0.0 ]
     *
     */
    public double getPayment()
    {
        //return the monthly payment on the loan
        return payment;
    }

    /**
     *
     * @return the interest rate on the current loan
     *
     * @post [
     *      rate > 0.0 ]
     *
     */
    public double getRate()
    {
        //return the interest rate on the loan
        return interestRate;
    }


    // No contracts are needed.
    /**
     *
     * @return a string displaying the customer's information
     *
     * @post a string displaying the customer's information if the loan is approved
     *      or return a string displaying "Loan was not approved" if the loan is not approved
     */
    @Override
    public String toString()
    {
        //this function is provided
        //DO you need contracts for this?
        String str = "";
        if(loanApproved())
        {
            str += "Principal Amount: $" + (houseCost - downPayment) + "\n";
            str += "Interest Rate: " + (interestRate * PERC_CONV) + "%\n";
            str += "Term: " + years + " years\n";
            str += "Monthly Payment: $" + payment + "\n";
        }
        else
        {
            str += "Loan was not approved";
        }
        return str;
    }

}
