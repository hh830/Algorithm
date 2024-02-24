import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder stringBuilder = new StringBuilder();

        for(int i=0;i<N;i++){
            int input = Integer.parseInt(bufferedReader.readLine());

            if(input == 0){
                if(queue.isEmpty()){
                    stringBuilder.append(0).append("\n");
                } else{
                    stringBuilder.append(queue.poll()).append("\n");
                }
            } else if(input > 0){
                queue.add(input);
            }
        }
        
        System.out.println(stringBuilder);
    }
}