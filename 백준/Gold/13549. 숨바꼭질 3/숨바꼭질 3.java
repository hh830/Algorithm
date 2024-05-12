import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        int N = Integer.parseInt(str.split(" ")[0]);
        int K = Integer.parseInt(str.split(" ")[1]);
        int visit[] = new int[100001];

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(N, 0));
        visit[N] = 1;
        int time = Integer.MAX_VALUE;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(node.x == K){
                time = Math.min(time, node.time);
            }

            if(node.x * 2 <= 100000 && visit[node.x * 2] == 0) //방문 안한거
            {
                queue.add(new Node(2 * node.x, node.time));
                visit[node.x * 2] = 1;
            }
            
            if(node.x - 1 >= 0 && visit[node.x - 1] == 0){
                queue.add(new Node(node.x - 1, node.time + 1));
                visit[node.x - 1] = 1;
            }
            
            if(node.x + 1 <= 100000 && visit[node.x + 1] == 0){
                queue.add(new Node(node.x + 1, node.time + 1));
                visit[node.x + 1] = 1;
            }
            
        }
        System.out.println(time);
    }
}

class Node{
    int x, time;

    Node(int x, int time){
        this.x = x;
        this.time = time;
    }
}