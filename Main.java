package Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

//게시판 기본사항
//help : 명령어 리스트 (완료)
//list : 일기장 리스트 (완료)
//add : 일기장 추가 (완료)
//detail : 일기장 상세보기 (완료)
//exit 일기장 종료 (완료)
//게시판 추가 요구사항
//delete : 일기장 삭제 (완료-삭제 후 순서 정렬되도록 구현)
//modify : 일기장 수정 (완료)
//signup : 회원가입 (완료-중복체크 구현)
//login : 로그인 (완료)
//logout : 로그아웃 
//로그인 한 회원만 글 작성
//작성자 본인만 삭제/수정
//게시물 페이징
//댓글

public class Main {
   public static void main(String[] args) {

      Scanner scanner = new Scanner(System.in);

         Board board = new Board();

         board.setScanner(scanner);

         board.start();

         scanner.close();

      }
   }

   class Board {

      Scanner scanner;

      void setScanner(Scanner scanner) {
         this.scanner = scanner;
      }

      Article[] articles;

      int articlesLastIndex;

      Member[] members;

      int membersLastIndex;

      boolean login_code = false;

      Board() {
         articles = new Article[100];
         articlesLastIndex = -1;
         members = new Member[100];
         membersLastIndex = -1;
      }

      int lastArticle() {
         return articlesLastIndex + 1;
      }

      void start() {
//         showHelp();
         doCommandLogin();

         while (true) {

            System.out.println("명령어를 보시려면 'help'를 입력해주세요.");
            String command = scanner.next();

            if (command.equals("help")) {
               scanner.nextLine();
               doCommandHelp();
            } else if (command.equals("list")) {
               scanner.nextLine();
               doCommandList();
            } else if (command.equals("add")) {
               scanner.nextLine();
               doCommandAdd();
            } else if (command.equals("detail")) {
               scanner.nextLine();
               System.out.printf("상세보기 할 게시물 번호 입력 : ");
               int idToDetail = scanner.nextInt();
               scanner.nextLine();
               doCommandDetail(idToDetail);
            } else if (command.equals("delete")) {
               scanner.nextLine();
               System.out.printf("삭제 할 게시물 번호 입력 : ");
               int idToDelete = scanner.nextInt();
               scanner.nextLine();
               doCommandDelete(idToDelete);
            } else if (command.equals("modify")) {
               scanner.nextLine();
               System.out.printf("수정 할 게시물 번호 입력 : ");
               int idToModify = scanner.nextInt();
               scanner.nextLine();
               doCommandModify(idToModify);
            } else if (command.equals("recd")) {
               scanner.nextLine();
               System.out.printf("추천 할 게시물 번호 입력 : ");
               int idToRecd = scanner.nextInt();
               scanner.nextLine();
               doCommandRecd(idToRecd);
            } else if (command.equals("signup")) {
               scanner.nextLine();
               doCommandSignup();
            } else if (command.equals("login")) {
               scanner.nextLine();
               doCommandLogin();
            } else if (command.equals("logout")) {
               scanner.nextLine();
               doCommandLogout();
            } else if (command.equals("exit")) {
               scanner.nextLine();
               doCommandExit();
               break;
            } else {
               scanner.nextLine();
               System.out.println("잘못된 명령어 입니다.");
            }
         }
      }

      void doCommandHelp() {
         showHelp();
      }

      void doCommandList() {
         System.out.println("== 게시물 리스트 ==");

         if (articlesLastIndex >= 0) {
            System.out.println("번호  | 날짜                   | 제목          ");
            for (int i = 0; i <= articlesLastIndex; i++) {
               System.out.printf("%d    | %s    | %s         | %d      " + "\n", articles[i].id, articles[i].resDate,
                     articles[i].title, articles[i].recd_count);
            }
         } else {
            System.out.println("게시물이 존재하지 않습니다.");
            return;
         }

      }

      void doCommandAdd() {
         System.out.println("== 게시물 추가 ==");

         Article article = new Article();

         Article lastArticle = null;

         if (articlesLastIndex >= 0) {
            lastArticle = articles[articlesLastIndex];
         }

         int newId;

         if (lastArticle == null) {
            newId = 1;
         } else {
            newId = lastArticle.id + 1;
         }

         article.id = newId;
         article.resDate = getNowDateStr();

         if (login_code == true) {
            System.out.print("제목 : ");
            article.title = scanner.nextLine();
            System.out.println("내용(종료하려면 exit를 입력하세요) : ");
            article.body = "";
            for (;;) {
               article.body1 = scanner.nextLine();
               if (article.body1.equals("exit")) {
                  break;
               }
               article.body += article.body1 + "\n";
            }

            int articlesNewIndex = articlesLastIndex + 1;
            articles[articlesNewIndex] = article;

            System.out.printf("%d번 글이 생성되었습니다.\n", article.id);

            articlesLastIndex++;
         } else if (login_code == false) {
            System.out.println("글 작성을 위해 로그인이 필요합니다.");
            doCommandLogin();
         }

         
      }

      void doCommandDetail(int id) {
         System.out.println("== 게시물 상세 ==");
         if (getArticlesById(id) != null) {
            System.out.printf("    번호    \n%d\n", getArticlesById(id).id);
            System.out.printf("    날짜    \n%s\n", getArticlesById(id).resDate);
            System.out.printf("    제목    \n%s\n", getArticlesById(id).title);
            System.out.printf("    내용    \n%s\n", getArticlesById(id).body);
        
         } else {
            System.out.println("상세보기 할 게시물이 존재하지 않습니다.");
            return;
         }

      }

      void doCommandDelete(int id) {
         System.out.println("== 게시물 삭제 ==");
         if (getArticlesById(id) != null) {
            int temp = getArticlesById(id).id - 1;
            // 배열은 0 1 2 ... 로 시작되는데 삭제 요청 시 사용자가 보기엔 1 2 3 ... 순서로 된 값 중 삭제를 요청
            // 그러므로 앞,뒤 값 정렬 해줄 땐 입력받은 숫자 그대로 for문 돌리면 꼬이니까,입력을 통해 찾은 값의 id -1 해서 진행.
            for (int i = temp; i <= articlesLastIndex; i++) {
               articles[i] = articles[i + 1];
            }
            articlesLastIndex--;
            System.out.printf("%d번 게시물이 삭제 되었습니다.\n", id);
            for (int i = temp; i <= articlesLastIndex; i++) {
               articles[i].id = articles[i].id - 1;
            }
         } else {
            System.out.println("삭제 할 게시물이 존재하지 않습니다.");
            return;
         }
      }

      void doCommandModify(int id) {
         System.out.println("== 게시물 수정 ==");
         if (getArticlesById(id) != null) {
            getArticlesById(id).resDate = getNowDateStr();
            System.out.printf("수정 할 제목 : ");
            getArticlesById(id).title = scanner.nextLine();
            System.out.printf("수정 할 내용 : ");
            getArticlesById(id).body = scanner.nextLine();

            System.out.printf("%d번 게시물 수정이 완료되었습니다.\n", id);
         } else {
            System.out.println("수정 할 게시물이 존재하지 않습니다.");
            return;
         }
      }

      void doCommandRecd(int id) {
         System.out.println("== 게시물 추천 ==");
         if (getArticlesById(id) != null) {
            getArticlesById(id).recd_count++;
            System.out.printf("%d번 게시물 추천이 완료되었습니다.\n", id);
         } else {
            System.out.println("추천 할 게시물이 존재하지 않습니다.");
            return;
         }
      }

      void doCommandSignup() {
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

      void doCommandLogin() {
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
                        System.out.println("exit : 일기장 종료");
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

      void doCommandLogout() {
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

      void doCommandExit() {
         System.out.println("== 게시판 종료 ==");
      }

      void showHelp() {
         System.out.println("====== 명령어 리스트 ======");
         System.out.println("help : 명령어 리스트");
         System.out.println("add : 일기 추가");
         System.out.println("modify : 일기 수정");
         System.out.println("delete : 일기 삭제");
         System.out.println("list : 일기 리스트 보기");
         System.out.println("detail : 일기 상세보기");
         System.out.println("exit 일기장 종료");
         System.out.println("recd : 일기 추천");
         System.out.println("signup : 회원 가입");
         System.out.println("login : 로그인");
         System.out.println("logout : 로그아웃");
         System.out.println();
      }

      Article getArticlesById(int id) {
         for (int i = 0; i <= articlesLastIndex; i++) {
            if (articles[i].id == id) {
               return articles[i];
            }
         }
         return null;
      }

      Article getLastArticles() {
         if (lastArticle() >= 0) {
            return articles[articlesLastIndex];
         }
         return null;
      }

      String getNowDateStr() {
         Calendar cal = Calendar.getInstance();
         SimpleDateFormat Date = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
         String dateStr = Date.format(cal.getTime());
         return dateStr;
      }
   }

   class Article {
      int id;
      String resDate;
      String title;
      String body;
      String body1;
      int recd_count;
      int writer_code;
   }

   class Member {
      int id;
      String regDate;
      String loginId;
      String loginPw;
   }
   