import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        String str = bufferedReader.readLine();
        StringBuilder stringBuilder = new StringBuilder();

        int input[] = new int[N];
        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i=0;i<N;i++){
            input[i] = Integer.parseInt(str.split(" ")[i]);
        }

        for(int i=N-1;i>=0;i--){
            int in = input[i];
            arrayList.add(in, i+1);
        }

        for(int i=0;i<N;i++){
            stringBuilder.append(arrayList.get(i)).append(" ");
        }

        System.out.println(stringBuilder);
    }
}