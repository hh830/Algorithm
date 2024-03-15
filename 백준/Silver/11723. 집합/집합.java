import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer;

        int M = Integer.parseInt(bufferedReader.readLine());
        String str = "";
        int x = 0, bitMask = 0;

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            str = stringTokenizer.nextToken();

            if(stringTokenizer.hasMoreTokens())
                x = Integer.parseInt(stringTokenizer.nextToken());

            switch (str) {
                case "add":
                    bitMask = bitMask | 1 << (x-1);
                    break;

                case "remove":
                    bitMask = bitMask & ~(1 << (x - 1));
                    break;
                case "check":
                    stringBuilder.append(((bitMask & 1 << (x-1)) == 1 << (x-1) ? 1 : 0) + "\n");
                    break;
                case "toggle":
                    bitMask = bitMask ^ 1 << (x-1);
                    break;
                case "all":
                    bitMask = ~0;
                    break;
                case "empty":
                    bitMask = 0;
                    break;
            }
        }

        System.out.println(stringBuilder);
    }

}