import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        String str = bufferedReader.readLine();
        HashMap <String, Integer> map = new HashMap<>();
        String arr[] = str.split("");

        //첫번째 단어
        for(int j=0;j<arr.length;j++) {
            map.put(arr[j], map.getOrDefault(arr[j], 0)+1);
            //System.out.println(map.get(arr[j]));
        }

        // 두 단어가 같은 구성을 갖는 경우
        // 한 단어에서 한 문자를 더하거나 빼서 같은 구성 = 하나만 다른거(길이 +-1)
        // 하나의 문자를 다른 문자로 바꾸어 같은 구성 = 하나만 글자 다른거
        for(int i=0;i<N-1;i++){
            str = bufferedReader.readLine();
            String s_arr[] = str.split("");
            compare(map, s_arr, arr.length, str);
            //System.out.println(map.keySet());
        }

        System.out.println(count);
    }

    private static void compare(HashMap<String, Integer> map, String s_arr[], int mapSize, String str){
        HashMap <String, Integer> smap = new HashMap<>(map);
        int fail = 0;

        for(int i=0;i<s_arr.length;i++) {
            if(smap.containsKey(s_arr[i])){
                if(smap.get(s_arr[i]) >= 1)
                    smap.put(s_arr[i], smap.get(s_arr[i]) - 1);
                else{
                    //문자는 있는데 길이가 다른거
                    //System.out.println(s_arr[i] + " " + smap.get(s_arr[i]));
                    fail++;
                }
            } else{
                fail++;
            }
        }
        //System.out.println("현재"+str +" "+ s_arr.length +" "+ mapSize);
        if((fail == 0 && (mapSize == s_arr.length || mapSize == s_arr.length + 1 || mapSize == s_arr.length - 1)))
        {
            //비슷한 단어임
            //System.out.println("성공" + str);
            count++;
        } else if(fail == 1 && (mapSize == s_arr.length - 1 || (mapSize == s_arr.length && mapSize >= 2))){
            //System.out.println("성공1" + str);
            count++;
        }
    }
}
