import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer;

        int arr[][] = new int[n][n];
        int dp[][] = new int[n][n];

        for(int i=0;i<n;i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j=0;j<=i;j++){
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        dp[0][0] = arr[0][0];

        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                if(i>0 && j>0 && j!=i){
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
                } else if(i>0 && j == 0){
                    dp[i][j] = dp[i-1][j] + arr[i][j];
                } else if(i>0 && j==i){
                    dp[i][j] = dp[i-1][j-1] + arr[i][j];
                } else{ //인덱스 0,0
                    dp[i][j] = arr[i][j];
                }
            }
        }

        int max=0;
        for(int i=0;i<n;i++){
            max = Math.max(max, dp[n-1][i]);
        }
        System.out.println(max);
    }
}