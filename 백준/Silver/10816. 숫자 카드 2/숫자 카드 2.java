import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i=0;i<N;i++){
            int card = Integer.parseInt(stringTokenizer.nextToken());
            if(hashMap.get(card) == null){
                hashMap.put(card, 1);
            } else{
                int num = hashMap.get(card) + 1;
                hashMap.put(card, num);
            }
        }

        int M = Integer.parseInt(br.readLine());
        stringTokenizer = new StringTokenizer(br.readLine());

        for(int i=0;i<M;i++){
            int input = Integer.parseInt(stringTokenizer.nextToken());
            if(hashMap.get(input) == null)
                stringBuilder.append(0).append(" ");
            else
                stringBuilder.append(hashMap.get(input)).append(" ");
        }

        System.out.println(stringBuilder);
    }
}
