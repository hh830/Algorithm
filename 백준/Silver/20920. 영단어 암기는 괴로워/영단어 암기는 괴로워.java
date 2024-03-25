import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        String str="";
        HashMap<String, Integer> hashMap = new HashMap<>();

        for(int i=0;i<N;i++){
            str = bufferedReader.readLine();

            if(str.length() >= M)
                hashMap.put(str, hashMap.getOrDefault(str, 0)+1);
        }

        List<String> list = new ArrayList<>(hashMap.keySet());

        Collections.sort(list, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                if(Integer.compare(hashMap.get(o1), hashMap.get(o2)) != 0)
                    return Integer.compare(hashMap.get(o2), hashMap.get(o1));
                if(o1.length() != o2.length())
                    return o2.length() - o1.length();
                return o1.compareTo(o2);
            }
        });

        StringBuilder stringBuilder = new StringBuilder();
        for(String word : list){
            stringBuilder.append(word + "\n");
        }
        System.out.println(stringBuilder);
    }
}