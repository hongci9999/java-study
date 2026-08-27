import java.util.HashSet;
import java.util.Set;

/*
 * [Lv1] 체육복 (42862)
 *
 * 문제: https://school.programmers.co.kr/learn/courses/30/lessons/42862
 *
 * 점심시간에 도둑이 체육복을 훔쳐갔습니다.
 * 다행히 일부 학생들이 여벌의 체육복을 가지고 있었습니다.
 * 여벌 체육복이 있는 학생이 없는 학생에게 빌려줄 수 있습니다.
 * 자신의 체육복이 없거나 여벌이 없으면 다음 번호나 이전 번호 학생에게만 빌릴 수 있습니다.
 *
 * 전체 학생의 몇 명이 체육수업을 들을 수 있을까요?
 *
 * 제한사항:
 * - 전체 학생의 수는 2명 이상 30명 이하
 * - 체육복을 도난당한 학생의 번호는 중복되지 않으며, 1번부터 n번까지의 번호 중 일부입니다.
 * - 여벌의 체육복을 가져온 학생의 번호는 중복되지 않으며, 1번부터 n번까지의 번호 중 일부입니다.
 * - 여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
 *
 * 입출력 예시:
 * - 입력: n = 5, lost = [2, 4], reserve = [1, 3, 5]
 *   출력: 5 (1번이 2번에게, 3번이 4번에게 빌려줄 수 있음)
 * - 입력: n = 5, lost = [2, 4], reserve = [3]
 *   출력: 4 (3번이 2번에게 빌려줄 수 있음)
 */

public class Solution {
    int count = 0;
    int answer = 0;

    public int solution(int n, int[] lost, int[] reserve) {
        count = 0;
        answer = 0;
        boolean[] borrowed = new boolean[reserve.length];
        borrow(lost, reserve, borrowed, 0);
        return n - lost.length + answer;
    }

    public void borrow(int[] lost, int[] reserve, boolean[] borrowed, int i) {
        if (i == lost.length) {
            return;
        }
        for (int r : reserve) {
            int index = -1;
            for (int j = 0; j < reserve.length; j++) {
                if (reserve[j] == r) {
                    index = j;
                    break;
                }
            }
            if (lost[i] - 1 == r && borrowed[index] == false) {
                borrowed[index] = true;
                count++;
                if (count > answer)
                    answer = count;
                borrow(lost, reserve, borrowed, i + 1);
                borrowed[index] = false;
                count--;
            } else if (lost[i] + 1 == r && borrowed[index] == false) {
                borrowed[index] = true;
                count++;
                if (count > answer)
                    answer = count;
                borrow(lost, reserve, borrowed, i + 1);

                borrowed[index] = false;
                count--;
            }

        }

    }

    /*
     * [그리디 풀이]
     *
     * 전체 논리:
     * 1. lost/reserve에서 겹치는 학생 제거 (자신이 여벌도 있으면 그냥 수업 참여)
     * 2. 남은 lost를 왼쪽→오른쪽 순회
     * 3. 각 lost 학생마다 left(-1) 또는 right(+1)에서 빌려주기 시도
     * 4. 한 번 빌려준 학생은 제거해야 중복 대여 안 됨
     *
     * 왜 그리디가 최적?
     * - 왼쪽 학생부터 처리하면, 오른쪽 학생은 이미 처리된 학생을 못 빌려줌
     * - 따라서 각 lost 학생이 왼쪽(-1)에서 빌릴 수 없으면 오른쪽(+1)에서 빌려야 함
     * - 이렇게 하면 자동으로 가장 많은 학생이 참여 가능
     *
     * 시간복잡도: O(n log n) [정렬] vs 백트래킹 O(n!)
     */
    public int solutionGreedy(int n, int[] lost, int[] reserve) {
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();

        for (int l : lost) lostSet.add(l);
        for (int r : reserve) reserveSet.add(r);

        // 겹치는 학생 제거 (둘 다에 포함)
        for (int l : lost) {
            if (reserveSet.contains(l)) {
                lostSet.remove(l);
                reserveSet.remove(l);
            }
        }

        // 정렬하여 왼쪽→오른쪽 순회
        int[] sortedLost = lostSet.stream().mapToInt(Integer::intValue).sorted().toArray();

        for (int l : sortedLost) {
            // 왼쪽 학생이 여벌이 있으면 우선 빌려줌
            if (reserveSet.contains(l - 1)) {
                reserveSet.remove(l - 1);
                lostSet.remove(l);
            }
            // 왼쪽에서 못 빌리면 오른쪽 학생에게서
            else if (reserveSet.contains(l + 1)) {
                reserveSet.remove(l + 1);
                lostSet.remove(l);
            }
            // 둘 다 불가능 → 그 학생은 수업 못 참여
        }

        return n - lostSet.size();
    }
}
