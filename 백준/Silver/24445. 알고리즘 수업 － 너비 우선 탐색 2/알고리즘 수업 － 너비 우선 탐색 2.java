import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, M, R, count=1;
    private static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    private static Queue<Integer> queue = new LinkedList<>();
    private static boolean[] visit;
    private static int[] order;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        R = Integer.parseInt(stringTokenizer.nextToken());
        visit = new boolean[N+1];
        order = new int[N+1];

        for(int i = 0; i <= N; i++){
            arrayList.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            stringTokenizer = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stringTokenizer.nextToken());
            int v = Integer.parseInt(stringTokenizer.nextToken());
            arrayList.get(u).add(v);
            arrayList.get(v).add(u);
        }

        for(int i = 1; i <= N; i++){
            Collections.sort(arrayList.get(i), Collections.reverseOrder());
        }

        queue.offer(R);
        visit[R] = true;
        order[R] = count++;

        bfs();

        for(int i = 1; i <= N; i++){
            if(order[i] == 0){
                System.out.println(0);
            } else {
                System.out.println(order[i]);
            }
        }
    }

    private static void bfs(){
        while(!queue.isEmpty()){
            int v = queue.poll();

            for(int i = 0; i < arrayList.get(v).size(); i++){
                int nextNode = arrayList.get(v).get(i);
                if(!visit[nextNode]){
                    queue.offer(nextNode);
                    visit[nextNode] = true;
                    order[nextNode] = count++;
                }
            }
        }
    }
}
