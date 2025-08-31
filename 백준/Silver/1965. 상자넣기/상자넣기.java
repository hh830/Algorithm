import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        int box[] = new int[N];
        int dp[] = new int[N];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            box[i] = Integer.parseInt(stringTokenizer.nextToken());
            dp[i] = 1;
        }

        int maxLen = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (box[j] < box[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        System.out.println(maxLen);
    }
}