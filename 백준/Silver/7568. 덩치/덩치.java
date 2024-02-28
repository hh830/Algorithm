import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer;
        int arr[][] = new int[N][2];

        StringBuilder stringBuilder = new StringBuilder();

        for(int i=0;i<N;i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            arr[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            arr[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for(int i=0;i<N;i++){
            int count=1;
            for(int j=0;j<N;j++){
                if((arr[i][0] < arr[j][0]) && (arr[i][1] < arr[j][1])){
                    count++;
                }
            }
            stringBuilder.append(count).append(" ");
        }
        System.out.println(stringBuilder);

    }
}