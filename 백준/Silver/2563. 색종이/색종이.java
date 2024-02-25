import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine()); //색종이의 수
        boolean arr[][] = new boolean[100][100];
        int a, b, result=0;
        String str;

        for(int i=0;i<n;i++){
            str = bufferedReader.readLine();
            a = Integer.parseInt(str.split(" ")[0]);
            b = Integer.parseInt(str.split(" ")[1]);

            for(int j=a;j<a+10;j++){
                for(int k=b;k<b+10;k++){
                    if(!arr[k][j]) {
                        arr[k][j] = true;
                        result++;
                    }
                }
            }
        }

        System.out.println(result);
    }
}