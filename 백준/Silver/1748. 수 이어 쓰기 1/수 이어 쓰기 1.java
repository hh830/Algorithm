import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int a = 10; //자릿수 알아내기 위해
        int b = 1; //b 자릿수 입력
        int temp = 0; // 새로운 수 자릿수

        for(int i=1;i<=N;i++){
            if(i % a == 0){
                a *= 10;
                b++; //b 자릿수
            }
            temp += b;
        }
        System.out.println(temp);
    }
}