import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        int[][] sum = new int[n+1][m+1]; 

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                sum[i+1][j+1] = arr[i][j] + sum[i+1][j] + sum[i][j+1] - sum[i][j];
            }
        }
        
        int k = Integer.parseInt(br.readLine());
        for (int t = 0; t < k; t++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            int result = sum[x][y] - sum[i-1][y] - sum[x][j-1] + sum[i-1][j-1];
            sb.append(result).append("\n");
        }
        
        System.out.print(sb);
    }
}
