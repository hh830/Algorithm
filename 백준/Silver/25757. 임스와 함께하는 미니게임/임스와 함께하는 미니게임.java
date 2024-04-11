import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int N = Integer.parseInt(str.split(" ")[0]);
        String type = str.split(" ")[1];

        String name;
        int count = 0, friend = 0, cnt_friend = 1;
        switch (type){
            case "Y":
                friend = 2;
                break;
            case "F":
                friend = 3;
                break;
            case "O":
                friend = 4;
                break;
        }
        HashMap <String, Integer> map = new HashMap<>();
        for(int i=0;i<N;i++){
            name = br.readLine();
            if(map.containsKey(name)){
                //이미 했으면 못함
            } else{
                cnt_friend++;
                map.put(name, i);
                if(cnt_friend == friend){
                    count++;
                    cnt_friend = 1;
                }
            }
        }

        System.out.println(count);
    }

}
