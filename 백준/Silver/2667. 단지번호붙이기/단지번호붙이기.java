import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1}; // 상하좌우
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        // 지도 정보 입력
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0'; // char to int 변환
            }
        }

        ArrayList<Integer> complexSizes = new ArrayList<>();

        // 모든 칸에 대해 DFS 수행
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    int complexSize = dfs(i, j);
                    complexSizes.add(complexSize);
                }
            }
        }

        // 단지 수 출력
        System.out.println(complexSizes.size());

        // 단지 내 집의 수를 오름차순으로 정렬하여 출력
        Collections.sort(complexSizes);
        for (int size : complexSizes) {
            System.out.println(size);
        }
    }

    // DFS로 단지의 크기를 계산하는 함수
    static int dfs(int x, int y) {
        visited[x][y] = true;
        int complexSize = 1;

        // 상하좌우에 대해 탐색
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 범위 체크 및 방문하지 않은 집이면 재귀 호출
            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    complexSize += dfs(nx, ny);
                }
            }
        }

        return complexSize;
    }
}
