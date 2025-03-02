import java.io.*;
import java.util.*;

public class Main {

    static int arr[][][];
    static boolean visit[][][];
    static Queue<Node> queue = new ArrayDeque<>();

    static int M, N, H;
    static int dx[] = { 1, -1, 0, 0, 0, 0 };
    static int dy[] = { 0, 0, 1, -1, 0, 0 };
    static int dz[] = { 0, 0, 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        M = Integer.parseInt(stringTokenizer.nextToken());
        N = Integer.parseInt(stringTokenizer.nextToken());
        H = Integer.parseInt(stringTokenizer.nextToken());

        arr = new int[M][N][H];
        visit = new boolean[M][N][H];


        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());

                for(int l=0;l<M;l++){
                    arr[l][j][i] = Integer.parseInt(stringTokenizer.nextToken());
                    if(arr[l][j][i] == 1){
                        queue.add(new Node(l, j, i, 0));
                        visit[l][j][i] = true;
                    }
                }
            }
        }

        int cnt = bfs();
        boolean flag = finalCheck(); // true면 익지 않음

        if(flag){
            // 익지 않은 토마토
            System.out.println(-1);
        } else {
            System.out.println(cnt);
        }
    }

    private static int bfs(){

        int count = 0;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            count = Math.max(count, node.day);

            for(int i=0;i<6;i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                int nz = node.z + dz[i];

                if(check(nx, ny, nz) && arr[nx][ny][nz] == 0 && !visit[nx][ny][nz]){
                    queue.add(new Node(nx, ny, nz, node.day + 1));
                    visit[nx][ny][nz] = true;
                    arr[nx][ny][nz] = 1;
                }
            }
        }
        return count;
    }

    private static boolean check(int nx, int ny, int nz){
        if(nx < 0 || ny < 0 || nz < 0 || nx >= M || ny >= N || nz >= H){
            return false;
        }
        return true;
    }

    private static boolean finalCheck(){
        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                for(int l=0;l<M;l++){
                    if(arr[l][j][i] == 0){
                        // 토마토 익지 않음
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static class Node{
        int x, y, z, day;

        Node(int x, int y, int z, int day){
            this.x=x;
            this.y=y;
            this.z=z;
            this.day=day;
        }
    }
}