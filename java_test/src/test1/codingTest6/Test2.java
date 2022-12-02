package test1.codingTest6;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("십진수를 입력해주세여 : " );
		
		int x = scanner.nextInt();
		System.out.println("십진수 : "+x);
		
		System.out.println("2진법 : " + Integer.toBinaryString(x)); // 2진법 변환
        System.out.println("8진법 : " +Integer.toOctalString(x));  // 8진법 변환
        System.out.println("16진법 : " +Integer.toHexString(x));    // 16진법 변환
		
	}

}
