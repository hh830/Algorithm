import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

import static java.lang.Math.round;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        String str;

        String arr[][] = new String[N][2];
        
        for(int i=0;i<N;i++){
            str = bufferedReader.readLine();
            arr[i][0] = str.split(" ")[0];
            arr[i][1] = str.split(" ")[1];
        }
        
        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }
        });
        
        for(int i=0;i<N;i++){
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }

    }
}