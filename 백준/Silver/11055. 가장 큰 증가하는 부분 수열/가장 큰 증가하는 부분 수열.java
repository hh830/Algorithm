import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        int dp[] = new int[N];
        int arr[] = new int[N];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
            dp[i] = arr[i];
        }
        
        for (int i=1;i<N;i++) {
            for (int j=0;j<i;j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
        }

        int max = 0;
        for (int i=0;i<N;i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }

        System.out.println(max);
    }
}
