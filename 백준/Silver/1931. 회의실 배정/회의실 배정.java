import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int count = 0, N;
    static int arr[][];

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            String str = bufferedReader.readLine();

            arr[i][0] = Integer.parseInt(str.split(" ")[0]);
            arr[i][1] = Integer.parseInt(str.split(" ")[1]);
        }

        Arrays.sort(arr, ((o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1])); // 종료 시간으로 정렬/종료시간이 같으면 시작시간으로 정렬

        int end = 0;
        for(int i=0;i<N;i++){
            if(end <= arr[i][0]){ // 종료 시간이 시작시간보다 작아야 됨
                end = arr[i][1];
                count++;
            }
        }
        System.out.println(count);
    }


}
