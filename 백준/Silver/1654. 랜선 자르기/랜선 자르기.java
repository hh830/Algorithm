import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();

        int K = Integer.parseInt(str.split(" ")[0]); // 갖고 있는 랜선 개수
        int N = Integer.parseInt(str.split(" ")[1]); // 필요한 랜선 개수

        int arr[] = new int[K];
        long max = 0;

        for(int i=0;i<K;i++){
            // 각 랜선의 길이 (cm)
            arr[i] = Integer.parseInt(bufferedReader.readLine());
            if(max < arr[i]){
                max = arr[i];
            }
        }

        max++;

        long min = 0;
        long mid = 0;

        while(min < max){
            mid = (max + min) / 2;

            long count = 0;

            for(int i=0;i<arr.length;i++){
                count += (arr[i] / mid);
            }

            if(count < N){
                max = mid;
            } else{
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }
}