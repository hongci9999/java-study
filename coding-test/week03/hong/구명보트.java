import java.util.Arrays;

/*
 * [Lv2] 구명보트 (42885)
 *
 * 문제: https://school.programmers.co.kr/learn/courses/30/lessons/42885
 *
 * 무인도에 갇힌 사람들을 구출하려고 합니다.
 * 구명보트는 최대 2명씩 탈 수 있고, 무게 제한이 있습니다.
 * 가장 적은 수의 보트로 모든 사람을 구출하기 위해 필요한 보트 개수를 구하세요.
 *
 * 제한사항:
 * - 사람의 수는 1 이상 50,000 이하
 * - 각 사람의 무게는 40kg 이상 240kg 이하
 * - 보트의 무게 제한은 40kg 이상 240kg 이하
 * - 무게 제한은 보트의 무게는 제외하고 탑승자의 무게만 계산
 *
 * 입출력 예시:
 * - 입력: people = [70, 50, 80, 50], limit = 100
 *   출력: 3 (50 + 50 = 100, 70, 80)
 * - 입력: people = [10, 20, 30, 40, 50], limit = 100
 *   출력: 3 (10 + 50 = 60, 20 + 40 = 60, 30)
 */

public class 구명보트 {
    public int solution(int[] people, int limit) {
        int sorted[] = people.clone();
        Arrays.sort(sorted);

        int count = 0;
        boolean[] used = new boolean[sorted.length];

        for (int i = 0; i < sorted.length; i++) {
            if (used[i])
                continue;

            for (int j = sorted.length - 1; j > i; j--) {
                if (used[j])
                    continue;

                if (sorted[i] + sorted[j] <= limit) {
                    used[i] = true;
                    used[j] = true;
                    count++;
                    break;
                }
            }
        }

        for (boolean k : used) {
            if (!k)
                count++;
        }

        return count;
    }

    /*
     * ===== 모범 답안: 투 포인터 =====
     * 시간복잡도: O(n log n) (정렬), O(n) (투 포인터) → 총 O(n log n)
     * 공간복잡도: O(1) (추가 배열 불필요)
     *
     * public int solution(int[] people, int limit) {
     *     int[] sorted = people.clone();
     *     Arrays.sort(sorted);
     *
     *     int left = 0;
     *     int right = sorted.length - 1;
     *     int count = 0;
     *
     *     while (left <= right) {
     *         if (sorted[left] + sorted[right] <= limit) {
     *             left++;  // 가벼운 사람도 탑승
     *         }
     *         right--;  // 무거운 사람은 항상 탑승
     *         count++;
     *     }
     *
     *     return count;
     * }
     */
}
