import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        long X = Long.parseLong(input.split(" ")[0]);  // 총 게임 수
        long Y = Long.parseLong(input.split(" ")[1]);;  // 이긴 게임 수

        long Z = (Y * 100) / X;  // 현재 승률

        if(Z >= 99){
            System.out.println(-1);
            return;
        }

        long left = 1;
        long right = 1_000_000_000;
        long result = -1;

        while(left <= right) {
            long mid = (left + right) / 2;
            long nz = ((Y + mid) * 100) / (X + mid);

            if(nz > Z){
                result = mid;
                right = mid - 1; 
            } else{
                left = mid + 1;
            }
        }

        System.out.println(result);
    }
}
