package test1.codingTest7;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("숫자를 입력해주세요.");
		int a = scanner.nextInt();
		System.out.println("숫자를 입력해주세요.");
		int b = scanner.nextInt();
		System.out.println("숫자를 입력해주세요.");
		int c = scanner.nextInt();
		System.out.println("숫자를 입력해주세요.");
		int d = scanner.nextInt();
		
		int ab = a+b;
		int cd = c+d;
		
		if (ab > cd)
			System.out.println("True");
		else
			System.out.println("False");
	}

}
