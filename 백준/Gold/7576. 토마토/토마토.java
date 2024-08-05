import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 1: 익은 토마토 0: 익지 않은 토마토 -1: 토마토가 없음
    // 저장될 때부터 모든 토마토가 익어있으면 0, 모두 익지 못하면 -1
    private static int N, M;
    private static int arr[][];
    private static Queue<Node> queue = new ArrayDeque();
    private static int dx[] = { 1, -1, 0, 0};
    private static int dy[] = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();

        M = Integer.parseInt(str.split(" ")[0]); // 가로
        N = Integer.parseInt(str.split(" ")[1]); // 세로

        arr = new int[N][M];

        for(int i=0;i<N;i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if(arr[i][j]==1){
                    queue.offer(new Node(j, i, 0));
                }
            }
        }
        System.out.println(bfs());
    }

    private static int bfs(){
        int totalDay = 0;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            totalDay = node.day;

            for(int i=0;i<4;i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(checkRange(nx, ny) && arr[ny][nx] == 0){
                    // 범위 정상
                    arr[ny][nx] = 1;
                    queue.offer(new Node(nx, ny, node.day+1));
                }
            }
        }

        if(checkTomato()){
            return totalDay;
        } else{
            return -1;
        }
    }

    private static boolean checkTomato(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j] == 0){
                    // 토마토가 다 익지 않음
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkRange(int x, int y){
        if(x < 0 || x >= M || y < 0 || y >= N){
            return false;
        }
        return true;
    }

    private static class Node{
        private int x, y, day;

        public Node(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
}