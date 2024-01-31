import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine()); //명령의 수
        String str;
        Deque<Integer>integerDeque = new ArrayDeque<>();

        for(int i=0;i<N;i++){
            str = bufferedReader.readLine();

            if(str.split(" ").length == 2){
                //push_back num or push_front num
                if(str.split(" ")[0].equals("push_back"))
                {
                    //back
                    integerDeque.addLast(Integer.parseInt(str.split(" ")[1]));
                } else{
                    // front
                    integerDeque.addFirst(Integer.parseInt(str.split(" ")[1]));
                }
            } else {
                switch (str){
                    case "size":
                        System.out.println(integerDeque.size());
                        break;

                    case "empty":
                        if(integerDeque.isEmpty())
                            System.out.println(1);
                        else
                            System.out.println(0);
                        break;

                    default:
                        if (!integerDeque.isEmpty()){
                            switch (str) {
                                case "pop_front":
                                    System.out.println(integerDeque.removeFirst());
                                    break;

                                case "pop_back":
                                    System.out.println(integerDeque.removeLast());
                                    break;

                                case "front":
                                    System.out.println(integerDeque.getFirst());
                                    break;

                                case "back":
                                    System.out.println(integerDeque.getLast());
                                    break;
                            }
                        } else
                            System.out.println(-1);
                        break;
                }

            }
        }

    }
}