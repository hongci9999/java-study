package hong;

/*
 * [Lv2] 전력망을 둘로 나누기 (86971)
 *
 * 문제: https://school.programmers.co.kr/learn/courses/30/lessons/86971
 *
 * n개의 송전탑이 전선을 통해 하나의 트리 형태로 연결되어 있습니다.
 * 전선 중 하나를 끊어서 송전탑을 두 개의 네트워크로 분할하려고 합니다.
 * 이때 두 네트워크에 속한 송전탑의 개수 차이를 최소가 되도록 분할하고,
 * 그 차이를 리턴하세요.
 *
 * 제한사항:
 * - n은 2 이상 100 이하인 자연수
 * - wires는 길이가 n-1인 정수형 2차원 배열
 * - wires의 각 원소는 [v1, v2] 형태이며 v1번 송전탑과 v2번 송전탑이 전선으로 연결되어 있음
 * - 1 <= v1 < v2 <= n
 * - 전력망 네트워크가 하나의 트리 형태가 아닌 경우는 입력으로 주어지지 않는다
 *
 * 입출력 예시:
 * - 입력: n = 9, wires = [[1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]]
 *   출력: 3
 * - 입력: n = 4, wires = [[1,2],[2,3],[3,4]]
 *   출력: 0
 * - 입력: n = 7, wires = [[1,2],[2,7],[3,7],[3,4],[4,5],[6,7]]
 *   출력: 1
 */
public class 전력망을둘로나누기 {
    private int parent[];

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < wires.length; i++) {
            parent = new int[n + 1];
            for (int j = 0; j <= n; j++) {
                parent[j] = j;
            }

            for (int j = 0; j < wires.length; j++) {
                if (i == j)
                    continue;
                union(wires[j][0], wires[j][1]);
            }

            int root1 = find(wires[i][0]);
            int cnt = 0;
            for (int v = 1; v <= n; v++) {
                if (find(v) == root1)
                    cnt++;
            }

            int cnt2 = n - cnt;
            answer = Math.min(answer, Math.abs(cnt - cnt2));
        }

        return answer;
    }

    private int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    private void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
        }
    }
}
