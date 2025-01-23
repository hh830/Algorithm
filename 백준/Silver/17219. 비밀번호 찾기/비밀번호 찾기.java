import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken()); // 저장된 사이트 주소 수 N
        int M = Integer.parseInt(stringTokenizer.nextToken()); // 비밀번호 찾으려는 사이트 주소 수 M

        Map<String, String> map = new HashMap<>();

        for(int i=0;i<N;i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            map.put(stringTokenizer.nextToken(), stringTokenizer.nextToken());
        }

        StringBuilder stringBuilder = new StringBuilder();

        for(int j=0;j<M;j++){
            String findText = bufferedReader.readLine();
            stringBuilder.append(map.get(findText)).append("\n");
        }

        System.out.println(stringBuilder);
    }
}