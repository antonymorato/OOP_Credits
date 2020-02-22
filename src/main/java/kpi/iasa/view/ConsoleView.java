package kpi.iasa.view;

import kpi.iasa.entity.Credit;
import kpi.iasa.entity.PersonCredit;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import static kpi.iasa.view.TextConstant.*;
/**
 * Created by Anton Korol on Feb 20, 2020
 */


public class ConsoleView {

    private static final String MESSAGES = "messages";

    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGES,
				new Locale("ua"));
                //  new Locale("en"));

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printBundleMessage(String message){
        printMessage(bundle.getString(message));
    }

    public void printGoodBye() {
        printMessage(bundle.getString(GOODBYE));
    }

    public void printStringInput(String fieldName, String regex) {
        printMessage(concatenateStrings(
                bundle.getString(INPUT_STRING_DATA),
                bundle.getString(fieldName),
                bundle.getString(REGEX),
                regex,
                bundle.getString(COLON)));
    }

    public void printWrongStringInput(String fieldName, String regex) {
        printMessage(concatenateStrings(
                bundle.getString(WRONG_INPUT_DATA),
                bundle.getString(INPUT_STRING_DATA),
                bundle.getString(fieldName),
                bundle.getString(REGEX),
                regex,
                bundle.getString(COLON)));
    }

    public void printCreditTerms(Credit credit,int creditNumber) {
        printCreditNumber(creditNumber);
        printMessage(concatenateStrings(
                bundle.getString(CREDIT_BANK_NAME), bundle.getString(COLON), credit.getBank().getName(),
                bundle.getString(SEPARATOR),
                bundle.getString(CREDIT_PURPOSE), bundle.getString(COLON), credit.getPurpose().toString(),
                bundle.getString(SEPARATOR),
                bundle.getString(CREDIT_RATE), bundle.getString(COLON), credit.getRate().toString(), bundle.getString(PERCENT),
                bundle.getString(SEPARATOR),
                bundle.getString(CREDIT_TERM_IN_MONTHS), bundle.getString(COLON), Integer.toString(credit.getTermInMonths()),
                bundle.getString(SEPARATOR),
                bundle.getString(CREDIT_MAXSUM), bundle.getString(COLON), credit.getMaxSum().toString()));
    }
    public  void printCreditNumber(int number)
    {
        System.out.print(number+".");
    }
    public void printDebtors(List<PersonCredit> personCredits)
    {
        printMessage(bundle.getString(OUTPUT_DEBTORS));
        for (PersonCredit person:personCredits) {
            printMessage(person.getName()+bundle.getString(SEPARATOR)+bundle.getString(OUTPUT_SUMM)+person.getCreditLeft());
        }
    }
    public void showMainMenu()
    {
        printMessage(bundle.getString(MENU));
        printMessage(bundle.getString(MENU_OPTION_ALL_DEBTORS));
        printMessage(bundle.getString(MENU_OPTION_TAKE_CREDIT));
        printMessage(bundle.getString(MENU_OPTION_RELEASE_CREDIT));
        printMessage(bundle.getString(MENU_OPTION_EXIT));
    }
    public void showMenu() {
        printMessage(bundle.getString(MENU));
        printMessage(bundle.getString(MENU_OPTION_ALL_CREDITS));
        printMessage(bundle.getString(MENU_OPTION_SEARCH));
       // printMessage(bundle.getString(MENU_OPTION_EXIT));
    }

    private String concatenateStrings(String...args) {
        StringBuilder concatStr = new StringBuilder();
        for(String str : args) {
            concatStr.append(str);
        }
        return concatStr.toString();
    }

}
