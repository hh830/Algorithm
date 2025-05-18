import java.util.*;

class Solution {
    public int solution(int[] citations) {                
        Arrays.sort(citations);
        
        int n = citations.length;
        
        for(int i=0;i<n;i++){
            int answer = n-i;
            if(citations[i] >= answer){
                return answer;
            }
        }
        
        return 0;
    }
}