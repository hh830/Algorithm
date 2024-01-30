import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(bufferedReader.readLine());
        Queue<Integer> queue = new LinkedList<>();


        for(int i=1;i<=input;i++){
            queue.add(i);
        }

        while(queue.size() > 1) {
            queue.poll();
            queue.add(queue.peek());
            queue.remove();
        }

        System.out.println(queue.peek());
    }
}