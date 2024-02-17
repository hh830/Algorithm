import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int dp[][][] = new int[21][21][21];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;
        StringBuilder stringBuilder = new StringBuilder();

        while(true)
        {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());

            if(a == -1 && b == -1 && c == -1){
                break;
            }

            result = w(a,b,c);
            stringBuilder.append("w(" + a + ", " + b + ", " + c + ") = ").append(result).append("\n");

        }
        System.out.println(stringBuilder);
    }

    private static int w(int a, int b, int c){

        if (!(a < 0 || a > 20 || b < 0 || b > 20 || c < 0 || c > 20)) {
            if(dp[a][b][c] != 0)
            {
                return dp[a][b][c];
            }

        }
        if(a<=0 || b<=0 || c<=0){
            return dp[0][0][0] = 1;
        }

        if(a > 20 || b > 20 || c > 20){
            return dp[20][20][20] = w(20,20,20);
        }
        if(a < b && b < c){
            return dp[a][b][c] = w(a,b,c-1) + w(a,b-1,c-1) - w(a, b-1, c);
        }

        return dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
    }

}
