package test1.codingTest4;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("숫자를 입력하세요 : ");
		int x = scanner.nextInt();
		
		System.out.print("오른쪽으로 이동 횟수 : ");
		int y = scanner.nextInt();
		
		System.out.print("왼쪽으로 이동 횟수 : ");
		int z = scanner.nextInt();
		
		String num = Integer.toBinaryString(x);
		String numright = Integer.toBinaryString(x>>y);
		String numleft = Integer.toBinaryString(x<<z);
		
		System.out.println("오른쪽으로 이동한 횟수 : "+numright);
		System.out.println("왼쪽으로 이동한 횟수 : "+numleft);
		
	}

}
