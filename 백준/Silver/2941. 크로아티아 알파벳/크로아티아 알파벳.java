import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String arr[] = bufferedReader.readLine().split("");
        int count = 0;

        for(int i=0;i<arr.length;i++){
            if(arr[i].equals("c")){
                if((arr.length > i+1) && arr[i+1].equals("=")){
                    count++;
                    i++;
                } else if((arr.length > i+1) && arr[i+1].equals("-")){
                    count++;
                    i++;
                } else {
                    count++;
                }
            } else if(arr[i].equals("d")){
                if((arr.length > i+1) && arr[i+1].equals("-")){
                    count++;
                    i++;
                } else if((arr.length > i+2) && arr[i+1].equals("z") && arr[i+2].equals("=")){
                    count++;
                    i+=2;
                } else{
                    count++;
                }
            } else if(arr[i].equals("l")){
                if((arr.length > i+1) && arr[i+1].equals("j")){
                    count++;
                    i++;
                } else{
                    count++;
                }
            } else if(arr[i].equals("n")){
                if((arr.length > i+1) && arr[i+1].equals("j")){
                    count++;
                    i++;
                } else{
                    count++;
                }
            } else if(arr[i].equals("s")){
                if((arr.length > i+1) && arr[i+1].equals("=")){
                    count++;
                    i++;
                } else{
                    count++;
                }
            } else if(arr[i].equals("z")){
                if((arr.length > i+1) && arr[i+1].equals("=")){
                    count++;
                    i++;
                } else{
                    count++;
                }
            } else{
                count++;
            }
        }

        System.out.println(count);
    }
}