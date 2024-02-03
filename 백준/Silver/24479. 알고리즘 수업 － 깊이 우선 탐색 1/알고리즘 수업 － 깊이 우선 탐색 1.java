import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static List<Integer>[] graph;
    private static boolean[] visit;
    private static int[] order;
    private static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        graph = new List[N + 1];
        visit = new boolean[N + 1];
        order = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        dfs(R);

        for (int i = 1; i <= N; i++) {
            if (order[i] == 0) {
                System.out.println(0);
            } else {
                System.out.println(order[i]);
            }
        }
    }

    private static void dfs(int v) {
        visit[v] = true;
        order[v] = count++;
        for (int next : graph[v]) {
            if (!visit[next]) {
                dfs(next);
            }
        }
    }
}
