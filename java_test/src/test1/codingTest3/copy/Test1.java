package test1.codingTest3.copy;

public class Test1 {

	public static void main(String[] args) {
		
		int y =  (int)(Math.random() * 3);
		
		if(y == 0) {
			System.out.println(y + " : 가위");
		}else if(y == 1) {
			System.out.println(y + " : 바위");
		}else {
			System.out.println(y + " : 보");
		}
		
	}

}
