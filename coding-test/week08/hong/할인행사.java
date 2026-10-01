package hong;

/*
 * [Lv2] 할인 행사 (131127)
 *
 * 문제: https://school.programmers.co.kr/learn/courses/30/lessons/131127
 *
 * XYZ 마트는 회원들에게 조건에 맞는 로직에 따라 할인 행사를 합니다.
 * 10일 연속으로 매일 한 가지 제품을 할인하며, 원하는 제품과 수량이 모두 충족되는
 * 회원만 할인받을 수 있습니다.
 * 회원이 원하는 제품 want와 수량 number, 할인 품목 목록 discount가 주어질 때,
 * 회원이 열흘 연속으로 원하는 제품을 모두 할인받을 수 있는 시작 날짜의 총 일수를 리턴하세요.
 * 없으면 0을 리턴합니다.
 *
 * 제한사항:
 * - 1 <= want의 길이 = number의 길이 <= 10
 * - 1 <= number의 원소 <= 10
 * - number 원소의 합은 10
 * - 10 <= discount의 길이 <= 100,000
 * - want와 discount의 원소들은 알파벳 소문자로 이루어진 문자열
 * - 1 <= want의 원소의 길이, discount의 원소의 길이 <= 12
 *
 * 입출력 예시:
 * - 입력: want = ["banana","apple","rice","pork","pot"], number = [3,2,2,2,1],
 *         discount = ["chicken","apple","apple","banana","rice","apple","pork","banana",
 *                     "pork","rice","pot","banana","apple","banana"]
 *   출력: 3
 * - 입력: want = ["apple"], number = [10],
 *         discount = ["banana","banana","banana","banana","banana","banana","banana",
 *                     "banana","banana","banana"]
 *   출력: 0
 */
public class 할인행사 {
    public int solution(String[] want, int[] number, String[] discount) {
        // TODO: 구현
        return 0;
    }
}
