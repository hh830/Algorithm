import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(bufferedReader.readLine());
        String str1[] = new String[input];
        String str2[][] = new String[input][50];
        int in_count = 0;
        int out_count = 0;
        String pass="";

        for(int i=0;i<input;i++){
            str1[i] = bufferedReader.readLine();
            str2[i] = str1[i].split("");
        }

        In:for(int i=0;i<input;i++){
            for(int j=0;j<str2[i].length;j++)
            {
                if (str2[i][j].equals("(")) {
                    in_count++;
                }
                else if (str2[i][j].equals(")"))
                {
                    if(in_count - out_count == 0) {
                        System.out.println("NO");
                        pass = "pass";
                        break;
                    }
                    else
                        out_count++;
                } else{
                    System.out.println("NO");
                    pass = "pass";

                    break;
                }
            }
            if(pass != "pass") {
                if ((in_count - out_count) == 0) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }

            in_count = 0;
            out_count = 0;
            pass = "";
        }

    }

}