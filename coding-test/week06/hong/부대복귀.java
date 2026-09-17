package hong;

/*
 * [Lv3] 부대복귀 (132266)
 *
 * 문제: https://school.programmers.co.kr/learn/courses/30/lessons/132266
 *
 * 강철부대의 각 부대원이 여러 지역에 흩어져 있습니다. 지역은 1부터 n까지 번호가 매겨져 있고,
 * 서로 다른 두 지역을 왕복할 수 있는 길이 여러 개 있습니다. 각 길을 지나는 데는 1시간이 걸립니다.
 * 부대원들이 있는 지역 sources와 복귀해야 하는 지역 destination이 주어질 때,
 * 각 부대원이 복귀하는 데 걸리는 최소 시간을 sources 순서대로 배열에 담아 리턴하세요.
 * 복귀할 수 없는 경우 -1을 담습니다.
 *
 * 제한사항:
 * - 3 <= n <= 100,000
 * - 2 <= roads의 길이 <= 500,000
 * - roads의 각 원소는 [a, b] 형태이며 a와 b를 왕복할 수 있는 길을 의미
 * - 동일한 정보가 중복되어 주어지지 않는다
 * - 1 <= sources의 길이 <= 500
 * - 1 <= destination <= n
 *
 * 입출력 예시:
 * - 입력: n = 3, roads = [[1,2],[2,3]], sources = [2,3], destination = 1
 *   출력: [1, 2]
 * - 입력: n = 5, roads = [[1,2],[1,4],[2,4],[2,5],[4,5]], sources = [1,3,5], destination = 5
 *   출력: [2, -1, 0]
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;

public class 부대복귀 {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        return new int[0];
    }
}
