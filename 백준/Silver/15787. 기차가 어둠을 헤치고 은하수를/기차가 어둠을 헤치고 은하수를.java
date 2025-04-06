import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 기차 수
        int m = Integer.parseInt(st.nextToken()); // 명령 수
        int[] train = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            if (cmd == 1) {
                int x = Integer.parseInt(st.nextToken());
                train[t] |= (1 << (x - 1));
            } else if (cmd == 2) {
                int x = Integer.parseInt(st.nextToken());
                train[t] &= ~(1 << (x - 1));
            } else if (cmd == 3) {
                train[t] <<= 1;
                train[t] &= (1 << 20) - 1;
            } else if (cmd == 4) {
                train[t] >>= 1;
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(train[i]);
        }

        System.out.println(set.size());
    }
}
