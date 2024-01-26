import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num1 = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            num1[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num1);

        int M = Integer.parseInt(br.readLine());
        int[] num2 = new int[M];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < M; i++) {
            num2[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            if (binarySearch(num1, num2[i])) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    public static boolean binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (array[mid] == target) {
                return true;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
}
