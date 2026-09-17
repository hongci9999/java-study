package hong;

import java.util.Arrays;

/*
 * [Lv3] 거스름돈 (12907)
 *
 * 문제: https://school.programmers.co.kr/learn/courses/30/lessons/12907
 *
 * Finn은 편의점에서 야간 아르바이트를 하고 있습니다. 야간에 손님이 너무 없어 심심한 Finn은
 * 손님들께 거스름돈을 n원 드려야 할 때 방법의 경우의 수를 구하려 합니다.
 * 거스름돈에 사용할 수 있는 돈의 종류 money가 주어질 때, 손님에게 n원을 거슬러 줄 수 있는
 * 방법의 수를 1,000,000,007로 나눈 나머지를 리턴하세요.
 *
 * 제한사항:
 * - n은 100,000 이하의 자연수
 * - 화폐 단위 money는 100종류 이하이며, 각 화폐 단위는 100,000 이하의 자연수
 * - 화폐 단위는 중복되지 않으며, 같은 단위의 화폐는 무한하게 있다고 가정한다
 *
 * 입출력 예시:
 * - 입력: n = 5, money = [1, 2, 5]
 *   출력: 4
 *   (1원 5개 / 1원 3개 + 2원 1개 / 1원 1개 + 2원 2개 / 5원 1개)
 */
public class 거스름돈 {
    public int solution(int n, int[] money) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i : money) {
            dp[i] = 1;
        }
        for (int i = 1; i < n + 1; i++) {
            final int cur = i;

            boolean down = Arrays.stream(money).anyMatch(v -> v <= cur);

            if (down) {
                int[] smaller = Arrays.stream(money).filter(v -> v <= cur).toArray();
                int sum = 0;
                for (int j : smaller) {
                    sum = sum + dp[i - j];
                }
                dp[i] = (sum + dp[i]) % 1_000_000_007;
            } else {
                dp[i] = 0;
            }
        }
        return dp[n];
    }
}
