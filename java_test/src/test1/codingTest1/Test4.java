package test1.codingTest1;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("첫 번째 숫자를 입력하세요 : ");
		String x= scanner.nextLine();
		int a= Integer.parseInt(x);
		
		System.out.print("두 번째 숫자를 입력하세요 : ");
		String y= scanner.nextLine();
		int b= Integer.parseInt(y);
		
		System.out.print("세 번째 숫자를 입력하세요 : ");
		String z= scanner.nextLine();
		int c= Integer.parseInt(z);
		
		if(a>b && a<c || a<b && a>c) {
			System.out.println("최대값은: " + a);
		}else if(b>a && b<c || b<a && b>c) {
			System.out.println("최대값은: " + b);
		}else {
			System.out.println("최대값은: " + c);
		}
	}

}
