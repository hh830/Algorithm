import java.util.*;

class Solution {
    public String solution(String s) {
        ArrayList <Integer> arr = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(s);
        StringBuilder sb = new StringBuilder();
        
        String answer = "";
        
        for(int i=0;st.hasMoreTokens();i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }
        
        Collections.sort(arr);
        
        sb.append(arr.get(0)).append(" ").append(arr.get(arr.size()-1));
        
        answer = sb.toString();
        
        return answer;
    }
}