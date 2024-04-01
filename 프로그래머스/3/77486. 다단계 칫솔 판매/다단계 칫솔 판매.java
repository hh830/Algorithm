import java.util.*;
class Solution {
    private static Map<String, String> people = new HashMap<>();
    private static Map<String, Integer> incomes = new HashMap<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int []answer = new int[enroll.length];
        
        for(int i=0;i<enroll.length;i++){
            people.put(enroll[i], referral[i]);
        }
        for(int i=0;i<seller.length;i++){
            method(seller[i], amount[i] * 100);
        }
        for(int i=0;i<enroll.length;i++){
            answer[i] = incomes.getOrDefault(enroll[i], 0);
        }
        return answer;
        
        
    }
    private static void method(String name, int amount){
        if(name.equals("-") || amount == 0){
            return;
        }
        int share = amount/10;
        incomes.put(name, incomes.getOrDefault(name, 0) + amount - share);
        method(people.get(name), share);
    }
        
}
