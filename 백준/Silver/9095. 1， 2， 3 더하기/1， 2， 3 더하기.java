import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        int n;
        StringBuilder stringBuilder = new StringBuilder();
        int dp[] = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=0;i<T;i++){
            n = Integer.parseInt(bufferedReader.readLine());

            for(int j=4;j<=n;j++){
                if(dp[j] == 0)
                {
                    dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
                }
            }

            stringBuilder.append(dp[n]).append("\n");
        }

        System.out.println(stringBuilder);
    }
}