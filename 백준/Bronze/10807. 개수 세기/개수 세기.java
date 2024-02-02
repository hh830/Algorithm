import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        String str = bufferedReader.readLine();
        int arr[] = new int[n];
        int v = Integer.parseInt(bufferedReader.readLine());
        int count = 0;

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(str.split(" ")[i]);
            if(arr[i] == v){
                count++;
            }
        }

        System.out.println(count);

    }
}