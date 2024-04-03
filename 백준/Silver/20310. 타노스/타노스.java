import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        String s = bufferedReader.readLine();
        String arr[] = s.split("");
        int num0=0, num1=0;

        for(int i=0;i<arr.length;i++){
            if(arr[i].equals("1")){
                num1++;
            } else{
                num0++;
            }
        }

        int total0 = num0/2;
        int total1 = num1/2;

        //앞에서
        for(int i=0;i<arr.length;i++){
            if(total1 == 0){
                break;
            }
            if(arr[i].equals("1"))
            {
                arr[i] = "-1";
                total1--;
            }
        }

        //뒤에서
        for(int i=arr.length-1;i>=0;i--){
            if(total0 == 0){
                break;
            }
            if(arr[i].equals("0")){
                arr[i] = "-1";
                total0--;
            }

        }

        for(int i=0;i<arr.length;i++){
            if(!arr[i].equals("-1")){
                stringBuilder.append(arr[i]);
            }
        }

        System.out.println(stringBuilder);

    }
}