import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        int M = Integer.parseInt(bufferedReader.readLine());
        int arr[] = new int[M];

        int len = 0;
        int max = 0;
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        
        for(int i=0;i<M;i++){
            len = Integer.parseInt(stringTokenizer.nextToken());
            arr[i] = len;
        }

        int start = 1, end = N;
        // 이분 탐색
        while(start <= end){
            int point = 0;
            int mid = (start + end) / 2;
            boolean flag = true;

            for(int i=0;i<M;i++){
                if(arr[i] - mid <= point){
                    point = arr[i] + mid;
                } else{
                    flag = false;
                    break;
                }
            }

            if(N - point > 0)
                flag = false;
            else
                flag = true;

            if(flag){ //모두 비추기 가능
                max = mid;
                end = mid - 1;
            } else{
                start = mid + 1;
            }
        }

        System.out.println(max);
    }
}
