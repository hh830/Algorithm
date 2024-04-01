import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken()); //식탁의 거리
        int K = Integer.parseInt(stringTokenizer.nextToken()); //햄버거를 선택할 수 있는 거리

        String str = bufferedReader.readLine();
        String arr[] = str.split("");

        int count = 0;
        boolean go;
        for (int i = 0; i < N; i++) {
            if (arr[i].equals("P")) {
                go=true;

                for (int j = K; j >= 1; j--) {
                    if (i - j < 0) {
                        continue;
                    } else {
                        if (arr[i - j].equals("H")) {
                            arr[i - j] = "";
                            count++;
                            go = false;
                            break;
                        }
                    }
                    go = true;
                }

                if(go) {
                    for (int j = 1; j <= K; j++) {
                        if (i + j >= N) {
                            break;
                        } else {
                            if (arr[i + j].equals("H")) {
                                arr[i + j] = "";
                                count++;

                                break;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }
}