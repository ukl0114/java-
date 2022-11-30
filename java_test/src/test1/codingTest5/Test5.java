package test1.codingTest5;

public class Test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 1; 
		int n = 0;
		for (int j = 1; j <8; j++) {
			for (int m = 4; m>k; m--) {
				System.out.printf(" ");
			}
			for (int i = 0; i<=n; i++) {
				System.out.printf("*");
			}
			System.out.println();
			
			if (j < 4) {
				k++;
				n=n+2;
				} else {
					k--;
					n=n-2;
				}	
		}
	}

}
