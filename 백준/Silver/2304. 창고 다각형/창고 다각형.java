import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Main {
    static class Node{
        int x, y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        int arr[] = new int[1001];
        String str;
        int max_y = 0, L, H, max_L = 0, min_L = 1002;
        ArrayList <Integer> arrayList = new ArrayList<>(); //최댓값 여러개일 때 대비

        for(int i=1;i<=N;i++){
            str = bufferedReader.readLine(); //입력
            L = Integer.parseInt(str.split(" ")[0]);
            H = Integer.parseInt(str.split(" ")[1]);

            arr[L] = H;

            if(max_y < arr[L]){ //최고점 찾기
                max_y = arr[L];
                arrayList.clear();
                arrayList.add(L);
            } else if(max_y == arr[L]){
                //최고점 같을 경우
                arrayList.add(L);
            }

            max_L = Math.max(max_L, L); //x축 마지막
            min_L = Math.min(min_L, L); //x축 처음
        }

        Stack<Node> stack = new Stack<>();

        int area; //최고점 넓이
        Collections.sort(arrayList);
        
        int len = arrayList.size() - 1;
        if(arrayList.size() >= 2){ //최고점이 여러개일 경우
            area = (arrayList.get(len) - arrayList.get(0) + 1) * max_y; //최고점 중 x축 가장 큰 거에서 가장 작은거 빼고 * 높이
        } else{ //최고점 하나일 경우
            area = max_y;
        }

        //최고점 왼쪽
        stack.push(new Node(min_L, arr[min_L]));
        for(int i=min_L+1;i<=arrayList.get(0);i++){
            if(arr[i] > stack.peek().y){
                area += (i - stack.peek().x) * stack.peek().y;
                stack.pop();
                stack.push(new Node(i, arr[i]));
            }
        }
        stack.clear();

        //최고점 오른쪽
        stack.push(new Node(max_L, arr[max_L]));
        for(int i=max_L-1;i>=arrayList.get(len);i--){
            if(arr[i] > stack.peek().y){
                area += (stack.peek().x - i) * stack.peek().y;
                stack.pop();
                stack.push(new Node(i, arr[i]));
            }
        }
        System.out.println(area);
    }
}