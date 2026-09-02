package hong;

import java.util.Arrays;

/*
 * [Lv2] 땅따먹기 (12913)
 *
 * 문제: https://school.programmers.co.kr/learn/courses/30/lessons/12913
 *
 * 각 행마다 4개의 칸 중 하나를 밟아 점수를 얻습니다.
 * 단, 바로 아래 행에서는 같은 열의 칸을 밟을 수 없습니다.
 * 마지막 행까지 내려왔을 때 얻을 수 있는 최고 점수를 리턴하세요.
 *
 * 제한사항:
 * - 행의 개수 N: 100,000 이하의 자연수
 * - 열의 개수는 4로 고정
 * - 칸에 적힌 점수는 100 이하의 자연수
 *
 * 입출력 예시:
 * - 입력: land = [[1,2,3,5],[5,6,7,8],[4,3,2,1]]
 *   출력: 16 (5 + 7 + 4)
 */
import java.util.Arrays;

public class 땅따먹기 {
    public int solution(int[][] land) {
        int leng = land.length;
        int[][] big = new int[leng][4];

        big[0] = land[0];
        for (int i = 1; i < leng; i++) {
            for (int j = 0; j < 4; j++) {
                int max = 0;
                for (int k = 0; k < 4; k++) {

                    if (j != k) {
                        int a = big[i - 1][k] + land[i][j];
                        if (a > max) {
                            big[i][j] = a;
                            max = a;

                        }
                    }
                }
            }
        }
        int answer = Arrays.stream(big[leng - 1]).max().getAsInt();

        return answer;
    }

}
