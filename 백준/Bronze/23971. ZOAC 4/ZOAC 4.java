import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int H = Integer.parseInt(stringTokenizer.nextToken());
        int W = Integer.parseInt(stringTokenizer.nextToken());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int count = 0;
        for(int i=0;i<H;i+=N+1){
            for(int j=0;j<W;j+=M+1){
                count++;
            }
        }
        System.out.println(count);
    }
}