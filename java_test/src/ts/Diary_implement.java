package ts;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;



public class Diary_implement extends Log_implement implements Diary_interface{

	int articlesLastIndex;
	Article[] articles;
	boolean login_code = true;
	Scanner scanner;
	Diary_implement() {
		articles = new Article[100];
		articlesLastIndex = -1;
		members = new Member[100];
		membersLastIndex = -1;
	}
	
	String getNowDateStr() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat Date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = Date.format(cal.getTime());
		return dateStr;
	}
	
	Article getArticlesById(int id) {
		for (int i = 0; i <= articlesLastIndex; i++) {
			if (articles[i].id == id) {
				return articles[i];
			}
		}
		return null;
	}
	
	@Override
	public void doCommandList() {
		System.out.println("== 게시물 리스트 ==");

		if (articlesLastIndex >= 0) {
			System.out.println("번호  | 날짜                   | 제목          ");
			for (int i = 0; i <= articlesLastIndex; i++) {
				System.out.printf("%d    | %s    | %s              " + "\n", articles[i].id, articles[i].resDate,
						articles[i].title);
			}
		} else {
			System.out.println("게시물이 존재하지 않습니다.");
			return;
		}
	}

	@Override
	public void doCommandAdd() {
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

	

	@Override
	public void doCommandDetail(int id) {
		System.out.println("== 게시물 상세 ==");
		if (getArticlesById(id) != null) {
			System.out.printf("번호 :  %d", getArticlesById(id).id);
			System.out.printf("  날짜 :  %s\n", getArticlesById(id).resDate);
			System.out.printf("    제목    \n%s\n", getArticlesById(id).title);
			System.out.printf("    내용    \n%s\n", getArticlesById(id).body);

		} else {
			System.out.println("상세보기 할 게시물이 존재하지 않습니다.");
			return;
		}
	}

	@Override
	public void doCommandDelete(int id) {
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

	@Override
	public void doCommandModify(int id) {
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
	
}
