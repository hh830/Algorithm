import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        int[] arr = new int[N];
        int sum = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bufferedReader.readLine());
            sum += arr[i];
        }
        
        Arrays.sort(arr);

        // 산술평균
        int mean = (int) Math.round((double) sum / N);

        // 중앙값
        int mid = arr[N / 2];

        // 최빈값
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            max = Math.max(max, map.get(num));
        }

        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }
        Collections.sort(list);
        int fre = (list.size() > 1) ? list.get(1) : list.get(0);

        // 범위
        int range = arr[N - 1] - arr[0];

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(mean).append("\n");
        stringBuilder.append(mid).append("\n");
        stringBuilder.append(fre).append("\n");
        stringBuilder.append(range).append("\n");

        System.out.println(stringBuilder);
    }
}
