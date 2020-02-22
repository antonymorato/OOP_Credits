package kpi.iasa.controller;


import java.util.Scanner;

import kpi.iasa.util.ScannerSingleton;
import kpi.iasa.view.ConsoleView;


public class UtillityController {

    private ConsoleView consoleView;

    public UtillityController(ConsoleView consoleView) {
        this.consoleView = consoleView;
    }

    /**
     * This method needed to get information from user
     * @param fieldName name of field which user fills with keyboard
     * @param regex regular expression with help one executes checking of input value
     * @return value entered by user
     */
    public String inputStringValueWithScanner(String fieldName, String regex) {

        Scanner sc = ScannerSingleton.getInstance().getScanner();
        String inputStr;

        consoleView.printStringInput(fieldName, regex);
        while ( !(inputStr = sc.next()).matches(regex)) {
            consoleView.printWrongStringInput(fieldName, regex);
        }

        return inputStr;
    }

    /**
     * This method needed to get information from user
     * @param fieldName name of field which user fills with keyboard
     * @param min
     * @param max
     * @return value entered by user
     */
    public int inputIntValueWithScannerInDiapason(String fieldName, int min, int max) {

        Scanner sc = ScannerSingleton.getInstance().getScanner();
        String diapason = new StringBuilder().append('[').append(min).append('-').append(max).append(']').toString();
        int inputInt;

        consoleView.printStringInput(fieldName, diapason);
        while (true) {
            while (!sc.hasNextInt()) {
                consoleView.printWrongStringInput(fieldName, diapason);
                sc.next();
            }

            if ((inputInt = sc.nextInt()) < min || inputInt > max) {
                consoleView.printWrongStringInput(fieldName, diapason);
                continue;
            }
            break;
        }
        return inputInt;
    }

}
