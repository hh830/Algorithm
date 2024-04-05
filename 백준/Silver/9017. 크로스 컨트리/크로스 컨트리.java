import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int T = Integer.parseInt(bufferedReader.readLine());
        int answer[] = new int[T];
        for(int i=0;i<T;i++) {
            int N = Integer.parseInt(bufferedReader.readLine());

            ArrayList<Integer> arr = new ArrayList<>();
            HashMap <Integer, Integer> data = new HashMap<>(); // (팀 번호, 팀안에서 등수)
            int [] rank = new int[N];
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int max = 0;
            for(int j=0;j<N;j++){
                int in = Integer.parseInt(stringTokenizer.nextToken());
                data.put(in, data.getOrDefault(in, 0)+1);

                rank[j] = in;
                max = Math.max(max, in);
            }

            int [] fifth = new int[max + 1];
            HashMap <Integer, Integer> count = new HashMap<>();
            HashMap <Integer, Integer> tmp = new HashMap<>();
            int score = 1;

            for(int j : rank){
                if(data.get(j) == 6){
                    tmp.put(j, tmp.getOrDefault(j, 0)+1);
                    if(tmp.get(j)<=4){
                        count.put(j, count.getOrDefault(j, 0)+score);
                    }
                    if(tmp.get(j) == 5){
                        fifth[j] = score;
                    }
                    score++;
                }
            }

            int result = Integer.MAX_VALUE;
            int fifthScore = Integer.MAX_VALUE;
            for (Integer key : count.keySet()) {
                int temp = count.get(key);
                if (temp < result) { // 점수가 가장 낮은팀
                    result = temp;
                    fifthScore = fifth[key];
                    answer[i] = key;
                } else if (temp == result) { // 점수 동점, 5번째 점수 낮을때 우승
                    if (fifthScore > fifth[key]) {
                        answer[i] = key;
                    }
                }
            }
        }
        for(int j:answer){
            System.out.println(j);
        }
    }
}