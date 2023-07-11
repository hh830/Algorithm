import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;



// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static ArrayList<String> arrayList=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        String str;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();
        int m=Integer.parseInt(N);
        for(int i=0;i<m;i++){
            str= br.readLine();

            String[] ArrayStr=str.split(" ");
            if(ArrayStr.length==2)
            {
                push(ArrayStr);
            }
            else
            {
                switch (ArrayStr[0])
                {
                    case "top":
                        String top_result=top();
                        System.out.println(top_result);
                        break;
                    case "size":
                        System.out.println(arrayList.size());
                        break;
                    case "empty":
                        if(arrayList.isEmpty()==true)
                        {
                            System.out.println("1");
                        }
                        else{
                            System.out.println("0");
                        }
                        break;
                    case "pop":
                        String pop_result=pop();
                        System.out.println(pop_result);
                        break;
                    default:
                        System.out.println("잘못 입력");
                        break;
                }
            }
        }
    }

    private static void push(String[] array){
        arrayList.add(array[1]);
    }

    private static String top(){ //가장 위에 있는 정수 출력
        int size=arrayList.size();
        String result="";
        if(size>0)
        {
            result=arrayList.get(size-1);
        }
        else
        {
            result="-1";
        }
        return result;
    }
    private static String pop(){ //가장 위 정수 빼고 그 수 출력
        int size=arrayList.size();
        String result="";
        if(size>0){
            result=arrayList.get(size-1);
            arrayList.remove(size-1);
        }
        else{
            result="-1";
        }

        return result;
    }
}