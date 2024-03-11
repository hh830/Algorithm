import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int arr[] = new int[N];
        int dp[] = new int[N];

        for(int i=0;i<N;i++){
           arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for(int i=0;i<N;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if(arr[i] > arr[j] && dp[j] + 1 > dp[i])
                {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int max = -1;
        for(int i=0;i<N;i++){
            if(dp[i] > max){
                max = dp[i];
            }
        }
        System.out.println(max);
    }
}