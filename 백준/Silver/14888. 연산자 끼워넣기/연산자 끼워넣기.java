import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int op[] = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int N, arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine()); // 수의 개수

        arr = new int[N];
        String str = bufferedReader.readLine();
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(str.split(" ")[i]); // 수열
        }

        str = bufferedReader.readLine();
        for(int i=0;i<4;i++){
            op[i] = Integer.parseInt(str.split(" ")[i]); // 연산자 수 덧셈, 뺄셈, 곱셈, 나눗셈
        }

        method(arr[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    static void method(int n, int index){
        if(index == N){
            min = Math.min(min, n);
            max = Math.max(max, n);
            return;
        }

        for(int i=0;i<4;i++){
            if(op[i] > 0) {
                op[i]--;

                switch (i) {
                    case 0:
                        method(n + arr[index], index+1);
                        break;
                    case 1:
                        method(n - arr[index], index+1);
                        break;
                    case 2:
                        method(n * arr[index], index+1);
                        break;
                    case 3:
                        method(n / arr[index], index+1);
                        break;
                }
                op[i]++;
            }
        }
    }
}
