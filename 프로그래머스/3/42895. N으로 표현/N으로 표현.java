import java.util.*;


public class Solution {
    public static int solution(int N, int number) {
    	List<HashSet<Integer>> list=  new ArrayList<HashSet<Integer>>();
        
        for(int i=0; i<=8; i++)
        	list.add(new HashSet<Integer>()); // 초기화
        list.get(1).add(N); // 첫번째
        
        if(number==N) 
            return 1;
        
        for(int i=2; i<=8; i++) {
        	HashSet<Integer> total = list.get(i);
        	
        	// 3이라면 (1 + 2), (2 + 1) 
        	for(int j=1; j<i; j++) {
        		HashSet<Integer> a = list.get(j);
        		HashSet<Integer> b = list.get(i-j);
        		
        		for(int x:a) {
        			for(int y:b) {
        				total.add(x+y);
        				total.add(x-y);
        				total.add(x*y);
        				if(x!=0 && y!=0) total.add(x/y);
        			}
        		}
        		// 같은숫자 반복
        		total.add(Integer.parseInt(String.valueOf(N).repeat(i)));
        	}
        	
        	// number 수가 있다면 반환
        	if(total.contains(number)) return i;
        }
        
        return -1;
    }
}