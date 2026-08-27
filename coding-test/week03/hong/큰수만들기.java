/*
 * [Lv2] 큰 수 만들기 (42883)
 *
 * 문제: https://school.programmers.co.kr/learn/courses/30/lessons/42883
 *
 * 어떤 숫자에서 k개의 숫자를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하는 문제입니다.
 * 예를 들어, 숫자 1924에서 2개를 제거하면 94(1,2 제거)가 됩니다.
 *
 * 제한사항:
 * - number는 1 이상 1,000,000 이하인 숫자를 문자열로 표현
 * - k는 1 이상 number의 길이 미만
 *
 * 입출력 예시:
 * - 입력: number = "1924", k = 2
 *   출력: "94" (1,2를 제거하면 94)
 * - 입력: number = "4177252841", k = 4
 *   출력: "775841" (4,1,2,2를 제거)
 */

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayDeque;
import java.util.Deque;

public class 큰수만들기 {
    public String solution(String number, int k) {
        // char[] numbers = number.toCharArray();
        List<Integer> stack = new ArrayList<>();
        for (char c : number.toCharArray()) {
            stack.add(c - '0');
        }

        int index = 0;
        List<Integer> result = remove(stack, index, k);
        StringBuilder answer = new StringBuilder();

        for (int num : result) {
            answer.append(num);
        }

        return answer.toString();
    }

    public List<Integer> remove(List<Integer> stack, int index, int k) {
        while (k > 0) {

            if (stack.size() - index == k) {
                for (int i = 0; i < k; i++) {
                    stack.remove(stack.size() - 1);
                }
                break;
            }

            int max = 0;
            for (int i = index; i <= index + k; i++) {

                if (stack.get(i) > max) {
                    max = stack.get(i);
                }
            }
            for (int j = index; stack.get(j) != max; j++) {
                if (stack.get(j) < max) {
                    stack.remove(j);
                    j--;
                    k--;
                }

            }

            index++;

        }

        return stack;
    }

    // 정석 풀이: Greedy + Stack
    public String solutionOptimal(String number, int k) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : number.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() < c && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        return result.toString();
    }
}

//
