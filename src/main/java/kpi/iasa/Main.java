package kpi.iasa;

import kpi.iasa.controller.MainController;
import kpi.iasa.model.CreditModel;
import kpi.iasa.view.ConsoleView;

/**
 * Created by
 * @author  Anton Korol
 * on Feb 20, 2020
 * @version 1.0
 */
public class Main {
	
	public static void main(String... args) {
		ConsoleView consoleView = new ConsoleView();
		MainController mainController = new MainController(consoleView,new CreditModel());
		mainController.mainProcess();


		
	}
	
}
