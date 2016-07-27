package util;

import java.util.Scanner;

public class InputScanner {
	public static String getString(){
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		return input;
	}
}
