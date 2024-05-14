import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            int alpha[] = new int[26];
            boolean flag = false;
            String str = bufferedReader.readLine();
            int K = Integer.parseInt(bufferedReader.readLine());

            if(K == 1){
                stringBuilder.append("1 1\n");
                continue;
            }

            for (int j = 0; j < str.length(); j++) {
                alpha[str.charAt(j) - 'a']++;
            }

            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);

                if (alpha[ch - 'a'] < K) {
                    continue;
                }
                int count = 1;

                for (int m = j + 1; m < str.length(); m++) {
                    if (str.charAt(j) == str.charAt(m)) {
                        count++;
                        if (count == K) {
                            min = Math.min(min, m - j + 1);
                            max = Math.max(max, m - j + 1);
                            flag = true;
                            break;
                        }
                    }
                }
            }

            if (flag) {
                stringBuilder.append(min).append(" ").append(max).append("\n");
            } else {
                stringBuilder.append("-1").append("\n");
            }
        }
        System.out.println(stringBuilder);
    }

}