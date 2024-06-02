import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int N, M, r, c, d, count = 0;

    // 방향: 북, 동, 남, 서
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String str = bufferedReader.readLine();
        N = Integer.parseInt(str.split(" ")[0]);
        M = Integer.parseInt(str.split(" ")[1]);

        str = bufferedReader.readLine();
        r = Integer.parseInt(str.split(" ")[0]);
        c = Integer.parseInt(str.split(" ")[1]);
        d = Integer.parseInt(str.split(" ")[2]);

        int[][] arr = new int[N][M];
        int[][] visit = new int[N][M];

        for (int i = 0; i < N; i++) {
            str = bufferedReader.readLine();
            String[] tokens = str.split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(tokens[j]);
            }
        }

        while (true) {
            // 현재 칸이 청소되지 않은 경우, 청소한다.
            if (arr[r][c] == 0 && visit[r][c] == 0) {
                visit[r][c] = 1;
                count++;
            }

            boolean cleaned = false;
            // 주변 4칸을 탐색
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4; // 반시계 방향으로 회전
                int nx = r + dx[d];
                int ny = c + dy[d];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] == 0 && visit[nx][ny] == 0) {
                    // 청소되지 않은 빈 칸이 있는 경우, 전진
                    r = nx;
                    c = ny;
                    cleaned = true;
                    break;
                }
            }

            if (!cleaned) {
                // 주변 4칸이 모두 청소되었거나 벽인 경우, 후진
                int backDir = (d + 2) % 4;
                int bx = r + dx[backDir];
                int by = c + dy[backDir];

                if (bx < 0 || by < 0 || bx >= N || by >= M || arr[bx][by] == 1) {
                    // 후진할 수 없는 경우, 작동을 멈춘다.
                    break;
                }
                r = bx;
                c = by;
            }
        }

        System.out.println(count);
    }
}
