import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int i=0;i<lost.length;i++){
            for(int j=0;j<reserve.length;j++){
                // 여벌 체육복이 있는데 도난당한 경우
                if(reserve[j] == lost[i]){
                    reserve[j] = -1;
                    lost[i] = -1;
                    answer++;
                    break;
                } 
            }
        }
        
        for(int i=0;i<lost.length;i++){
            for(int j=0;j<reserve.length;j++){
                if(reserve[j] == lost[i] - 1 && lost[i] - 1 > 0){
                    reserve[j] = -1;
                    answer++;
                    break;
                } else if(reserve[j] == lost[i] + 1 && lost[i] + 1 <= n){
                    reserve[j] = -1;
                    answer++;
                    break;
                }
            }
        }
              
        answer += n - lost.length;
        
        return answer;
    }
}