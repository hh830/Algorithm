import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;



public class Main {
    private static int N, M, R, count=1;
    private static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    private static boolean visit[];
    private static int num[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        R = Integer.parseInt(stringTokenizer.nextToken());
        visit = new boolean[N+1];
        num = new int[N+1];

        int u, v;
        for(int i=0;i<=N;i++){
            arrayList.add(new ArrayList<Integer>());
        }

        for(int i=0;i<M;i++){

            stringTokenizer = new StringTokenizer(br.readLine());
            u = Integer.parseInt(stringTokenizer.nextToken());
            v = Integer.parseInt(stringTokenizer.nextToken());
            arrayList.get(v).add(u);
            arrayList.get(u).add(v);
        }
        for(int i=1;i<=N;i++)
        {
            Collections.sort(arrayList.get(i), Collections.reverseOrder());

        }

        dfs(R);

        for(int i=1;i<=N;i++){
            if(num[i] == 0){
                System.out.println(0);
            } else
                System.out.println(num[i]);
        }
    }

    private static void dfs(int v){
        visit[v] = true;
        num[v] = count++;


        for (int next = 0; next < arrayList.get(v).size(); next++) {
            int nextNode = arrayList.get(v).get(next);
            if (!visit[nextNode]) {
                dfs(nextNode);
            }

        }
    }
}