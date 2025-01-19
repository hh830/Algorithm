
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        int N = Integer.parseInt(bufferedReader.readLine()); // 카드 수

        StringTokenizer stringTokenizer = new StringTokenizer(new StringBuilder(bufferedReader.readLine()).reverse().toString());
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(stringTokenizer.nextToken());

            if (num == 1) {
                // 1번 가장 앞
                deque.addFirst(i);
            } else if (num == 2) {
                // 2번 위에서 2번째
                int top = deque.removeFirst();
                deque.addFirst(i);
                deque.addFirst(top);
            } else {
                // 3번 맨 아래
                deque.addLast(i);
            }
        }

        while (deque.size() != 0) {
            stringBuilder.append(deque.removeFirst() + " ");
        }

        System.out.println(stringBuilder);
    }
}