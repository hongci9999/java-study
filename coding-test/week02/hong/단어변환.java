package hong;
// https://school.programmers.co.kr/learn/courses/30/lessons/43163

// 문제 설명
// 두 개의 단어 begin, target과 단어의 집합 words가 있습니다.
// 다음 과정을 통해 begin에서 target으로 변환할 수 있습니다.
// 1. 한 번에 한 글자씩만 바꿀 수 있습니다.
// 2. words에 있는 단어로만 변환할 수 있습니다.
// 예를 들어, begin = "hit", target = "cog", words = ["hot","dot","dog","lot","log","cog"]라면
// "hit" -> "hot" -> "dot" -> "dog" -> "cog"와 같이 4단계를 거쳐 변환할 수 있습니다.

// 두 단어의 변환 과정에서 필요한 단계의 최솟값을 구하세요.

// 제한사항
// 각 단어는 소문자로만 이루어져 있습니다.
// 각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다.
// words에는 3개 이상 50개 이하의 단어가 있습니다.
// begin에서 target으로 변환 가능한 경우만 입력됩니다.

// 입출력 예
// begin	target	words	return
// "hit"	"cog"	["hot","dot","dog","lot","log","cog"]	4
// "hit"	"hot"	["hot","dot","dog","lot","log","cog"]	1

class Solution {
    int answer = 10000;

    public int solution(String begin, String target, String[] words) {

        for (int i = 0; i < words.length; i++) {
            boolean[] visited = new boolean[words.length];
            if (isConnected(begin, words[i])) {
                transform(begin, target, words, visited, i, 1);
            }
        }

        return answer == 10000 ? 0 : answer;
    }

    public void transform(String begin, String target, String[] words, boolean[] visited, int i, int depth) {
        visited[i] = true;
        if (words[i].equals(target)) {
            if (depth < answer) {
                answer = depth;
            }
        } else {
            for (int j = 0; j < words.length; j++) {
                if (visited[j] == false && isConnected(words[i], words[j])) {
                    transform(begin, target, words, visited, j, depth + 1);
                }
            }
        }
        visited[i] = false;
    }

    public boolean isConnected(String begin, String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (begin.charAt(i) == word.charAt(i)) {
                count++;
            }
        }
        return count == word.length() - 1;
    }
}

/*
// BFS 방식 (더 효율적)
class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<String> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        queue.offer(begin);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                String cur = queue.poll();
                if (cur.equals(target)) {
                    return depth;
                }
                for (int i = 0; i < words.length; i++) {
                    if (!visited[i] && isConnected(cur, words[i])) {
                        visited[i] = true;
                        queue.offer(words[i]);
                    }
                }
            }
            depth++;
        }
        return 0;
    }

    public boolean isConnected(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) count++;
        }
        return count == a.length() - 1;
    }
}
*/
