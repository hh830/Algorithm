import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";

        StringBuilder stringBuilder = new StringBuilder();

        a: while (true) {
            int count1 = 0; //모음

            str = br.readLine();
            String arr[] = new String[20];

            if(str.equals("end")){
                System.out.println(stringBuilder);
                break;
            }

            for (int i = 0; i < str.length(); i++) {
                arr[i] = str.split("")[i];

                //모음 포함하는지
                if (isMoem(arr[i])) {
                    count1++;
                }


                //모음3개, 자음3개 연속으로 오면 안된다
                if (i >= 2) {
                    if (isMoem(arr[i]) && isMoem(arr[i - 1]) && isMoem(arr[i - 2])) {
                        // 모음 3개
                        stringBuilder.append("<").append(str).append("> ").append("is not acceptable.\n");
                        continue a;
                    } else if(!isMoem(arr[i]) && !isMoem(arr[i-1]) && !isMoem(arr[i-2])){
                        // 자음 3개
                        stringBuilder.append("<").append(str).append("> ").append("is not acceptable.\n");
                        continue a;
                    }
                }

                //같은 글자가 연속적으로 두번 오면 안되나 ee와 oo는 허용한다.
                if(i >= 1){
                    if(arr[i].equals(arr[i-1])){
                        if(!arr[i].equals("e") && !arr[i].equals("o"))
                        {
                            stringBuilder.append("<").append(str).append("> ").append("is not acceptable.\n");
                            continue a;
                        }

                    }
                }
            }
            if(count1 == 0){
                stringBuilder.append("<").append(str).append("> ").append("is not acceptable.\n");
            } else{
                stringBuilder.append("<").append(str).append("> ").append("is acceptable.\n");
            }

        }

    }

    static boolean isMoem(String s) {
        if (s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u")) {
            return true;
        } else {
            return false;
        }
    }

}
