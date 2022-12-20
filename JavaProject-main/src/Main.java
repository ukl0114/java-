
import java.util.*;

public class Main {
    public static void main(String[] args) {
        while(true) {
            new Menu().menuPrint();
            System.out.print("메뉴번호를 입력하세요.>>");
            int menuN = Driver.sc.nextInt();

            switch(menuN) {
                case 1 :
                    new StuAdd().add();
                    break;

                case 2 :
                    new EveryList().listAllPrintOut();
                    break;

                case 3 :
                    new StuCheck().check();
                    break;

                case 4 :
                    new Correction().correct();
                    break;

                case 5 :
                    new LineUp().lineUp();
                    break;

                case 6 :
                    new Analysis().analysis();
                    break;

                case 7 :
                    new Delete().delete();
                    break;

                case 8 :
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);

            }
        }
    }
}
