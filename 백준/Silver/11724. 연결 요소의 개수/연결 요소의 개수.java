import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static LinkedList<Integer>[] list;
    private static int N, M;
    private static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        list = new LinkedList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new LinkedList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(stringTokenizer.nextToken());
            int B = Integer.parseInt(stringTokenizer.nextToken());

            list[A].add(B);
            list[B].add(A);
        }
        int startNode = 0;

        int result = 0;

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && list[i] != null) {
                startNode = i;
                dfs(startNode);
                result++;
            }
        }

        System.out.println(result);
    }

    private static void dfs(int node) {
        visited[node] = true;

        for (int next : list[node]) {
            if (!visited[next]) {
                dfs(next);

            }
        }
    }
}
