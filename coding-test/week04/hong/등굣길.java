package hong;

/*
 * [Lv3] 등굣길 (42898)
 *
 * 문제: https://school.programmers.co.kr/learn/courses/30/lessons/42898
 *
 * m x n 격자 지도의 왼쪽 위(1,1)에서 오른쪽 아래(m,n)까지 가는 최단경로의 개수를 구하세요.
 * 물에 잠긴 지역(puddles)은 지날 수 없으며, 오른쪽과 아래로만 이동할 수 있습니다.
 * 최단경로의 개수를 1,000,000,007로 나눈 나머지를 리턴하세요.
 *
 * 제한사항:
 * - 격자의 크기 m, n은 1 이상 100 이하인 자연수 (m과 n이 모두 1인 경우는 입력으로 주어지지 않음)
 * - 물에 잠긴 지역은 0개 이상 10개 이하
 * - 집과 학교가 물에 잠긴 경우는 입력으로 주어지지 않음s
 * - puddles는 [[열, 행], ...] 형태
 *
 * 입출력 예시:
 * - 입력: m = 4, n = 3, puddles = [[2,2]]
 *   출력: 4
 */
public class 등굣길 {
    public int solution(int m, int n, int[][] puddles) {
        int mat[][] = new int[n + 1][m + 1];
        int mat2[][] = new int[n + 1][m + 1];
        mat[1][1] = 1;

        // puddles는 [열, 행] 순서
        for (int[] i : puddles) {
            mat2[i[1]][i[0]] = 1;
        }

        for (int j = 1; j <= n; j++) {
            for (int k = 1; k <= m; k++) {
                if (mat2[j][k] == 1)
                    continue;
                if (j == 1 && k == 1)
                    continue;
                mat[j][k] = (mat[j - 1][k] + mat[j][k - 1]) % 1000000007;

            }
        }
        return mat[n][m];
    }
}
