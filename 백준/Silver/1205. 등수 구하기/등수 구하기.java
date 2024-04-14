import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        int N = Integer.parseInt(str.split(" ")[0]);
        int new_score = Integer.parseInt(str.split(" ")[1]);
        int P = Integer.parseInt(str.split(" ")[2]);

        int arr[] = new int[P];

        if (N == 0) {
            System.out.println(1);
        } else {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(stringTokenizer.nextToken());
            }
            
            if (N == P && arr[arr.length - 1] >= new_score) {
                System.out.println(-1);
            } else {
                int count = 1;
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] > new_score) {
                        count++;
                    } else {
                        break;
                    }
                }
                System.out.println(count);

            }
        }
    }
}
