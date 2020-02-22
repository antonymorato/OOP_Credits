package kpi.iasa.controller;

import java.util.ArrayList;
import java.util.List;

import kpi.iasa.entity.Credit;
import kpi.iasa.entity.Credits;
import kpi.iasa.view.ConsoleView;
import kpi.iasa.view.TextConstant;

/**
 * Created by Anton Korol on Feb 20, 2020
 */

public class CreditController {

    private ConsoleView consoleView;

    public CreditController(ConsoleView consoleView) {
        this.consoleView = consoleView;
    }

    /**
     * Get all credits from enumerator
     * @return
     */
    public List<Credit> getAllCreditsTerms() {
        List<Credit> creditsTerms = new ArrayList<>();

        for (Credits c : Credits.values()) {
            creditsTerms.add(c.getCreditTerms());
        }

        return creditsTerms;
    }

    /**
     * TODO: Hardcode
     * @param credits
     * @return
     */
    public List<Credit> getCreditsTermsByPurposeAndTerm(List<Credit> credits) {
        Credit.Purpose purposeCriteria = inputCreditPurposeWithScanner();
        int termCriteria = inputCreditTermWithScanner(credits);

        return getCreditsTermsByCriteria(credits, purposeCriteria, termCriteria);
    }

    /**
     * This method takes criteria from user and return list of credits which matches with criteria
     * @param credits
     * @param purposeCriteria
     * @param termCriteria
     * @return
     */
    public List<Credit> getCreditsTermsByCriteria(List<Credit> credits,
                                                  Credit.Purpose purposeCriteria,
                                                  int termCriteria) {

        List<Credit> res = new ArrayList<>();

        if (credits == null) {
            return res;
        }

        for (Credit credit : credits) {
            if (credit.getPurpose().equals(purposeCriteria) &&
                    credit.getTermInMonths() == termCriteria) {
                res.add(credit);
            }
        }

        return res;
    }

    /**
     * This method gives user information about credit purposes and then gets his choice
     * @return
     */
    private Credit.Purpose inputCreditPurposeWithScanner() {

        Credit.Purpose[] purposes = Credit.Purpose.values();

        for (int i = 0; i < purposes.length; i++) {
            consoleView.printMessage(i + " - " + purposes[i]);
        }

        int purposeId = new UtillityController(consoleView)
                .inputIntValueWithScannerInDiapason(TextConstant.CREDIT_PURPOSE, 0, purposes.length - 1);

        return purposes[purposeId];

    }

    /**
     * This method gives user information about credit terms in mouths and then gets his choice
     * @return
     */
    private int inputCreditTermWithScanner(List<Credit> credits) {

        List<Integer> terms = new ArrayList<>();

        for (Credit credit : credits) {
            int term = credit.getTermInMonths();

            if (!terms.contains(term)) {
                terms.add(term);
            }
        }

        for (int i = 0; i < terms.size(); i++) {
            consoleView.printMessage(i + " - " + terms.get(i));
        }

        int term = new UtillityController(consoleView)
                .inputIntValueWithScannerInDiapason(TextConstant.CREDIT_TERM_IN_MONTHS, 0, terms.size() - 1);

        return terms.get(term);

    }




}
