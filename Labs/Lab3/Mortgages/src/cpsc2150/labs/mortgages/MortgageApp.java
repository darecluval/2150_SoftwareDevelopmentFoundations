package cpsc2150.labs.mortgages;

/**
 * Created by kplis on 1/23/2018.
 */

public class MortgageApp {

    public static void main(String [] args)
    {

        IMortgageView view = new MortgageView();
        MortgageController controller = new MortgageController(view);
        view.setController(controller);

    }
}
