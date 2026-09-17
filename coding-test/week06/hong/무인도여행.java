package hong;

/*
 * [Lv2] 무인도 여행 (154540)
 *
 * 문제: https://school.programmers.co.kr/learn/courses/30/lessons/154540
 *
 * 메리는 여름을 맞아 무인도로 여행을 가기 위해 지도를 보고 있습니다.
 * 지도에는 바다와 무인도가 표시되어 있고, 무인도에는 그 무인도에서 최대 며칠 동안
 * 머물 수 있는지 나타내는 숫자가 적혀 있습니다.
 * 지도 maps가 주어질 때, 각 섬에서 최대 며칠씩 머무를 수 있는지 배열에 오름차순으로 담아 리턴하세요.
 * 만약 지낼 수 있는 무인도가 없다면 -1을 담은 배열을 리턴합니다.
 *
 * 지도 기호:
 * - "X" : 바다
 * - "1" ~ "9" : 무인도의 식량 (머무를 수 있는 일수)
 * - 상하좌우로 연결된 숫자 칸들은 하나의 섬이다
 *
 * 제한사항:
 * - 3 <= maps 길이 <= 100
 * - 3 <= maps의 원소 길이 <= 100
 * - maps의 모든 원소 길이는 동일하다
 *
 * 입출력 예시:
 * - 입력: maps = ["X591X", "X1X5X", "X231X", "1XXX1"]
 *   출력: [1, 1, 27]
 * - 입력: maps = ["XXX", "XXX", "XXX"]
 *   출력: [-1]
 */

import java.util.Queue;
import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class 무인도여행 {
    public int[] solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        boolean visited[][] = new boolean[n][m];
        List<Integer> islandDays = new ArrayList<>();

        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && maps[i].charAt(j) != 'X') {
                    q.add(new int[] { i, j });
                    visited[i][j] = true;
                    int sum = maps[i].charAt(j) - '0';

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int x = cur[0];
                        int y = cur[1];
                        int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

                        for (int[] d : direction) {
                            int nextx = x + d[0];
                            int nexty = y + d[1];
                            if (nextx >= 0 && nextx < n && nexty >= 0 && nexty < m) {
                                if (maps[nextx].charAt(nexty) != 'X' && !visited[nextx][nexty]) {
                                    q.add(new int[] { nextx, nexty });
                                    visited[nextx][nexty] = true;
                                    sum += maps[nextx].charAt(nexty) - '0';
                                }
                            }
                        }

                    }
                    islandDays.add(sum);
                }
            }
        }
        if (islandDays.isEmpty()) {
            return new int[] { -1 };
        }
        int[] answer = new int[islandDays.size()];
        for (int i = 0; i < answer.length; i++)
            answer[i] = islandDays.get(i);
        Arrays.sort(answer);
        return answer;
    }
}
