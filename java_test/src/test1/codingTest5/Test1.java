package test1.codingTest5;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("키를 입력해주세요 : ");
		double height = scanner.nextDouble();
		
		System.out.print("몸무게를 입력해주세요 : ");
		double weight = scanner.nextDouble();
		
		double bmi = weight / ((height / 100) * (height / 100));
		System.out.println(bmi);
		
	}

}
