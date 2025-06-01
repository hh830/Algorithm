import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static int[][] arr = new int[5][5];
    static boolean[][] visit = new boolean[5][5];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // 빙고판 입력
        for (int i = 0; i < 5; i++) {
            String str = bufferedReader.readLine();
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(str.split(" ")[j]);
            }
        }

        int count = 0;
        for (int i = 0; i < 5; i++) {
            String str = bufferedReader.readLine();

            for (int j = 0; j < 5; j++) {
                count++;
                int number = Integer.parseInt(str.split(" ")[j]);
                markNumber(number);
                if (count >= 12 && checkBingo() >= 3) {
                    System.out.println(count);
                    return;
                }
            }
        }
    }

    static void markNumber(int num) {
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                if (arr[i][j] == num)
                    visit[i][j] = true;
    }

    static int checkBingo() {
        int bingo = 0;

        // 가로줄
        for (int i = 0; i < 5; i++) {
            boolean end = true;
            for (int j = 0; j < 5; j++) {
                if (!visit[i][j]) {
                    end = false;
                    break;
                }
            }
            if (end) bingo++;
        }

        // 세로줄
        for (int j = 0; j < 5; j++) {
            boolean end = true;
            for (int i = 0; i < 5; i++) {
                if (!visit[i][j]) {
                    end = false;
                    break;
                }
            }
            if (end) bingo++;
        }

        // 대각선 
        boolean end = true;
        for (int i = 0; i < 5; i++) {
            if (!visit[i][i]) {
                end = false;
                break;
            }
        }
        if (end) bingo++;

        end = true;
        for (int i = 0; i < 5; i++) {
            if (!visit[i][4 - i]) {
                end = false;
                break;
            }
        }
        if (end) bingo++;

        return bingo;
    }
}
