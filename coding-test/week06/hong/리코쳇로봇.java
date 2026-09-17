package hong;

/*
 * [Lv2] 리코쳇 로봇 (169199)
 *
 * 문제: https://school.programmers.co.kr/learn/courses/30/lessons/169199
 *
 * 리코쳇 로봇은 시작 위치에서 출발해 미끄러지듯 이동합니다.
 * 로봇은 상하좌우 중 한 방향을 골라 장애물이나 보드 끝에 부딪힐 때까지 계속 미끄러집니다.
 * 보드의 상태 board가 주어질 때, 로봇이 목표 지점에 도달하기 위한 최소 이동 횟수를 리턴하세요.
 * 도달할 수 없으면 -1을 리턴합니다.
 *
 * 보드 기호:
 * - "." : 빈 칸
 * - "D" : 장애물
 * - "R" : 로봇의 시작 위치
 * - "G" : 목표 지점
 *
 * 제한사항:
 * - 3 <= board 길이 <= 100
 * - 3 <= board의 원소 길이 <= 100
 * - board의 모든 원소 길이는 동일하다
 * - "R"과 "G"는 각각 한 개씩만 존재한다
 *
 * 입출력 예시:
 * - 입력: board = ["...D..R", ".D.G...", "....D.D", "D....D.", "..D...."]
 *   출력: 7
 * - 입력: board = [".D.R", "....", ".G..", "...D"]
 *   출력: -1
 */

import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.ArrayDeque;

public class 리코쳇로봇 {
    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i].charAt(j) == 'R') {
                    q.add(new int[] { i, j, 0 });
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            int moves = current[2];

            if (board[x].charAt(y) == 'G') {
                return moves;
            }

            int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
            for (int[] dir : directions) {
                int nx = x;
                int ny = y;
                while (true) {
                    int nextX = nx + dir[0];
                    int nextY = ny + dir[1];
                    if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m || board[nextX].charAt(nextY) == 'D') {
                        break;
                    }
                    nx = nextX;
                    ny = nextY;
                }
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[] { nx, ny, moves + 1 });
                }
            }
        }

        return -1;
    }
}
