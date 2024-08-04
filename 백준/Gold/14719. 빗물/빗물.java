import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int H, W, arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        H = Integer.parseInt(str.split(" ")[0]);
        W = Integer.parseInt(str.split(" ")[1]);

        arr = new int[W];
        str = bufferedReader.readLine();
        int max = Integer.MIN_VALUE;
        for(int i=0;i<W;i++){
            arr[i] = Integer.parseInt(str.split(" ")[i]);
            max = Math.max(max, arr[i]);
        }
        int s = 0;
        for(int i=1;i<W-1;i++){
            int left = arr[i];
            int right = arr[i];

            for(int j = i-1; j>=0;j--){
                if(arr[i] < arr[j]) {
                    // 왼쪽 최대
                    left = Math.max(left, arr[j]);
                }
            }

            for(int j = i+1; j < W ; j++){
                if(arr[i] < arr[j]){
                    // 오른쪽 최대
                    right = Math.max(right, arr[j]);
                }
            }

            if(arr[i] < left && arr[i] < right){
                int min = Math.min(left, right);
                s += min - arr[i];
            }
        }
        System.out.println(s);

    }
}