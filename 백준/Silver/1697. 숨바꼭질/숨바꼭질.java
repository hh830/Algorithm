import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        if (N == K) {
            System.out.println(0);
            return;
        }

        boolean[] visited = new boolean[100001];
        visited[N] = true;

        queue.add(N);
        int size = queue.size();
        int count=0;

        while (true) {
            size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                int x = queue.remove();
                visited[x] = true;
                if (x-1 == K || x+1 == K || x*2 == K) {
                    System.out.println(count);
                    return;
                }
                if (x-1 >= 0 && !visited[x-1]) {
                    visited[x-1] = true;
                    queue.add(x-1);
                }
                if (x+1 <= 100000 && !visited[x+1]) {
                    visited[x+1] = true;
                    queue.add(x+1);
                }
                if (x*2 <= 100000 && !visited[x*2]) {
                    visited[x*2] = true;
                    queue.add(x*2);
                }
            }
        }
    }


}
