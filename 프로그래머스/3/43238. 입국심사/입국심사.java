import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long start = 0;
        int maxTime = Arrays.stream(times).max().getAsInt();
        
        long end = (long) maxTime * n; // 최악의 경우 - 가장 시간이 긴 심사관이 모두 심사
        
        while(start <= end) {
            long mid = (start + end) / 2;
            long cnt = 0;
            
            for(int time : times){
                cnt += mid / time;
            }
            
            if(cnt >= n){
                answer = mid;
                end = mid - 1;
            } else if(cnt < n){
                start = mid + 1;
            }
        }
        
        return answer;
    }
}