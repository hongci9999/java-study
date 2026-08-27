
/*
 * 문제: 입국심사
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/43238
 * 난이도: Lv3 (도전)
 *
 * 문제 설명:
 * n명의 사람이 입국심사를 기다리고 있습니다.
 * 각 심사관이 한 명을 심사하는 데 걸리는 시간이 times 배열로 주어집니다.
 * 모든 사람이 입국심사를 받을 때까지의 최소 시간을 구하세요.
 *
 * 제한사항:
 * - 1 ≤ n ≤ 1,000,000,000
 * - 1 ≤ times.length ≤ 100,000
 * - 1 ≤ times[i] ≤ 1,000,000,000
 *
 * 입출력 예시:
 * n = 6, times = [7, 10]
 * 출력: 28
 *
 * 설명:
 * - 가장 첫 두 사람은 바로 심사를 받으러 갑니다.

7분이 되었을 때, 첫 번째 심사대가 비고 3번째 사람이 심사를 받습니다.

10분이 되었을 때, 두 번째 심사대가 비고 4번째 사람이 심사를 받습니다.

14분이 되었을 때, 첫 번째 심사대가 비고 5번째 사람이 심사를 받습니다.

20분이 되었을 때, 두 번째 심사대가 비지만 6번째 사람이 그곳에서 심사를 받지 않고 1분을 더 기다린 후에 첫 번째 심사대에서 심사를 받으면 28분에 모든 사람의 심사가 끝납니다.
 */
import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long[] line = new long[times.length];
        for (int i = 0; i < n; i++) {
            long min = Long.MAX_VALUE;
            int index = -1;
            for (int j = 0; j < times.length; j++) {

                if (line[j] + times[j] < min) {
                    min = line[j] + times[j];
                    index = j;
                }
            }
            line[index] = min;
        }
        return Arrays.stream(line).max().orElse(0);
    }
}

/*
 * 모범답안: 이분 탐색 (파라메트릭 서치)
 *
 * 아이디어:
 * "T분 안에 n명을 심사할 수 있는가?" 를 판별하는 문제로 바꾼다.
 * T분 동안 심사관 한 명이 처리하는 인원 = T / times[i]
 * 전체 처리 인원 = sum(T / times[i])
 * 이 값이 n 이상이면 T분으로 충분 -> 더 짧은 시간 탐색
 * n 미만이면 T분으로 부족 -> 더 긴 시간 탐색
 *
 * 탐색 범위:
 * left  = 1
 * right = 가장 빠른 심사관이 혼자 n명을 처리하는 시간 = min(times) * n
 *
 * 시간복잡도: O(times.length * log(min(times) * n))
 */
class Solution2 {
    public long solution(int n, int[] times) {
        long left = 1;
        long right = (long) Arrays.stream(times).min().orElse(1) * n;

        while (left < right) {
            long mid = left + (right - left) / 2;

            if (canFinish(mid, times, n)) {
                right = mid;      // mid로 가능 -> 더 줄여본다
            } else {
                left = mid + 1;   // mid로 불가능 -> 더 늘린다
            }
        }
        return left;
    }

    // time분 동안 n명 이상 심사 가능한지
    private boolean canFinish(long time, int[] times, int n) {
        long count = 0;
        for (int t : times) {
            count += time / t;
            if (count >= n) return true;  // 오버플로우 방지 겸 조기 종료
        }
        return false;
    }
}
