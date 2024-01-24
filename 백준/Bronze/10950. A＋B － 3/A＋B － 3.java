import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        
        String str;
        int A, B;

        for(int i=0;i<T;i++) {
            str = bufferedReader.readLine();
            A = Integer.parseInt(str.split(" ")[0]);
            B = Integer.parseInt(str.split(" ")[1]);

            System.out.println(A+B);
        }


    }
}