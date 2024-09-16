import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n, m, arr[][], result[][], tm, tn;
    private static boolean visit[][];
    private static int dx[] = {-1, 1, 0, 0};
    private static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String str = bufferedReader.readLine();
        n = Integer.parseInt(str.split(" ")[0]);
        m = Integer.parseInt(str.split(" ")[1]);

        arr = new int[n][m];
        result = new int[n][m];
        visit = new boolean[n][m];

        for(int i=0;i<n;i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j=0;j<m;j++){
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());

                if (arr[i][j] == 2){
                    tm = j;
                    tn = i;
                    result[i][j] = 0;
                } else if(arr[i][j] == 0){
                    result[i][j] = 0;
                } else{
                    result[i][j] = -1;
                }
            }
        }

        bfs(tm, tn);

        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                stringBuilder.append(result[i][j]).append(" ");
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static void bfs(int x, int y){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 0));

        visit[y][x] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int i=0;i<4;i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(!checkValidate(nx, ny)){
                    if(arr[ny][nx] == 0){
                        result[ny][nx] = 0;
                        continue;
                    }
                    queue.add(new Node(nx, ny, node.count + 1));
                    visit[ny][nx] = true;
                    result[ny][nx] = node.count + 1;
                }
            }
        }
    }

    private static boolean checkValidate(int x, int y){
        if(x < 0 || y < 0 || x >= m || y >= n || visit[y][x]){
            return true;
        }
        return false;
    }

    static class Node{
        private int x, y, count;

        Node(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}