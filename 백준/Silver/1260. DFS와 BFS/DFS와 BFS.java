import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static Queue<Integer> queue = new LinkedList<Integer>();

    private static boolean bool[];
    private static boolean visited[];
    private static int N, M, V;
    private static int graph[][];
    private static String dfs_result = "";
    private static String bfs_result = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        N = Integer.parseInt(str.split(" ")[0]);
        M = Integer.parseInt(str.split(" ")[1]);
        V = Integer.parseInt(str.split(" ")[2]);

        graph = new int[N + 1][N + 1];
        bool = new boolean[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            String in = br.readLine();
            int a = Integer.parseInt(in.split(" ")[0]);
            int b = Integer.parseInt(in.split(" ")[1]);

            graph[a][b] = graph[b][a] = 1;
        }

        dfs(V);
        bfs(V);
        System.out.println(dfs_result);
        System.out.println(bfs_result);
    }

    private static void dfs(int node) {
        bool[node] = true;
        dfs_result += node + " ";

        for (int i = 1; i <= N; ++i) {
            if (!bool[i] && graph[node][i] != 0) {
                dfs(i);
            }
        }
    }

    private static void bfs(int node) {
        visited[node] = true;
        queue.add(node);

        while (!queue.isEmpty()) {
            node = queue.poll();
            bfs_result += node + " ";

            for (int i = 1; i <= N; i++) {
                if (!visited[i] && graph[node][i] != 0) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
