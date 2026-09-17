package hong;

import java.util.Stack;

/*
 * [Lv3] 가장 먼 노드 (49189)
 *
 * 문제: https://school.programmers.co.kr/learn/courses/30/lessons/49189
 *
 * n개의 노드가 있는 그래프가 있습니다. 각 노드는 1부터 n까지 번호가 적혀있습니다.
 * 1번 노드에서 가장 멀리 떨어진 노드의 개수를 구하려고 합니다.
 * 가장 멀리 떨어진 노드란 최단경로로 이동했을 때 간선의 개수가 가장 많은 노드를 의미합니다.
 * 노드의 개수 n과 간선 정보 vertex가 주어질 때, 1번 노드로부터 가장 멀리 떨어진 노드가
 * 몇 개인지 리턴하세요.
 *
 * 제한사항:
 * - 노드의 개수 n은 2 이상 20,000 이하
 * - 간선은 양방향이며 중복된 간선은 주어지지 않는다
 * - 그래프는 항상 연결되어 있다
 *
 * 입출력 예시:
 * - 입력: n = 6, vertex = [[3,6],[4,3],[3,2],[1,3],[1,2],[2,4],[5,2]]
 *   출력: 3
 *   (1번 노드에서 가장 멀리 떨어진 노드는 4, 5, 6번 노드)
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayDeque;

public class 가장먼노드 {
    public int solution(int n, int[][] vertex) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] v : vertex) {
            graph.get(v[0]).add(v[1]);
            graph.get(v[1]).add(v[0]);
        }

        boolean[] visited = new boolean[n + 1];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        visited[1] = true;
        int[] distance = new int[n + 1];
        int count = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    distance[next] = distance[cur] + 1;
                }
            }
        }

        int maxDistance = 0;
        for (int i = 1; i <= n; i++) {
            maxDistance = Math.max(maxDistance, distance[i]);
        }

        for (int i = 1; i <= n; i++) {
            if (distance[i] == maxDistance) {
                count++;
            }
        }

        return count;
    }

}
