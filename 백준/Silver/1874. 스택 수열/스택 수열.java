import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int arr[] = new int[N];
        String str = "";
        Stack<Integer>stack = new Stack<>();
        Stack<String>result = new Stack<>();

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(bufferedReader.readLine());
        }

        int count = 1;
        stack.push(count);
        result.push("+");

        for(int i=0;i<N;i++){
            while(arr[i] > count){
                count++;
                stack.push(count);
                result.push("+");
            }
            if(!stack.isEmpty() && arr[i] == stack.peek()){
                stack.pop();
                result.push("-");
            } else{
                str = "NO";
                break;
            }
        }
        if(str == "NO")
            System.out.println(str);
        else{
            for(int i=0;i<result.size();i++){
                System.out.println(result.get(i));
            }
        }

    }
}