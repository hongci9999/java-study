package hong;

/*
 * [Lv3] 정수 삼각형 (43105)
 *
 * 문제: https://school.programmers.co.kr/learn/courses/30/lessons/43105
 *
 * 삼각형의 꼭대기에서 바닥까지 이어지는 경로 중, 거쳐간 숫자의 합이 가장 큰 경우의 합을 리턴하세요.
 * 아래 칸으로 이동할 때는 대각선 방향으로 왼쪽 또는 오른쪽으로만 이동 가능합니다.
 *
 * 제한사항:
 * - 삼각형의 높이는 1 이상 500 이하
 * - 삼각형을 이루고 있는 숫자는 0 이상 9,999 이하의 정수
 *
 * 입출력 예시:
 * - 입력: triangle = [[7],[3,8],[8,1,0],[2,7,4,4],[4,5,2,6,5]]
 *   출력: 30
 */
import java.util.Arrays;

public class 정수삼각형 {
    public int solution(int[][] triangle) {
        int length = triangle.length;
        int[][] big = new int[length][];

        for (int i = 0; i < length; i++) {
            big[i] = new int[i + 1];
        }

        big[0][0] = triangle[0][0];

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    big[i][j] = big[i - 1][j] + triangle[i][j];
                } else if (j == triangle[i].length - 1) {
                    big[i][j] = big[i - 1][j - 1] + triangle[i][j];
                } else {
                    big[i][j] = Math.max(big[i - 1][j] + triangle[i][j], big[i - 1][j - 1] + triangle[i][j]);
                }
            }
        }

        int max = Arrays.stream(big[length - 1]).max().getAsInt();
        return max;
    }
}
