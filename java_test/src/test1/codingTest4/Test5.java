package test1.codingTest4;

import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("숫자를 입력하세요 : ");
		int x = scanner.nextInt();
		
		System.out.print("배수를 입력하세요 : ");
		int y = scanner.nextInt();
		
		for(int i =1; i <= x; i++) {
			if(i % y == 0) {
				System.out.println(i);
			}
		}
		
	}

}
