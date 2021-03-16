package langJAVA;

import java.util.ArrayList;
import java.util.Scanner;

public class Bubble_Sort {
	public static void main(String[] args) {
		int mem = 0;
		int sum = 0;
		int top_score = 0;
		int top_score_stu_num = 0;
		double avg = 0.0;

		Scanner sc = new Scanner(System.in);

		System.out.print("학생 수를 입력해주세요 : ");
		mem = sc.nextInt();
		int[] scores = new int[mem];

		for (int i = 0; i < scores.length; i++) {
			System.out.print("학생의 점수를 입력해주세요(0~100) : ");
			scores[i] = sc.nextInt();
			sum += scores[i];
			if (scores[i] >= top_score) {
				top_score = scores[i];
				top_score_stu_num = i;
			}
		}

		avg = (double) sum / mem;

		System.out.println("\n최고점은 " + (top_score_stu_num + 1) + "번 학생 : " + top_score + "점 입니다. ");
		System.out.printf("학생들의 평균 점수는 %.2f점 입니다. \n", avg);

		// 버블정렬 오름차순
		int temp; // 자리 스위칭을 위한 값 임시저장 변수

		for (int i = 0; i < scores.length; i++) { // 회차
			for (int j = 1; j < scores.length - i; j++) { // 회차 내 인접한 숫자 비교
				// - i를 해주는 이유는 1회전이 끝나면 이미 마지막 인덱스에 가장 큰 수가 들어가있으므로
				// scores.length = 배열의 크기 = 가장 마지막 인덱스를 고려해 줄 필요가 없다.
				if (scores[j - 1] > scores[j]) { // j가 0부터 시작되면 out of bounds
					temp = scores[j - 1];
					scores[j - 1] = scores[j];
					scores[j] = temp;
				} // else (score[j-1]<scores[j]) 의 경우는 신경 써줄 필요가없다
					// 0번 인덱스보다 1번 인덱스가 클 경우 그대로 두면 되기때문
			}
		}

		// 출력은 내림차순으로 했습니다.
		System.out.println("\nRank");
		for (int i = 0; i < scores.length; i++) {
			System.out.println((scores.length - i) + "등 : " + scores[i] + "점");
		}
	}
}
