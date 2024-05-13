import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static String S;
    private static String T;
    private static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        S = bufferedReader.readLine();
        T = bufferedReader.readLine();

        if (!S.equals(T)) {
            method(T);
        } else {
            flag = true;
        }

        if (flag)
            System.out.println(1);
        else
            System.out.println(0);

    }

    private static void method(String str) {
        if (str.length() == S.length()) {
            if (str.equals(S)) {
                //재귀 끝
                flag = true;
            }
            return;
        } else {
            String str1 = "", str2 = "";

            if (str.charAt(0) == 'B') {
                String sub = str.substring(1);
                StringBuffer stringBuffer = new StringBuffer(sub);
                str2 = stringBuffer.reverse().toString();
                method(str2);
            }
            if (str.charAt(str.length() - 1) == 'A') {
                str1 = str.substring(0, str.length() - 1);
                method(str1);
            }

        }
    }
}
