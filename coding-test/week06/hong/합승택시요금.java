package hong;

/*
 * [Lv3] 합승 택시 요금 (72413)
 *
 * 문제: https://school.programmers.co.kr/learn/courses/30/lessons/72413
 *
 * 밤늦게까지 야근을 하던 중 A와 B는 함께 택시를 타고 귀가하기로 했습니다.
 * 두 사람은 출발 지점 s에서 출발해 일정 지점까지 함께 이동한 뒤,
 * 각자의 목적지 a와 b로 따로 이동할 수 있습니다.
 * 지점 개수 n, 출발 지점 s, A의 도착 지점 a, B의 도착 지점 b, 지점 간 예상 택시 요금 fares가
 * 주어질 때, 두 사람이 지불하는 요금 합의 최솟값을 리턴하세요.
 *
 * 제한사항:
 * - 3 <= n <= 200
 * - 1 <= s, a, b <= n, 서로 다른 값
 * - 2 <= fares의 길이 <= 5,000
 * - fares의 각 원소는 [c, d, f] 형태이며 c와 d 사이의 예상 요금이 f
 * - 1 <= f <= 100,000, f는 100원 단위
 * - 요금은 양방향 동일하며 모든 지점은 서로 이동 가능하다
 *
 * 입출력 예시:
 * - 입력: n = 6, s = 4, a = 6, b = 2,
 *        fares = [[4,1,10],[3,5,24],[5,6,2],[3,1,41],[5,1,24],[4,6,50],[2,4,66],[2,3,22],[1,6,25]]
 *   출력: 82
 * - 입력: n = 7, s = 3, a = 4, b = 1,
 *        fares = [[5,7,9],[4,6,4],[3,6,1],[3,2,3],[2,1,6]]
 *   출력: 14
 * - 입력: n = 6, s = 4, a = 5, b = 6,
 *        fares = [[2,6,6],[6,3,7],[4,6,7],[6,5,11],[2,5,12],[5,3,20],[2,4,8],[4,3,9]]
 *   출력: 18
 */
public class 합승택시요금 {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                graph[i][j] = (i == j) ? 0 : 100_000_001;
            }
        }
        for (int[] fare : fares) {
            int c = fare[0];
            int d = fare[1];
            int f = fare[2];
            graph[c][d] = f;
            graph[d][c] = f;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int k = 1; k <= n; k++) {
            answer = Math.min(answer, graph[s][k] + graph[k][a] + graph[k][b]);
        }
        return answer;
    }
}
