package hong;
// https://school.programmers.co.kr/learn/courses/30/lessons/43165

// 문제 설명
// 주어진 숫자 배열 numbers의 각 숫자 앞에 + 또는 -를 붙여서 식을 만들었습니다.
// 예를 들어, numbers가 [1, 1, 1, 1, 1]이면 다음과 같이 만들 수 있습니다.
// -1+1-1+1-1 = -1
// +1-1+1-1+1 = 1
// 이렇게 만들어진 식의 계산 결과가 target이 되는 경우의 수를 구해야 합니다.

// 제한사항
// numbers의 길이는 2 이상 20 이하입니다.
// numbers의 각 원소는 1 이상 100 이하의 자연수입니다.
// target은 -1000 이상 1000 이하의 정수입니다.

// 입출력 예
// numbers	target	return
// [1, 1, 1, 1, 1]	3	5
// [4, 1, 2, 1]	4	2

class Solution {
    int answer = 0;

    public int solution(int[] numbers, int target) {
        answer = 0;
        tg(numbers, target, 0, 0);
        return answer;
    }

    public void tg(int[] numbers, int target, int depth, int sum) {
        if (depth == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }

        tg(numbers, target, depth + 1, sum + numbers[depth]);
        tg(numbers, target, depth + 1, sum - numbers[depth]);

    }
}
