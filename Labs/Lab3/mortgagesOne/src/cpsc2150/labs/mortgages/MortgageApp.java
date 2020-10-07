package cpsc2150.labs.mortgages;

/**
 * Created by kplis on 1/23/2018.
 */

import java.util.Scanner;

public class MortgageApp {

    public static void main(String [] args)
    {

        //Variables
        double debt, income, downPayment, houseCost;
        int years, score;
        String name;

        Scanner input = new Scanner(System.in);

        //Gather information and error check
        System.out.println("What is your name?");
        name = input.nextLine();

        //Input and Error Check Debt
        debt = -1.0;
        while (debt < 0.0) {
            System.out.println("How much are you in debt?");
            debt = input.nextInt();
            if (debt < 0.0) {
                System.out.println("Error. Please enter a positive number or zero.");
            }
        }

        //Input and Error Check Income
        income = -1.0;
        while (income < 0.0) {
            System.out.println("How much do you make in a year?");
            income = input.nextInt();
            if (income < 0) {
                System.out.println("Error. Please enter a positive number or zero.");
            }
        }

        //Input and Error Check Credit Score
        score = -1;
        while (!((score > 0) || (850 < score))) {
            System.out.println("What's your credit score?");
            score = input.nextInt();
            if (!((score > 0) || (850 < score))) {
                System.out.println("Error. Please enter a integer between 0 and 850 (inclusive).");
            }
        }

        //Input and Error Check Down Payment
        downPayment = -1.0;
        while (downPayment <= 0.0) {
            System.out.println("What's your down payment?");
            downPayment = input.nextInt();
            if (downPayment < 0) {
                System.out.println("Error. Please enter a positive number or zero.");
            }
        }

        //Input and Error Check House Cost
        houseCost = -1;
        while (houseCost <= 0.0) {
            System.out.println("How much does the house cost?");
            houseCost = input.nextInt();
            if (houseCost < 0) {
                System.out.println("Error. Please enter a positive number or zero.");
            }
        }

        //Input and Error Check Years
        years = 0;
        while (!(((years % 5) == 0) && (years >= 15) && (years <= 30))) {
            System.out.println("How many years will you be paying off the loan?");
            years = input.nextInt();
            if (!(((years % 5) == 0) && (years >= 15) && (years <= 30))) {
                System.out.println("Error. Please input 15, 20, 25, or 30.");
            }
        }

        //Create customer class and apply for the loan with the given information
        Customer cust = new Customer(debt, income, score, name);
        cust.applyForLoan(downPayment, houseCost, years);
        System.out.println(cust.toString());


    }
}
