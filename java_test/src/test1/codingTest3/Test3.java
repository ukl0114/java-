package test1.codingTest3;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("양수값 입력 : ");
			String strA= scanner.nextLine();
			int x = Integer.parseInt(strA);
			if(x > 99 && x < 1000 ) {
				System.out.println("세자리 숫자 입니다");
				break;
			}else {
				System.out.println("세자리 숫자가 아닙니다.");
			}
		}
	
	}

}
