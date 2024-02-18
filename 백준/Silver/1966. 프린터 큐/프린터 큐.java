import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); //테스트 케이스 수
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < T; i++) {
            
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(stringTokenizer.nextToken()); // 문서의 개수
            int M = Integer.parseInt(stringTokenizer.nextToken()); // 큐에서 몇번째에 놓여있는지

            LinkedList<int[]> q = new LinkedList<>();
            
            stringTokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; stringTokenizer.hasMoreTokens(); j++) {
                q.add(new int[]{j, Integer.parseInt(stringTokenizer.nextToken())});
            }

            int count = 0;

            while (!q.isEmpty()) {
                int[] temp = q.poll();
                boolean check = true;

                for (int j = 0; j < q.size(); j++) {
                    if (temp[1] < q.get(j)[1]) {
                        q.add(temp);

                        for (int k = 0; k < j; k++)
                            q.add(q.poll());

                        check = false;
                        break;
                    }
                }

                if (check == false)
                    continue;

                count++;

                if (temp[0] == M)
                    break;

            }

            stringBuilder.append(count).append("\n");

        }
        System.out.println(stringBuilder);

    }


}



