import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[][] graph;
    private static int[][] result;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());

        graph = new int[N][N];
        result = new int[N][N];

        for (int i=0;i<N;i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j=0;j<N;j++) {
                graph[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        for (int i=0;i<N;i++) {
            visited = new boolean[N];
            dfs(i, i);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                stringBuilder.append(result[i][j]).append(" ");
            }
            stringBuilder.append("\n");
        }

        System.out.print(stringBuilder);
    }

    private static void dfs(int start, int now) {
        for (int next = 0; next < N; next++) {
            if (graph[now][next] == 1 && !visited[next]) {
                visited[next] = true;
                result[start][next] = 1;
                dfs(start, next);
            }
        }
    }
}
