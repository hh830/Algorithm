import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int arr[][] = new int[N][M];
        int dp[][][] = new int[N][M][3];
        int x[] = { -1, 0, 1};

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                for(int k=0;k<3;k++){
                    dp[i][j][k] = Integer.MAX_VALUE-1;
                }
            }
        }

        for(int i=0;i<M;i++){
            for(int j=0;j<3;j++){
                dp[0][i][j] = arr[0][i];
            }
        }

        int min = Integer.MAX_VALUE-1;

        for(int i=1;i<N;i++){
            for(int j=0;j<M;j++){
                if(j-1 < 0){ //오른쪽에서 온 게 없고 왼쪽으로 갈 수 없음
                    dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + arr[i][j];
                    dp[i][j][2] = Math.min(dp[i-1][j+1][0], dp[i-1][j+1][1]) + arr[i][j];

                } else if(j+1 >= M){ //왼쪽에서 온 게 없고 오른쪽으로 갈 수 없음
                    dp[i][j][0] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2]) + arr[i][j];
                    dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + arr[i][j];

                } else{
                    dp[i][j][0] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2]) + arr[i][j];
                    dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + arr[i][j];
                    dp[i][j][2] = Math.min(dp[i-1][j+1][0], dp[i-1][j+1][1]) + arr[i][j];
                }
            }
        }

        for(int i=0;i<M;i++){
            for(int k=0;k<3;k++){
                min = Math.min(min, dp[N-1][i][k]);
            }
        }
        System.out.println(min);

    }
}