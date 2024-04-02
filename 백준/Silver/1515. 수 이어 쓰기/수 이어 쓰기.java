import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        char ch[] = bufferedReader.readLine().toCharArray();
        int pointer = 0;
        int count = 1;
        
        while(pointer < ch.length){
            String num = Integer.toString(count);
            
            for(int i=0;i<num.length();i++){
                if(num.charAt(i) == ch[pointer]){
                    pointer++;
                }
                if(pointer >= ch.length)
                    break;
            }
            count += 1;
        }
        System.out.println(count-1);
    }
}
