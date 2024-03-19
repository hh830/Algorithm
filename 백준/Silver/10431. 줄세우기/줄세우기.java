import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        StringBuilder stringBuilder = new StringBuilder();
        int P = Integer.parseInt(bufferedReader.readLine());
        int T;


        for(int i=0;i<P;i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            T = Integer.parseInt(stringTokenizer.nextToken());

            int arr[] = new int[20];
            int count = 0;
            
            for(int j=0;j<20;j++){
                arr[j] = Integer.parseInt(stringTokenizer.nextToken());
            }

            for(int l=0;l<20;l++){
                for(int j=0;j<l;j++){
                    if(arr[j] > arr[l]){
                        count++;
                    }
                }
            }

            stringBuilder.append(T).append(" ").append(count).append("\n");
        }
        System.out.println(stringBuilder);
    }


}