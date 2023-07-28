import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    static int[][] graph;
    static int A, B, sum = 0;
    static boolean[] visited;


    public static void main(String args[]) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        A = Integer.parseInt(bufferedReader.readLine());
        B = Integer.parseInt(bufferedReader.readLine());

        graph = new int[A + 1][A + 1];

        for (int i = 0; i < B; i++) {
            String str = bufferedReader.readLine();
            int k = Integer.parseInt(str.split(" ")[0]);
            int l = Integer.parseInt(str.split(" ")[1]);
            graph[k][l] = graph[l][k]=1; //연결 표시 graph[0][1]=1 이런식
        }

        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[A + 1];
        queue.add(1);
        visited[1] = true;
        int node;
        while (!queue.isEmpty()) {
            node = queue.poll();
            for (int i = 1; i < A + 1; i++) {
                if (graph[node][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    //queue.poll();
                    sum++;

                }

            }
        }

        System.out.println(sum);
    }
}