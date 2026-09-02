package hong;

/*
 * [Lv2] 멀리 뛰기 (12914)
 *
 * 문제: https://school.programmers.co.kr/learn/courses/30/lessons/12914
 *
 * 효진이는 한 번에 1칸, 또는 2칸을 뛸 수 있습니다.
 * 칸이 총 4개일 때 (1,1,1,1), (1,2,1), (1,1,2), (2,1,1), (2,2) 총 5가지 방법으로 끝에 도달합니다.
 * 멀리뛰기에 사용될 칸의 수 n이 주어질 때 끝에 도달하는 방법의 수를
 * 1234567로 나눈 나머지를 리턴하세요.
 *
 * 제한사항:
 * - n은 1 이상 2,000 이하인 정수
 *
 * 입출력 예시:
 * - 입력: n = 4
 *   출력: 5
 * - 입력: n = 3
 *   출력: 3
 */

public class 멀리뛰기 {
    public long solution(int n) {
        int temp[] = new int[n + 1];
        temp[1] = 1;
        temp[0] = 1;
        for (int i = 2; i <= n; i++) {
            temp[i] = (temp[i - 1] + temp[i - 2]) % 1234567;
        }

        return temp[n];
    }
}
