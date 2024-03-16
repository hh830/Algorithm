import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        int result = N;
        int count = 0;

        while(result > 0){
            if(result >= 3){
                result -= 3;
            } else if(result >= 1){
                result -= 1;
            }
            count++;
        }

        if (count % 2 == 0) {
            System.out.println("CY");
        } else{
            System.out.println("SK");
        }
    }

}