import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    private static int arr[][], N;
    private static int dx[] = { 0, 0, -1, 1 };
    private static int dy[] = { 1, -1, 0, 0 };

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int count=1;
        while(true){
            N = Integer.parseInt(bufferedReader.readLine());
            
            if(N == 0) break;
            
            arr = new int[N][N];

            for(int i=0;i<N;i++){
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for(int j=0;j<N;j++){
                    arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }
            int result = bfs(0,0);
            System.out.println("Problem " + count + ": "+ result);
            count++;
        }
    }

    private static int bfs(int x, int y){
        int cost[][] = new int[N][N];

        for(int[] i : cost ) Arrays.fill(i, Integer.MAX_VALUE);

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(x, y, arr[0][0]));
        cost[0][0] = arr[0][0];

        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int i=0;i<4;i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                int total_rupee = node.rupee;

                if(check(nx, ny) && total_rupee + arr[ny][nx] < cost[ny][nx]){
                    queue.add(new Node(nx, ny, arr[ny][nx] + total_rupee));
                    cost[ny][nx] = total_rupee + arr[ny][nx];
                }
            }
        }
        return cost[N-1][N-1];
    }

    private static boolean check(int x, int y){
        if(x < 0 || x >= N || y < 0 || y >= N){
            return false;
        }
        return true;
    }

    static class Node implements Comparable<Node>{
        private int x;
        private int y;
        private int rupee;

        public Node(int x, int y, int rupee) {
            this.x = x;
            this.y = y;
            this.rupee = rupee;
        }

        @Override
        public int compareTo(Node o) {
            return this.rupee - o.rupee;
        }
    }
}