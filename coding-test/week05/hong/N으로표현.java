package hong;

/*
 * [Lv3] N으로 표현 (42895)
 *
 * 문제: https://school.programmers.co.kr/learn/courses/30/lessons/42895
 *
 * 아래와 같이 5와 사칙연산만으로 12를 표현할 수 있습니다.
 * 12 = 5 + 5 + (5 / 5) + (5 / 5)
 * 12 = 55 / 5 + 5 / 5
 * 12 = (55 + 5) / 5
 * 5를 사용한 횟수는 각각 6, 5, 4입니다. 그리고 이중 가장 작은 경우는 4입니다.
 * 이처럼 숫자 N과 number가 주어질 때, N과 사칙연산만 사용해서 표현할 수 있는 방법 중
 * N 사용횟수의 최솟값을 리턴하세요.
 *
 * 제한사항:
 * - N은 1 이상 9 이하
 * - number는 1 이상 32,000 이하
 * - 수식에는 괄호와 사칙연산만 가능하며 나누기 연산에서 나머지는 무시한다
 * - 최솟값이 8보다 크면 -1을 리턴한다
 *
 * 입출력 예시:
 * - 입력: N = 5, number = 12
 *   출력: 4
 * - 입력: N = 2, number = 11
 *   출력: 3
 */
public class N으로표현 {
    public int solution(int N, int number) {
        int[] num = new int[32001];
        num[N] = 1;
        for (int i = 1; i <= number; i++) {

        }
        return 0;
    }
}
