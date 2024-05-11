import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        int n, point = 4, num = 0;
        StringBuilder stringBuilder = new StringBuilder();
        int dp[][] = new int[10001][4];
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for(int t = 0;t<T;t++){
            int count = 0;
            n = Integer.parseInt(bufferedReader.readLine());

            if(dp[n][1] == 0){
                for(int i=point;i<=n;i++){
                    for(int j=1;j<=3;j++){
                        num = i - j;
                        for(int k=1;k<=j;k++){
                            dp[i][j] += dp[num][k];
                        }
                    }
                }
                point = n+1;
            }

            for(int l=1;l<=3;l++){
                count += dp[n][l];
            }

            stringBuilder.append(count).append("\n");
        }

        System.out.println(stringBuilder);
    }
}
