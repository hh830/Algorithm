import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String str = bufferedReader.readLine();

        int N = Integer.parseInt(str.split(" ")[0]);
        int M = Integer.parseInt(str.split(" ")[1]);

        Set<String> set = new HashSet<>();

        for(int i=0;i<N;i++){
            set.add(bufferedReader.readLine());
        }
        
        int count = 0;
        for(int i=0;i<M;i++){
            str = bufferedReader.readLine();
            
            if (set.contains(str)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
