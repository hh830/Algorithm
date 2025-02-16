import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main{
    static List<List<Integer>> graph = new ArrayList<>();
    static int N, M, K, X;
    static int distance[];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken()); // 도시의 개수 N
        M = Integer.parseInt(stringTokenizer.nextToken()); // 도로의 개수 M
        K = Integer.parseInt(stringTokenizer.nextToken()); // 거리 정보 K
        X = Integer.parseInt(stringTokenizer.nextToken()); // 출발 도시의 번호 X

        distance = new int[N+1];

        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int u = Integer.parseInt(stringTokenizer.nextToken());
            int v = Integer.parseInt(stringTokenizer.nextToken());
            graph.get(u).add(v);
        }

        bfs();

        boolean flag = false;
        for(int i=1;i<=N;i++){
            if(distance[i] == K){
                flag = true;
                System.out.println(i);
            }
        }

        if(!flag){
            System.out.println(-1);
        }
    }

    static void bfs(){
        Arrays.fill(distance, -1);
        distance[X] = 0; // 출발지

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(X);

        while(!queue.isEmpty()){
            int node = queue.poll();

            for(int next : graph.get(node)){
                if(distance[next] == -1){ // 방문하지 않은 노드
                    distance[next] = distance[node] + 1; // 거리 +1
                    queue.add(next);
                }
            }
        }
    }
}