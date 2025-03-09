class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int dp[][] = new int[m][n];
        dp[0][0] = 1;

        for(int [] puddle : puddles){
            dp[puddle[0] - 1][puddle[1] - 1] = -1; // 물구멍 초기화
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i == 0 && j == 0){ // 둘다 0
                    continue;
                }
            
                if(dp[i][j] == 0){
                    // 물 구멍이 아닌 경우
                    if(i != 0 && dp[i-1][j] != -1){
                        // 인덱스 범위 안이고, 물구덩이 아닌 경우
                        dp[i][j] += dp[i-1][j];
                    }
                    if(j != 0 && dp[i][j-1] != -1) {
                        // 인덱스 범위 안이고, 물구덩이 아닌 경우
                        dp[i][j] += dp[i][j-1];
                    }
                    dp[i][j] %= 1000000007;
                }
            }
        }
        
        answer = dp[m-1][n-1];
        return answer;
    }
}