import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        int coin[] = new int[N];
        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(bufferedReader.readLine());
        }

        int count = 0;

        // 큰 동전부터
        for (int i = N - 1; i >= 0; i--) {
            if (coin[i] <= K) {
                count += K / coin[i];
                K %= coin[i];
            }
        }

        System.out.println(count);
    }
}
