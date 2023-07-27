import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    static int[][] arr;
    static int A, B;
    static boolean[][] visited;
    static int[] dx= { -1, 1, 0, 0 };
    static int[] dy={ 0, 0, -1, 1 };


    public static void main(String args[]) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String str= bufferedReader.readLine();
        A=Integer.parseInt(str.split(" ")[0]);
        B=Integer.parseInt(str.split(" ")[1]);

        arr=new int[A][B];
        //int[][] graph=new int[A][B];
        visited = new boolean[A][B];

        for(int i=0;i<A;i++){
            str =bufferedReader.readLine();
            for(int j=0;j<B;j++){
                arr[i][j]=str.charAt(j)-'0';
            }

        }

        bfs(0,0);
        System.out.println(arr[A-1][B-1]);

    }
    static void bfs(int x, int y){
        Queue<int[]>queue=new LinkedList<>();
        queue.add(new int[] {x,y});
        visited[0][0]=true;


        while(!queue.isEmpty()) {
            int now[] = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i=0; i<4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= A || nextY >= B)
                    continue;
                if (visited[nextX][nextY] || arr[nextX][nextY] == 0)
                    continue;

                queue.add(new int[] {nextX, nextY});
                arr[nextX][nextY] = arr[nowX][nowY] + 1;
                visited[nextX][nextY] = true;
            }
        }

    }
}