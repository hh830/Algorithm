import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        int n = Integer.parseInt(bufferedReader.readLine());
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String input = bufferedReader.readLine();

            if (input.startsWith("push")) {
                int x = Integer.parseInt(input.split(" ")[1]);
                queue.offer(x);
            } else if (input.equals("pop")) {
                stringBuilder.append(queue.isEmpty() ? -1 : queue.poll()).append("\n");
            } else if (input.equals("size")) {
                stringBuilder.append(queue.size()).append("\n");
            } else if (input.equals("empty")) {
                stringBuilder.append(queue.isEmpty() ? 1 : 0).append("\n");
            } else if (input.equals("front")) {
                stringBuilder.append(queue.isEmpty() ? -1 : queue.peek()).append("\n");
            } else if (input.equals("back")) {
                stringBuilder.append(queue.isEmpty() ? -1 : queue.peekLast()).append("\n");
            }
        }

        System.out.print(stringBuilder);
    }
}
