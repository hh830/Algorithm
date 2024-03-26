import java.util.*;

class Solution {
    
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        HashMap <String, Integer> map = new HashMap();
        HashMap <Integer, String> rankMap = new HashMap();
        
        for(int i=0;i<players.length;i++){
            map.put(players[i], i);
            rankMap.put(i, players[i]);
        }

        int rank;
        String people;
        for(int i=0;i<callings.length;i++){
            rank = map.get(callings[i]);// 추월한 사람 현 랭크
            people = rankMap.get(rank-1); //바로 앞 사람
            
            map.put(people, rank);
            rankMap.put(rank, people);
            map.put(callings[i], rank-1);
            rankMap.put(rank-1, callings[i]);
        }
        
        for(int i:rankMap.keySet()){
            answer[i] = rankMap.get(i);
        }
        
        return answer;
    
    }
}

