package hong;

/*
 * [Lv2] 피보나치 수 (12945)
 *
 * 문제: https://school.programmers.co.kr/learn/courses/30/lessons/12945
 *
 * 피보나치 수는 F(0) = 0, F(1) = 1이고, 2 이상의 n에 대하여
 * F(n) = F(n-1) + F(n-2) 가 적용되는 수입니다.
 * 2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567로 나눈 나머지를 리턴하세요.
 *
 * 제한사항:
 * - n은 2 이상 100,000 이하인 자연수
 *
 * 입출력 예시:
 * - 입력: n = 3
 *   출력: 2
 * - 입력: n = 5
 *   출력: 5
 */

public class 피보나치수 {
    public int solution(int n) {
        int[] pib = new int[n + 1];
        pib[0] = 0;
        pib[1] = 1;

        for (int i = 2; i <= n; i++) {
            pib[i] = (pib[i - 1] + pib[i - 2]) % 1234567;
        }
        int answer = pib[n];
        return answer;
    }
}
