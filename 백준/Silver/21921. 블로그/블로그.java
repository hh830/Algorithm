import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int X = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int arr[] = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int count = 0;
        int day = 1;
        int max = 0;

        for(int i=0;i<N-X+1;i++){
            if(i==0){
                for(int j=i;j<X;j++){
                    count += arr[j];
                }
            } else{
                count = count - arr[i-1] + arr[i+X-1];
            }

            if(count > max){
                max = count;
                day = 1;
            } else if(max == count){
                day++;
            }
        }

        if(max == 0){
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(day);
        }
    }
}