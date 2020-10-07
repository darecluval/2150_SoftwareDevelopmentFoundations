package cpsc2150.labs.mortgages;

public class MortgageController {

    private IMortgageView view;

    public MortgageController(IMortgageView v) {
        view = v;
    }

    public void submitApplication() {

        int MAX_CREDIT = 850;
        boolean acc = true; // Will remain true if there is no need for input validation (error message)

        //Sets the customer and mortgage constructors from the user's input
        String name = view.getName();
        if (name.isEmpty()) {
            view.printToUser("Please enter your name.");
            acc = false;
        }

        double yearly_I = view.getYearlyIncome();
        if (yearly_I <= 0.0) {
            view.printToUser("Income must be greater than or equal to 0.");
            acc = false;
        }

        double monthly_D = view.getMonthlyDebt();
        if (monthly_D < 0.0) {
            view.printToUser("Debt must be greater than or equal to 0.");
            acc = false;
        }

        int credit_S = view.getCreditScore();
        if ((credit_S <= 0) || (credit_S >= MAX_CREDIT)) {
            view.printToUser("Credit Score must be greater than 0 and less than 850.");
            acc = false;
        }

        double house_C = view.getHouseCost();
        if (house_C <= 0.0) {
            view.printToUser("Cost must be greater than 0.");
            acc = false;
        }

        double down_P = view.getDownPayment();
        if ((down_P <= 0) || (down_P > house_C)) {
            view.printToUser("Down payment must be greater than 0 and less than the cost of the house.");
            acc = false;
        }

        int years = view.getYears();
        if (years <= 0) {
            view.printToUser("Years must be greater than 0.");
            acc = false;
        }

        //If no input validation, calculate approved, payment, and rate (if approved)
        if (acc) {
            Customer cust = new Customer(monthly_D, yearly_I, credit_S, name);
            Mortgage mort = new Mortgage(house_C, down_P, years, cust);

            view.displayApproved(mort.loanApproved());
            if (mort.loanApproved()) {
                view.displayPayment(mort.getPayment());
                view.displayRate(mort.getRate());
            }

        } else { view.displayApproved(acc);} // If validation is requested, deny the loan

    }


}
