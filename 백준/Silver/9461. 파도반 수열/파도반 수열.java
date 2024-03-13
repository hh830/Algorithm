import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        int T = Integer.parseInt(bufferedReader.readLine());

        long dp[] = new long[100];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;

        for(int i=3;i<dp.length;i++){
            dp[i] = dp[i-2] + dp[i-3];
        }
        int input;
        for(int i=0;i<T;i++){
            input = Integer.parseInt(bufferedReader.readLine());

            stringBuilder.append(dp[input - 1]).append("\n");
        }
        System.out.println(stringBuilder);
    }
}