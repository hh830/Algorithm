import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(bufferedReader.readLine());
        Stack<Integer> stack = new Stack<>();
        int num;
        int count = 0;

        for(int i=0;i<input;i++){
            num = Integer.parseInt(bufferedReader.readLine());

            if(num == 0 && !stack.empty()){
                stack.pop();
            } else if(num != 0){
                stack.push(num);
            }

        }

        for(int i=0;i<stack.size();i++){
            count += stack.get(i);
        }
        System.out.println(count);
    }
}