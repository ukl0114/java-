package test2;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Scanner;
public class Test12 {

	public static void main(String[] args) {
class Main{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Board board = new Board();
		board.setScanner(scanner);
		
		board.start();
	}
}

class Board{
	Scanner scanner;
	
	Article[] articles;
	
	int articlesLastIndex;
	
	Board(){
		
		articles = new Article[100];
		articlesLastIndex = -1;
	}
	
	int getArticlesCount() {
		return articlesLastIndex + 1;
	}
	
	
	public void start() {
		
		showHelp();
		
		while(true) {
			System.out.println("게시판 ) ");
			String command = scanner.next().trim();
			
			if ( command.equals("help")) {
				scanner.nextLine();
				showHelp();
			}
			
			else if ( command.equals("add")) {
				scanner.nextLine();
				doCommandAdd();
			}
			
			else if (command.equals("list")) {
				scanner.nextLine();
				doCommandList();
			}
			
			else if (command.equals("detail")) {
				int idTodetail = scanner.nextInt();
				scanner.nextLine();
				doCommanDetail(idTodetail);
			}
			
			
		
			else if (command.equals("modify")) {
				int id = scanner.nextInt();
				
				Article article = null;
				
				for ( int i = 0; i<=articlesLastIndex; i++) {
					Article a = articles[i];
					if ( a.id == id ) {
						article = a;
						break;
					}
				}
				
				if ( article == null ) {
					System.out.println("없네요.");
				} else {
					System.out.printf("제목 : ");
					String title = scanner.next().trim();
					System.out.printf("내용 : ");
					String body = scanner.next().trim();
					
					article.title = title;
					article.body = body;
					
				}
			}
			
			
			else if (command.equals("exit")){
				scanner.nextLine();
				doCommandExit();
				break;
			} else {
				System.out.println("일치하는 명령어가 없습니다.");
			}
			
			
		}
	}



	void doCommanDetail(int id) {
		
		System.out.println("== 게시물 상세 ==");
		
		
		Article article = getIdDetail(id);
		
		if ( article == null ) {
			System.out.println("해당 게시물은 존재하지 않습니다.");
			return;
		}
		
		System.out.printf("번호 : %d\n",article.id);
		System.out.printf("날짜 : %s\n",article.regDate);
		System.out.printf("제목 : %s\n",article.title);
		System.out.printf("내용 : %s\n",article.body);
		
		
	}

	 Article getIdDetail(int id) {
		for ( int i = 0; i<=articlesLastIndex; i++) {
			if ( articles[i].id == id ) {
				return articles[i];
			}
		}
		return null;
	}

	 void doCommandExit() {
		System.out.println("시스템 종료");
	}

	private void doCommandList() {
		
		System.out.println("== 게시물 추가 ==");
		
		
		int articlesCount = getArticlesCount();
		
		if ( articlesCount == 0 ) {
			System.out.println("게시물이 존재하지 않습니다.");
		}
		
		System.out.print("번호 | 날짜                  | 제목\n");
		
		for ( int i = 0; i<=articlesLastIndex ; i++) {
			System.out.printf("%d | %s      | %s\n",articles[i].id,articles[i].regDate,articles[i].title);
		}
		
	}

	private void doCommandAdd() {
		
		System.out.println("== 게시물 추가 ==");
		
		Article newArticle = new Article();
		
		int articlesNewIndex = articlesLastIndex + 1;
		
		int newId;
		
		Article lastArticle = getLastArticle();
		
		if ( lastArticle == null ) {
			newId = 1;
		} else {
			newId = lastArticle.id + 1;
		}
		
		
		newArticle.id = newId;
		System.out.print("제목 : ");
		newArticle.title = scanner.nextLine().trim();
		System.out.print("내용 : ");
		newArticle.body = scanner.nextLine().trim();
		newArticle.regDate = NowDateStr();
		System.out.printf("%d번 글이 생성되었습니다.\n",newArticle.id);
		
		articles[articlesNewIndex] = newArticle;
		
		articlesLastIndex++;
	}


	 Article getLastArticle() {
		if ( getArticlesCount() > 0 ) {
			return articles[articlesLastIndex];
		}
		return null;
	}

	private void showHelp() {
		System.out.println("== 명령어 리스트 ==");
		System.out.println("help : 명령어 리스트");
		System.out.println("list : 게시물 리스팅");
		System.out.println("add : 게시물 추가");
		System.out.println("exit : 종료");
		System.out.println("detail ${게시물 번호} : 게시물 상세보기 ");
	}


	String NowDateStr() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat Date = new SimpleDateFormat
				("yyy-mm-dd HH:mm:ss");
		String DateStr = Date.format(cal.getTime());	
		return DateStr;
	}
	
	
	void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
}

class Article{
	int id;
	String title;
	String body;
	String regDate;
}


		

	}

}
