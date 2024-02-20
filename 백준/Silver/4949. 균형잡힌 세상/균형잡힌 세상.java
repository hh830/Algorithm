import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[];
        StringBuilder stringBuilder = new StringBuilder();

        Stack<String> stack = new Stack<>();

        b: while (true) {
            str = br.readLine().split("");

            if (str[0].equals(".") && str.length == 1) {
                break b;
            }
            else {
                a : for (int i = 0; i < str.length; i++) {
                    if (str[i].equals("(") || str[i].equals("[")) {
                        stack.push(str[i]);
                    } else if (str[i].equals(")")) {
                        if (!stack.isEmpty() && stack.peek().equals("(")) {
                            stack.pop();
                        } else {
                            stringBuilder.append("no").append("\n");
                            stack.clear();

                            break a;
                        }
                    } else if (str[i].equals("]")){
                        if (!stack.isEmpty() && stack.peek().equals("[")) {
                            stack.pop();
                        } else {
                            stringBuilder.append("no").append("\n");
                            stack.clear();

                            break a;
                        }
                    } else if (str[i].equals(".")){
                        if(stack.isEmpty()){
                            stringBuilder.append("yes").append("\n");
                            break a;
                        } else{
                            stringBuilder.append("no").append("\n");
                            stack.clear();
                            break a;
                        }
                    }
                }
            }
        }

        System.out.println(stringBuilder);
    }


}



