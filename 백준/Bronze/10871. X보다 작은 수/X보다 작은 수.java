import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int X = Integer.parseInt(stringTokenizer.nextToken());

        StringBuilder stringBuilder = new StringBuilder();

        stringTokenizer = new StringTokenizer(br.readLine());

        int input=0;
        for(int i=0;i<N;i++){
            input = Integer.parseInt(stringTokenizer.nextToken());
            if(input < X){
                stringBuilder.append(input).append(" ");
            }
        }

        System.out.println(stringBuilder);
    }
}
