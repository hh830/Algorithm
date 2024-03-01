import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        HashMap<Integer, String> hashMap = new HashMap<>();
        HashMap<String, Integer> hashMap1 = new HashMap<>();
        
        String str;
        int input;

        for(int i=1;i<=N;i++){
            str = br.readLine();
            hashMap.put(i, str);
            hashMap1.put(str, i);
        }

        for(int i=N+1;i<=N+M;i++){
            str = br.readLine();

            if(str.matches("[0-9]+")){
                //정수
                input = Integer.parseInt(str);
                System.out.println(hashMap.get(input));
            } else{
                System.out.println(hashMap1.get(str));
            }
        }
    }


}



