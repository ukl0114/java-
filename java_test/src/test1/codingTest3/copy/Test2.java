package test1.codingTest3.copy;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("1월 ~ 12월 사이의 값을 입력하세요 : ");
		String strA= scanner.nextLine();
		int x = Integer.parseInt(strA);
		
		switch(x){
		case  3:
		case  4:
		case  5: System.out.println("봄"); break;
		case  6:
		case  7:
		case  8: System.out.println("여름"); break;
		case  9:
		case  10:
		case  11: System.out.println("가을"); break;
		default : System.out.println("겨울"); break;
			
		}
	}

}
