import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        
        StringTokenizer str = new StringTokenizer(bufferedReader.readLine());

        Stack<Top> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            int height = Integer.parseInt(str.nextToken());

            while (!stack.isEmpty()) {
                if (stack.peek().height <= height) {
                    // 작으면 pop
                    stack.pop();
                } else {
                    // 아니면 결과에 추가
                    stringBuilder.append(stack.peek().num).append(" ");
                    break;
                }
            }

            if (stack.isEmpty()) {
                stringBuilder.append(0).append(" ");
            }
            stack.push(new Top(i, height));
        }

        System.out.println(stringBuilder);
    }
}

class Top{
    int num;
    int height;

    public Top(int num, int height) {
        this.num = num;
        this.height = height;
    }
}