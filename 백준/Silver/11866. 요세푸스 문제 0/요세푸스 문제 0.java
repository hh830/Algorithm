import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());
        int count = 0, temp = 0;
        String result = "";

        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=N;i++){
            queue.add(i);
        }

        while(queue.size() > 1){
            count ++;
            if(count == K) {
                temp = queue.poll();
                result += temp +", ";
                count = 0;
            }
            else{
                temp = queue.poll();
                queue.add(temp);
            }
        }

        System.out.println("<"+result+queue.peek()+">");
    }
}