import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static int dp[][] = new int[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        for(int i=0;i<T;i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int N = Integer.parseInt(stringTokenizer.nextToken());
            int M = Integer.parseInt(stringTokenizer.nextToken());

            stringBuilder.append(method(M, N)).append("\n");
        }

        System.out.println(stringBuilder);
    }

    static int method(int n, int r){
        if(dp[n][r] > 0){
            // 이미 값이 있을 때
            return dp[n][r];
        }

        if(n==r || r == 0){
            // 1일 때(nC0 or nCn)
            dp[n][r] = 1;
            return dp[n][r];
        }

        return dp[n][r] = method(n-1,r-1) + method(n-1, r);
    }
}