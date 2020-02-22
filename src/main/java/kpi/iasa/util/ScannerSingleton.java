package kpi.iasa.util;

import java.util.Scanner;

/**
 * Created by Anton Korol on Feb 20, 2020
 */

public class ScannerSingleton {
	
	private final Scanner sc = new Scanner(System.in);
	
	private ScannerSingleton() {}
	
	public static ScannerSingleton getInstance() {
		return SingletonHelper.INSTANCE;
	}
	
	/**
	 * This method is needed to return scanner which can be usable everywhere as already instantiated object
	 * @return Instance of already instantiated object of Scanner.class
	 */
	public Scanner getScanner() {
		return sc;
	}
	
	private static class SingletonHelper {
		private static final ScannerSingleton INSTANCE = new ScannerSingleton();
	}
	
}
