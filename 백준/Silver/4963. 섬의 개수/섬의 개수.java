import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main{

    static int map[][];
    static boolean visit[][];
    static int dx[] = { 1, -1, 0, 0, 1, -1, 1, -1 };
    static int dy[] = { 0, 0, 1, -1, 1, 1, -1, -1 };
    static int w, h;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        while(true){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            w = Integer.parseInt(stringTokenizer.nextToken());
            h = Integer.parseInt(stringTokenizer.nextToken());

            if(w == 0 && h == 0)
                break;

            map = new int[w][h];
            visit = new boolean[w][h];

            for(int i=0;i<h;i++){
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());

                for(int j=0;j<w;j++){
                    map[j][i] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }

            int count = 0;

            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    if(!visit[j][i] && map[j][i] == 1){
                        bfs(j, i);
                        count++;
                    }
                }
            }

            System.out.println(count);
            stringBuilder.append(count).append("\n");
        }
    }

    static void bfs(int x, int y){
        Queue<int []> queue = new ArrayDeque<>();

        queue.add(new int[] { x, y });
        visit[x][y] = true;

        while(!queue.isEmpty()) {
            int[] q = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = q[0] + dx[i];
                int ny = q[1] + dy[i];

                if(check(nx, ny) && map[nx][ny] == 1 && !visit[nx][ny]){
                    queue.add(new int[] { nx, ny });
                    visit[nx][ny] = true;
                }
            }
        }

    }

    static boolean check(int x, int y){
        if(x < 0 || y < 0 || x >= w || y >= h){
            return false;
        }
        return true;
    }
}