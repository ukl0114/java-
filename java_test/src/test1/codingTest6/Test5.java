package test1.codingTest6;

import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int [] scores = new int [2];

		for(int i=0; i<scores.length;i++) {
		System.out.print(i+1+"번째 입력 : ");
		scores[i]=scanner.nextInt();         
		}

		for(int i=0; i<scores.length;i++) {
		System.out.println(i+1+"번째: "+scores[i]);
		}
				
		int sum=0;
		for(int i=0; i<scores.length;i++) {
		sum += scores[i];
		}
		System.out.println("총합계 : "+sum);
				
		double avg = sum / 2.0;
		System.out.printf("평균 : %.2f\n" , avg);
		
		int max = Integer.MIN_VALUE;
				
		for(int i=0; i<scores.length;i++) {
		if(max<scores[i]) {  
		max = scores[i];      
			}
		}
		System.out.println("최대금액 : "+max);
				
		int min = Integer.MAX_VALUE; 
				
		for(int i=0; i<scores.length;i++) {
		if(min>scores[i]) { 
		min = scores[i];   
			}
		}
		System.out.println("최소금액 : "+min);
		
				
	} 

}
