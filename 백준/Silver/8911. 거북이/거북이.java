import java.io.*;
import java.util.*;

public class Main {

    private static int maxLeft;
    private static int maxRight;
    private static int maxUp;
    private static int maxDown;
    private static Node now;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            char[] arr = bufferedReader.readLine().toCharArray();

            now = new Node(0, 0, 0); // 방향 0:북, 1:동, 2:남, 3:서
            maxLeft = 0;
            maxRight = 0;
            maxUp = 0;
            maxDown = 0;

            for (char c : arr) {
                move(c);
            }

            int width = maxRight - maxLeft;
            int height = maxUp - maxDown;
            System.out.println(width * height);
        }
    }

    private static void move(char ch) {
        if (ch == 'F') {
            go(1);
        } else if (ch == 'B') {
            go(-1);
        } else if (ch == 'L') {
            now.d = (now.d + 3) % 4;
        } else if (ch == 'R') {
            now.d = (now.d + 1) % 4;
        }
    }

    private static void go(int step) {
        // 북 동 남 서
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        now.x += dx[now.d] * step;
        now.y += dy[now.d] * step;

        maxLeft = Math.min(maxLeft, now.x);
        maxRight = Math.max(maxRight, now.x);
        maxDown = Math.min(maxDown, now.y);
        maxUp = Math.max(maxUp, now.y);
    }

    static class Node {
        int x, y, d;

        Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
