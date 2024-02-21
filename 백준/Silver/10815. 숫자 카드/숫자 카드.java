import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        HashMap<Integer, Integer> hashMap = new HashMap<>(); // <값, 순서>

        for(int i=0;i<N;i++){
            hashMap.put(Integer.parseInt(stringTokenizer.nextToken()), i);
        }
        int M = Integer.parseInt(bufferedReader.readLine());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for(int j=0;j<M;j++){
            int input = Integer.parseInt(stringTokenizer.nextToken());

            if(hashMap.containsKey(input)){
                stringBuilder.append(1).append(" ");
            } else{
                stringBuilder.append(0).append(" ");
            }
        }

        System.out.println(stringBuilder);

    }
}