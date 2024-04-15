import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        ArrayList <Integer> arrayList = new ArrayList<>();

        int total = N;
        int i = 2;
        while(total>1){
            if(total % i == 0){
                total = total / i;
                arrayList.add(i);
                i=2;
            } else{
                i++;
            }

        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int j=0;j<arrayList.size();j++){
            stringBuilder.append(arrayList.get(j)).append("\n");
        }
        System.out.println(stringBuilder);
    }
}
