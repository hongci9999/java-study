package hong;

/*
 * [Lv3] 모두 0으로 만들기 (76503)
 *
 * 문제: https://school.programmers.co.kr/learn/courses/30/lessons/76503
 *
 * 각 점에 가중치가 부여된 트리가 주어집니다. 다음 연산을 통해 모든 점의 가중치를
 * 0으로 만들려고 합니다.
 * - 임의의 연결된 두 점을 골라서 한 점은 가중치를 1 늘리고, 다른 한 점은 1 줄인다.
 * 모든 점의 가중치를 0으로 만들기 위한 최소 연산 횟수를 리턴하고,
 * 불가능하면 -1을 리턴하세요.
 *
 * 제한사항:
 * - a의 길이는 2 이상 300,000 이하
 * - a의 모든 수는 -1,000,000 이상 1,000,000 이하
 * - edges의 길이는 (a의 길이 - 1)
 * - edges의 각 원소는 [u, v] 형태이며 u번 점과 v번 점이 연결되어 있음
 * - 그래프는 항상 트리 형태로 주어진다
 *
 * 입출력 예시:
 * - 입력: a = [-5,0,2,1,2], edges = [[0,1],[3,4],[2,3],[0,3]]
 *   출력: 9
 * - 입력: a = [0,1,0], edges = [[0,1],[1,2]]
 *   출력: -1
 */

import java.util.*;

public class 모두0으로만들기 {
    public long solution(int[] a, int[][] edges) {
        long sum = 0;
        for (int n : a) {
            sum += n;
        }
        if (sum != 0)
            return -1;

        int n = a.length;
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        int[] parent = new int[n];
        int[] order = new int[n];
        int idx = 0;

        boolean[] visited = new boolean[n];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            order[idx++] = node;
            for (int next : adj[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    parent[next] = node;
                    queue.add(next);
                }
            }
        }

        long[] w = new long[n];
        for (int i = 0; i < n; i++) {
            w[i] = a[i];
        }
        long answer = 0;
        for (int i = n - 1; i > 0; i--) {
            int x = order[i];
            answer += Math.abs(w[x]);
            w[parent[x]] += w[x];
        }
        return answer;
    }

}
