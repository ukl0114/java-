package test1.codingTest5;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 for (int i = 0; i < 5; i++) {
	            for (int j = 1; j <= i; j++) {
	                System.out.print(" ");
	            }
	            for (int k = 7 ; k >= i*2+1; k--) {
	                System.out.print("*");
	            }
	            System.out.println();
		 }
	}
}

