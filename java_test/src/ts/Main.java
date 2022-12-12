package ts;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		Diary_implement diary = new Diary_implement();
//		Log_implement log = new Log_implement();
//		Schedule_implement schedule = new Schedule_implement();
		Sys_implement sys = new Sys_implement();
		
		sys.setScanner(scanner);

		sys.start();

		scanner.close();
	}

}
