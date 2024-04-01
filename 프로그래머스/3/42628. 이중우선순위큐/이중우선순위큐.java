import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue <Integer> priorityQueue1 = new PriorityQueue<>(); //작은 순
        PriorityQueue <Integer> priorityQueue2 = new PriorityQueue<>(Collections.reverseOrder()); // 큰 순

        String str;
        int input=0, max = 0, min = 0;
        for(int i=0;i<operations.length;i++){
            str = operations[i].split(" ")[0];
            input = Integer.parseInt(operations[i].split(" ")[1]);

            if(str.equals("I"))
            {
                priorityQueue1.add(input);
                priorityQueue2.add(input);
            } else if(str.equals("D") && !priorityQueue1.isEmpty()){
                if(input == 1){
                    //큐에서 최댓값 삭제
                    max = priorityQueue2.peek();
                    priorityQueue2.remove();
                    priorityQueue1.remove(max);
                } else if(input == -1){
                    //큐에서 최솟값 삭제
                    min = priorityQueue1.peek();
                    priorityQueue1.remove();
                    priorityQueue2.remove(min);
                }
            }
        }
        int[] answer = new int[2];
        if(priorityQueue1.isEmpty() && priorityQueue2.isEmpty()){
            answer[0] = 0;
            answer[1] = 0;
        } else{
            answer[0] = priorityQueue2.peek();
            answer[1] = priorityQueue1.peek();
        }
        return answer;
    }
    
}