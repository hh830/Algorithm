import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String key = bufferedReader.readLine();
        String str = bufferedReader.readLine();

        int substrSize = str.length() / key.length();
        String[] substr = new String[key.length()]; // 암호문 n글자씩 쪼갠거
        String[] arr = key.split(""); //키 쪼갠거

        HashMap<Integer, String> stringHashMap = new HashMap<>();
        HashMap<Integer, String> keyMap = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();

        // 암호문 쪼개기
        for(int i=0; i<key.length(); i++){
            substr[i] = str.substring(i * substrSize, (i + 1) * substrSize);
        }
        
        // 맵 담기
        for(int i=0; i<key.length(); i++){
            keyMap.put(i+1, arr[i]);
        }

        // 암호키 맵 밸류로 정렬
        List<Map.Entry<Integer, String>> list = new ArrayList<>(keyMap.entrySet());
        list.sort((Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) -> o1.getValue().compareTo(o2.getValue()));

        Map<Integer, String> sortedMap = new LinkedHashMap<>(); //정렬된 맵(키 맵)
        for (Map.Entry<Integer, String> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        int count = 0;
        for(Map.Entry<Integer, String> entry : sortedMap.entrySet()){
            int k = entry.getKey();
            stringHashMap.put(k, substr[count]);
            count ++;
        }
        
        for(int i=0;i<substrSize;i++){
            for(int j=1;j<=stringHashMap.size();j++){
                stringBuilder.append(stringHashMap.get(j).charAt(i));
            }
        }
        
        System.out.println(stringBuilder);
    }
}