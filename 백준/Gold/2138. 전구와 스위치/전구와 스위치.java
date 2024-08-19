import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    private static char light[], goal[], arr1[], arr2[]; // 전구 전, 후  // 첫번째 스위치 on, off
    private static int count1 = 1, count2 = 0, N;


    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());

        String str = bufferedReader.readLine();
        light = str.toCharArray();
        goal = bufferedReader.readLine().toCharArray();

        arr1 = new char[N];
        arr2 = new char[N];

        for(int i=0;i<N;i++){
            if(i <= 1){
                arr1[i] = change(light[i]); // 스위치 on
                arr2[i] = light[i];
            } else{
                arr1[i] = light[i];
                arr2[i] = light[i];
            }
        }

        for(int i=1;i<N;i++){
            if(arr1[i-1] != goal[i-1]){
                // 이전 전구 다르면 i번 스위치 on
                onSwitch(i, arr1);
                count1++;
            }

            if(arr2[i-1] != goal[i-1]){
                onSwitch(i, arr2);
                count2++;
            }
        }

        boolean flag = false;
        if(Arrays.equals(arr1, goal)){
            flag = true;
            if(Arrays.equals(arr1, arr2)){
                System.out.println(Math.min(count1, count2));
            } else{
                System.out.println(count1);
            }
        } else if(Arrays.equals(arr2, goal)){
            flag = true;
            System.out.println(count2);
        }

        if(!flag){
            System.out.println(-1);
        }
    }

    private static void onSwitch(int index, char arr[]){
        arr[index-1] = change(arr[index-1]);
        arr[index] = change(arr[index]);

        if(index < N-1)
            arr[index+1] = change(arr[index+1]);
    }

    private static char change(char ch){
        if(ch == '1'){
            return '0';
        } else {
            return '1';
        }
    }
}