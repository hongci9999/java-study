package hong;

/*
 * [Lv2] 하노이의 탑 (12946)
 *
 * 문제: https://school.programmers.co.kr/learn/courses/30/lessons/12946
 *
 * 3개의 기둥과 크기가 다른 n개의 원판이 있습니다.
 * 1번 기둥에 쌓인 n개의 원판을 3번 기둥으로 최소 횟수로 옮기는 과정을 리턴하세요.
 *
 * 규칙:
 * - 한 번에 한 개의 원판만 옮길 수 있다
 * - 큰 원판이 작은 원판 위에 있어서는 안 된다
 *
 * 제한사항:
 * - n은 15 이하의 자연수
 *
 * 입출력 예시:
 * - 입력: n = 2
 *   출력: [[1,2],[1,3],[2,3]]
 */

public class 하노이의탑 {
    public int[][] solution(int n) {
        return top(1, 3, 2, n);
    }

    public int[][] top(int start, int end, int middle, int n) {
        if (n == 1) {
            return new int[][] { { start, end } };
        }

        int[][] step1 = top(start, middle, end, n - 1);
        int[][] step2 = new int[][] { { start, end } };
        int[][] step3 = top(middle, end, start, n - 1);

        int[][] result = new int[step1.length + step2.length + step3.length][2];
        System.arraycopy(step1, 0, result, 0, step1.length);
        System.arraycopy(step2, 0, result, step1.length, step2.length);
        System.arraycopy(step3, 0, result, step1.length + step2.length, step3.length);

        return result;
    }
}
