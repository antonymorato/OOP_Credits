package kpi.iasa.controller;

import java.math.BigDecimal;
import java.util.List;

import kpi.iasa.entity.Credit;
import kpi.iasa.entity.PersonCredit;
import kpi.iasa.model.CreditModel;
import kpi.iasa.view.ConsoleView;
import kpi.iasa.view.TextConstant;

/**
 * Created by Anton Korol on Feb 20, 2020
 */

public class MainController {

    private ConsoleView consoleView;
    private UtillityController utillityController;
    private CreditModel creditModel;
    CreditController creditTermsController;
    private PersonCreditController personCreditController;

    public MainController(ConsoleView consoleView,CreditModel creditModel)
    {
        this.creditModel=creditModel;
        this.consoleView = consoleView;
        utillityController = new UtillityController(consoleView);
        creditTermsController = new CreditController(consoleView);
        personCreditController=new PersonCreditController(creditModel);

    }

    public void mainProcess(){
        for (;;) {
            consoleView.showMainMenu();
            int chosen=utillityController.inputIntValueWithScannerInDiapason(TextConstant.MENU_OPTION,1,4);
            switch (chosen) {
                case 1: {
                    showAllDebtors();
                    break;
                }
                case 2: {
                    process();
                    break;
                }
                case 3: {
                    releaseCredit();
                    break;
                }
                //exit
                case 4: {
                    consoleView.printGoodBye();
                    System.exit(1);
                    break;
                }
            }

        }

    }


    public void process() {
        List<Credit> credits = creditTermsController.getAllCreditsTerms();


        // Menu option
        consoleView.showMenu();
        int res = 0,chosen = utillityController.inputIntValueWithScannerInDiapason(TextConstant.MENU_OPTION, 1, 3);

        // All credits
        if (chosen == 1) {
            int i=0;
            for (Credit credit : credits) {
                consoleView.printCreditTerms(credit,i++);

            }
            res=utillityController.inputIntValueWithScannerInDiapason(TextConstant.MENU_OPTION_INPUT,0,i);

        }

        // Credits by criteria
        if (chosen == 2) {
            int i=0;
            for (Credit credit :credits=creditTermsController.getCreditsTermsByPurposeAndTerm(credits)) {

                consoleView.printCreditTerms(credit,i++);


            }
            res=utillityController.inputIntValueWithScannerInDiapason(TextConstant.MENU_OPTION_INPUT,0,i);

        }


    takeCredit(res,credits);

    }

    public void takeCredit(int number,List<Credit> credits){

        String name=utillityController.inputStringValueWithScanner(TextConstant.NAME_INPUT,RegexContainer.REGEX_NAME);
        BigDecimal value=new BigDecimal(utillityController.inputIntValueWithScannerInDiapason(TextConstant.SUMM_INPUT,0,
                (credits.get(number).getMaxSum().intValue())));
        creditModel.addPersonCredit(new PersonCredit(credits.get(number),value,name));


    }
    public void releaseCredit()
    {
        BigDecimal left=new BigDecimal(0);
        String name = utillityController.inputStringValueWithScanner(TextConstant.NAME_DEBTOR_INPUT,
                RegexContainer.REGEX_NAME);
        for (PersonCredit person:creditModel.getPersonCreditsList()
             ) {if (person.getName().equals(name))
                 left=new BigDecimal(String.valueOf(person.getCreditLeft()));

        }
        BigDecimal value=new BigDecimal(utillityController.inputIntValueWithScannerInDiapason(TextConstant.SUMM_INPUT_TO_PAY,
                0,left.intValue()));
        personCreditController.releaseCredit(name,value);



    }
    public void showAllDebtors()
    {
        consoleView.printDebtors(personCreditController.getAllDebts(creditModel.getPersonCreditsList()));

    }



}
