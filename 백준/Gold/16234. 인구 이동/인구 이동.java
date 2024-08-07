import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, L, R;
    private static int arr[][];
    private static int dx[] = { 1, -1, 0, 0};
    private static int dy[] = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        L = Integer.parseInt(stringTokenizer.nextToken());
        R = Integer.parseInt(stringTokenizer.nextToken());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        boolean visit[][];

        int count = 0;
        while (true) {
            visit = new boolean[N][N];

            if (bfs(visit) == 0) {
                break;
            } else {
                count++;
            }
        }

        System.out.println(count);
    }

    private static int bfs(boolean visit[][]){
        int cnt = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visit[i][j]) {
                    Queue<Node> queue = new ArrayDeque<>();
                    ArrayList<Node> arrayList = new ArrayList<>();

                    queue.add(new Node(j, i));

                    int total = arr[i][j]; // 인구 수
                    visit[i][j] = true;
                    arrayList.add(new Node(j, i));


                    while (!queue.isEmpty()) {
                        Node node = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int nx = node.x + dx[k];
                            int ny = node.y + dy[k];

                            if (check(nx, ny, node.x, node.y, visit)) { // 연합 열림
                                queue.add(new Node(nx, ny));
                                arrayList.add(new Node(nx, ny));
                                visit[ny][nx] = true;
                                total += arr[ny][nx];
                                cnt++;
                            }
                        }
                    }
                    if(arrayList.size() >0){
                        int average = total / arrayList.size();

                        for(int m=0;m<arrayList.size();m++){
                            Node node = arrayList.get(m);
                            arr[node.y][node.x] = average;
                        }
                    }
                }
            }
        }

        return cnt;
    }

    private static boolean check(int nx, int ny, int x, int y, boolean visit[][]){
        if(nx < 0 || nx >= N || ny < 0 || ny >= N || visit[ny][nx])
            return false;

        int num = Math.abs(arr[y][x] - arr[ny][nx]);
        if(num >= L && num <= R){
            return true;
        }

        return false;
    }

    static class Node{
        private int x;
        private int y;

        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}