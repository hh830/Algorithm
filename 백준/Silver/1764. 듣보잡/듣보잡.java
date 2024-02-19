import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        HashMap<String, String> hashMap = new HashMap();
        ArrayList<String> arr = new ArrayList<>();

        String str = "";

        for(int i=0;i<N;i++){
            str = bufferedReader.readLine();
            hashMap.put(str, "듣");
        }

        for(int j=0;j<M;j++){
            str = bufferedReader.readLine();

            if(hashMap.containsKey(str) && hashMap.containsValue("듣"))
            {
                arr.add(str);
            }
            
            hashMap.put(str, "보");
        }

        Collections.sort(arr);

        System.out.println(arr.size());
        
        for(int i=0;i<arr.size();i++){
            System.out.println(arr.get(i));
        }

    }
}