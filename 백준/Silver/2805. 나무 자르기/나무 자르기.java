import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        
        int N = Integer.parseInt(stringTokenizer.nextToken()); // 나무 수
        int M = Integer.parseInt(stringTokenizer.nextToken()); // 필요한 나무의 길이
        int[] tree = new int[N];
        
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        
        int max = 0;
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(stringTokenizer.nextToken());
            if (tree[i] > max) {
                max = tree[i];
            }
        }
        
        int low = 0;
        int high = max;
        int result = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            long sum = 0;

            for (int t : tree) {
                if (t > mid) {
                    sum += t - mid;
                }
            }

            if (sum >= M) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(result);
    }
}
