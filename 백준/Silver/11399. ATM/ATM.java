import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        int[] times = new int[N];
        String input = bufferedReader.readLine();

        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(input.split(" ")[i]);
        }

        Arrays.sort(times);

        int totalTime = 0;
        int sum = 0;

        for (int time : times) {
            sum += time;  // 현재 사람이 기다려야 하는 시간
            totalTime += sum; // 총 대기 시간 누적
        }

        System.out.println(totalTime);
    }
}