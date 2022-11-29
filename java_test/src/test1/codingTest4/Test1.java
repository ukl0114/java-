package test1.codingTest4;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("종류를 선택하세요(1 ~ 3) : ");
		int x = scanner.nextInt();
		
		System.out.print("반복 횟수 : ");
		int y = scanner.nextInt();
		
		System.out.print("출력 : ");
				
		if(x == 1) {
			for(int i =1; i <= y; i++) 
				System.out.print("+");
			
		}else if(x == 2) {
			for(int i =1; i <= y; i++) 
				System.out.print('*');
		}else {
			for(int i =1; i <= y; i++) 
				System.out.print("+*");
		}
	}

}
