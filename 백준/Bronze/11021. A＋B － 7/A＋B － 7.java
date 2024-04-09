import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<T;i++){
            String str = br.readLine();

            String str1 = "Case #"+ (i+1) + ": " + (Integer.parseInt(str.split(" ")[0]) + Integer.parseInt(str.split(" ")[1]));
            sb.append(str1).append("\n");
        }
        System.out.println(sb);
    }
}
