import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String arr[] = bufferedReader.readLine().split("-");
        
        int total=0;
        
        for(int i=0;i<arr.length;i++){
            int sum = 0;
            String arr2[] = arr[i].split("\\+");
            
            for(String num : arr2){
                sum += Integer.parseInt(num);
            }
            
            if(i==0){
                total += sum;
            } else{
                total -= sum;
            }
        }

        System.out.println(total);
    }
}
