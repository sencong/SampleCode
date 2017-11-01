package test;

public class EditDist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minDistance("texture","uexte"));
	}
	public static int minDistance(String word1, String word2) {
        if(word1 == word2) return 0;
        int len1 = word1.length();
        int len2 = word2.length();
        int[] dp = new int[len2+1];
        
        for(int i=0;i<=len2;i++)
            dp[i] = i;
        
        for(int i=1;i<=len1;i++){
            int pre = i;
//            dp[0] = i;
            for(int j=1;j<=len2;j++){
                int cur;
                if(word1.charAt(i-1)==word2.charAt(j-1)) cur = dp[j-1];
                else{
                    cur = Math.min(dp[j],Math.min(dp[j-1],pre))+1;
                }
                dp[j-1] = pre;
                pre = cur;
            }
            dp[len2] = pre;
        }
        return dp[len2];
    }

}
