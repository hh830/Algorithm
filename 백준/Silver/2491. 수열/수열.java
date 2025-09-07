import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        int arr[] = new int[N];
        
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int arr1[] = new int[N]; // 증가
        int arr2[] = new int[N]; // 감소

        arr1[0] = 1;
        arr2[0] = 1;
        int max = 1;

        for (int i=1; i<N; i++) {
            // 증가
            if (arr[i] >= arr[i-1]) {
                arr1[i] = arr1[i-1] + 1;
            } else {
                arr1[i] = 1;
            }

            // 감소
            if (arr[i] <= arr[i-1]) {
                arr2[i] = arr2[i-1] + 1;
            } else {
                arr2[i] = 1;
            }

            max = Math.max(max, Math.max(arr1[i], arr2[i]));
        }

        System.out.println(max);
    }
}
