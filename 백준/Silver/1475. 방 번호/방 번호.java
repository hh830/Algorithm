import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String N = bufferedReader.readLine();

        int[] count = new int[10];
        for(char c : N.toCharArray()){
            int num = Character.getNumericValue(c);
            if(num == 6 || num == 9){
                count[6]++;
            } else{
                count[num]++;
            }
        }

        count[6] = (count[6]+1) / 2;
        int max = 0;
        for(int i : count){
            if(i > max){
                max = i;
            }
        }

        System.out.println(max);
    }
}
