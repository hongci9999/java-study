package hong;

/*
 * [Lv4] 도둑질 (42897)
 *
 * 문제: https://school.programmers.co.kr/learn/courses/30/lessons/42897
 *
 * 도둑이 어느 마을을 털 계획을 하고 있습니다. 이 마을의 모든 집들은 아래 그림과 같이
 * 동그랗게 배치되어 있습니다. 인접한 두 집을 털면 경보가 울립니다.
 * 각 집에 있는 돈이 담긴 배열 money가 주어질 때, 도둑이 훔칠 수 있는 돈의 최댓값을 리턴하세요.
 *
 * 제한사항:
 * - 이 마을에 있는 집은 3개 이상 1,000,000개 이하
 * - money 배열의 각 원소는 0 이상 1,000 이하인 정수
 * - 첫 번째 집과 마지막 집은 인접해 있다
 *
 * 입출력 예시:
 * - 입력: money = [1, 2, 3, 1]
 *   출력: 4
 */
// 10 
// 100 

import java.util.Arrays;

public class 도둑질 {
    public int solution(int[] money) {
        int[] dp = new int[money.length];
        dp[0] = money[0];
        dp[1] = money[1];
        dp[2] = money[2];
        int max = Arrays.stream(money).max().getAsInt();

        if (money.length == 4) {
            dp[3] = money[1] + money[3];
            max = Math.max(money[1] + money[3], money[0] + money[2]);
        }
        if (money.length > 4) {
            dp[2] = money[0] + money[2];
            for (int i = 3; i < money.length; ++i) {
                dp[i] = Math.max(dp[i - 2] + money[i], dp[i - 3] + money[i]);
            }
            max = Math.max(dp[money.length - 2], dp[money.length - 1]);
        }

        return max;
    }
}
