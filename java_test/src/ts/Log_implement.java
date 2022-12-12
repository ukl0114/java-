package ts;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;





public class Log_implement extends Schedule_implement implements Log_interface{
	Scanner scanner = new Scanner(System.in);
	
	Log_implement() {
		articles = new Article[100];
		articlesLastIndex = -1;
		members = new Member[100];
		membersLastIndex = -1;
	}
	
   Member[] members;
   Article[] articles;

   int articlesLastIndex;
   int membersLastIndex;
   
   boolean login_code = false;
   

   
   String getNowDateStr() {
      Calendar cal = Calendar.getInstance();
      SimpleDateFormat Date = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
      String dateStr = Date.format(cal.getTime());
      return dateStr;
   }
   
   @Override
   public void doCommandSignup() {
      System.out.println("======== 회원 가입 ========");

      Member member = new Member();

      Member lastMember = null;

      if (membersLastIndex >= 0) {
         lastMember = members[membersLastIndex];
      }

      int newId;

      if (lastMember == null) {
         newId = 1;
      } else {
         newId = lastMember.id + 1;
      }

      member.id = newId;
      member.regDate = getNowDateStr();
      System.out.printf("회원가입 아이디 : ");
      member.loginId = scanner.next();
      scanner.nextLine();

      if (membersLastIndex >= 0) {
         for (int i = 0; i <= membersLastIndex; i++) {
            if (member.loginId.equals(members[i].loginId)) {
               System.out.printf("중복된 아이디가 존재합니다.\n");
               doCommandSignup();
            }
         }
      }

      System.out.printf("회원가입 비밀번호 : ");
      member.loginPw = scanner.next();
      scanner.nextLine();

      int membersNewIndex = membersLastIndex + 1;
      members[membersNewIndex] = member;

      System.out.printf("%s님 회원가입을 축하합니다.\n", member.loginId);

      membersLastIndex++;

      doCommandLogin();
   }

   @Override
   public void doCommandLogin() {
      System.out.println("========  로그인  ========");
      if (membersLastIndex >= 0) {

         if (login_code == true) {
            System.out.println("현재 다른 사용자가 로그인 중입니다.");
            return;
         } else if (login_code == false) {
            System.out.printf("아이디 입력 : ");
            String temp_Id = scanner.next();
            scanner.nextLine();
            for (int i = 0; i <= membersLastIndex; i++) {
               if (temp_Id.equals(members[i].loginId)) {
                  System.out.printf("비밀번호 입력 : ");
                  String temp_Pw = scanner.next();
                  scanner.nextLine();
                  if (temp_Pw.equals(members[i].loginPw)) {
                     login_code = true;
                     System.out.printf("%s님 환영합니다.\n", temp_Id);
                     System.out.println("====== 명령어 리스트 ======");
             		System.out.println("help : 명령어 리스트");
             		System.out.println("add : 일기 추가");
             		System.out.println("modify : 일기 수정");
             		System.out.println("delete : 일기 삭제");
             		System.out.println("list : 일기 리스트 보기");
             		System.out.println("detail : 일기 상세보기");
             		System.out.println("schedule : 스케줄 확인하기");
             		System.out.println("exit 일기장 종료");
             		System.out.println("signup : 회원 가입");
             		System.out.println("login : 로그인");
             		System.out.println("logout : 로그아웃");
                  } else {
                     System.out.println("비밀번호가 일치하지 않습니다.");
                  }
               } else {
                  System.out.println("아이디가 존재하지 않습니다.");
               }
            }
         }
      } else {
         System.out.println("회원 가입이 필요합니다.");
         doCommandSignup();
      }
   }

   @Override
   public void doCommandLogout() {
      if (login_code == true) {
         System.out.printf("로그아웃 하시겠습니까? (Y / N) ");
         String temp_logout = scanner.next();
         scanner.nextLine();

         if (temp_logout.equals("Y") || temp_logout.equals("y")) {
            login_code = false;
            System.out.println("로그아웃 되었습니다.");
            doCommandLogin();
         } else if (temp_logout.equals("N") || temp_logout.equals("n")) {
            System.out.println("로그아웃이 취소되었습니다.");
            return;
         }

      } else if (login_code == false) {
         System.out.println("현재 로그인 중이지 않습니다.");
         doCommandLogin();
      }
   }
   
}