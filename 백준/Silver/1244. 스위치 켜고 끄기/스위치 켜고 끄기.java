import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static int arr[]; // 각 스위치의 상태

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); //스위치 개수
        arr = new int[N+1];

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int M = Integer.parseInt(br.readLine()); // 학생의 수
        int student[][] = new int[M][2];
        String str;
        for(int i=0;i<M;i++){
            str = br.readLine();
            student[i][0] = Integer.parseInt(str.split(" ")[0]); //성별 남1 여2
            student[i][1] = Integer.parseInt(str.split(" ")[1]); //받은 수

            if(student[i][0] == 1){
                //남학생
                for(int j=N;j>=student[i][1];j--){
                    if(j % student[i][1] == 0){
                        //배수면
                        trans(j);
                    }
                }
            } else{
                //여학생
                int start = student[i][1];
                int end = student[i][1];
                trans(student[i][1]);

                while(start >= 2 && end <= N-1){
                    if(arr[start - 1] == arr[end + 1]){
                        trans(start - 1);
                        trans(end + 1);
                        start--;
                        end++;
                    } else{
                        break;
                    }
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i=1;i<=N;i++){
            stringBuilder.append(arr[i]).append(" ");
            if(i!=1 && i % 20 == 0){
                stringBuilder.append("\n");
            }
        }

        System.out.println(stringBuilder);

    }

    private static void trans(int num){ //스위치 상태 변환
        if(arr[num] == 0){
            arr[num] = 1;
        } else{
            arr[num] = 0;
        }
    }

}
