import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        String strArr[] = new String[N];
        int range[] = new int[N];

        for(int i=0;i<N;i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            strArr[i] = stringTokenizer.nextToken();
            range[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int input = 0;
        int index = 0;
        for(int i=0;i<M;i++){
            input = Integer.parseInt(bufferedReader.readLine());

            index = search(input, range);
            stringBuilder.append(strArr[index]).append("\n");
        }

        System.out.print(stringBuilder);
    }

    private static int search(int input, int range[]){
        int start = 0;
        int end = range.length - 1;

        while(start <= end){
            int mid = (start + end) / 2;
            if(range[mid] < input) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }
}