import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine()); //지방의 수
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine()); // 각 지방 예산 요청
        int arr[] = new int[N];

        int sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
            sum += arr[i];
        }

        int M = Integer.parseInt(bufferedReader.readLine()); //총 예산

        Arrays.sort(arr); //int arr는 에러남. Integer arr

        if(M < sum){
            // 상한가 결정이 필요한 경우 - 이분탐색
            int start = M / N;
            int end = arr[N-1]-1;
            int mid;
            int max = 0;

            while(start <= end){
                sum = 0;
                mid = (start + end) / 2;
                for(int i=0;i<N;i++){
                    if(arr[i] > mid){
                        sum += mid;
                    } else{
                        sum += arr[i];
                    }
                }
                if(sum <= M){
                    max = Math.max(max, mid);
                    start = mid + 1;
                } else{
                    end = mid - 1;
                }
            }
            System.out.println(max);

        } else{
            // 상한가 결정 필요 없는 경우
            System.out.println(arr[N-1]);
        }
    }
}
