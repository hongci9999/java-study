
/*
 * [Lv1] 예산 (42839)
 *
 * 문제: https://school.programmers.co.kr/learn/courses/30/lessons/12982
 *
 * S사에서는 각 부서에 필요한 물품 구매 예산을 편성하려고 합니다.
 * 정해진 예산 범위 내에서 최대한 많은 부서가 물품을 구매할 수 있도록 예산을 배분해야 합니다.
 *
 * 제한사항:
 * - 부서의 개수는 1 이상 100 이하
 * - 각 부서가 신청한 금액은 1 이상 100,000 이하
 * - 전체 예산은 1 이상 10,000,000 이하
 *
 * 입출력 예시:
 * - 입력: d = [1,3,2,6], budget = 10
 *   출력: 3 (1,3,2를 모두 합산하면 6이므로 3개 부서가 물품을 구매)
 * - 입력: d = [2,2,3,3], budget = 10
 *   출력: 4 (모두 구매 가능)
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 예산 {
    public int solution(int[] d, int budget) {
        int sum = 0;
        ArrayList<Integer> copy = new ArrayList<>();
        for (int i : d) {
            copy.add(i);
        }

        copy.sort(Collections.reverseOrder());

        for (int i : copy) {
            sum += i;

        }

        while (sum > budget) {
            copy.remove(0);
            sum = 0;
            for (int i : copy) {
                sum += i;
            }
        }

        return copy.size();
    }

    // 모범답안
    public int solution2(int[] d, int budget) {
        Arrays.sort(d);
        int sum = 0;
        int count = 0;
        for (int cost : d) {
            if (sum + cost <= budget) {
                sum += cost;
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
