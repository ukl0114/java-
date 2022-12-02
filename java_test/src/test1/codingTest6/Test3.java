package test1.codingTest6;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print("  ");
		
		for(int a = 2; a < 10; a++) {
			System.out.print(" "+ a + " ");
		}
		
		System.out.println();
		
		for(int b = 1; b <30; b++) {
			if(b == 3) {
				System.out.print("+");
			}
			System.out.print("-");
			
		}
		System.out.println();
		for(int i = 1; i <10; i++) {
			System.out.print(i+" |");
			for(int j = 2; j < 10; j++) {
				if(i * j <10) {
					System.out.print(i * j + "  ");
				}else {
					System.out.print(i * j + " ");
				}
					
			}
			System.out.println("\n");
			
		}
	}

}
