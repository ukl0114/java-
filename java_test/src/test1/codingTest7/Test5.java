package test1.codingTest7;

import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("학생 수를 입력하세요. : ");

		// 1. 학생 이름, 국어 점수, 영어 점수, 수학 점수
		// 총점, 평균, 학점, 순위 배열이 필요하다.
		String[] name = new String[scanner.nextInt()];
		System.out.println("**********************");
		int[] kor = new int[name.length];
		int[] eng = new int[name.length];
		int[] mat = new int[name.length];
		int[] tot = new int[name.length];
		double[] avg = new double[name.length];
		int[] rank = new int[name.length];

		// 2. 학생 수만큼 이름, 국어점수, 영어점수, 수학점수를
		// 키보드로 입력을 받아서 각각의 배열에 저장을 해 주자.
		for (int i = 0; i < name.length; i++) {

			//// 이름과 각 과목의 점수 배열에 저장 ////
			System.out.print("학생 이름 입력 : ");
			name[i] = scanner.next();
			System.out.print("국어 점수 입력 : ");
			kor[i] = scanner.nextInt();
			System.out.print("영어 점수 입력 : ");
			eng[i] = scanner.nextInt();
			System.out.print("수학 점수 입력 : ");
			mat[i] = scanner.nextInt();

			System.out.println("**********************");

			//// 총점과 평균과 학점 구하기 ////
			tot[i] = kor[i] + eng[i] + mat[i];
			avg[i] = tot[i] / 3.0;
			rank[i] = 1;
		}

		for (int i = 0; i < rank.length; i++) {
			for (int j = 0; j < rank.length; j++) {
				if (tot[i] < tot[j]) { // 총점이 다음 사람보다 적으면 내 등수가 1++
					rank[i]++;
				}
			}
		}

		// 출력
		for (int i = 0; i < name.length; i++) {
			System.out.println("====================================================");
			System.out.print("이 름 : " + name[i] + " | ");
			System.out.print("총 점 : " + tot[i] + "점 | ");
			System.out.printf("평 균 : %.2f점 | ", avg[i]);
			System.out.print("석 차 : " + rank[i] + "등");
			System.out.println();
		}

	}

}
