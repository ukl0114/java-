package test1.codingTest4;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("금액을 입력하세요 : ");
		int money = scanner.nextInt();
		
		int a, b, c, d, e, f, g, m_10000, m_5000, m_1000, m_500, m_100, m_50;
	
		a = money / 10000;
		m_10000 = money % 10000;
		b = m_10000 / 5000;
		m_5000 = m_10000 % 5000;
		c = m_5000 / 1000;
		m_1000 = m_5000 % 1000;
		d = m_1000 / 500;
		m_500 = m_1000 % 500;
		e = m_500 / 100;
		m_100 = m_500 % 100;
		f = m_100 / 50;
		m_50 = m_100 % 50;
		g = m_50 / 10;
		
		
		System.out.println("만원 : " + a);
		System.out.println("오천원 : " + b);
		System.out.println("천원 : " + c);
		System.out.println("오백원 : " + d);
		System.out.println("백원 : " + e);
		System.out.println("오십원 : " + f);
		System.out.println("십원 : " + g);
	}

}
