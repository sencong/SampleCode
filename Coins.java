package test;

import java.util.Arrays;

public class Coins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = {1,Integer.MAX_VALUE};
		System.out.println(coinChange(coins,2));
	}
	public static int coinChange(int[] coins, int amount) {
	    //   if(amount<1) return 0;
	    //     return helper(coins, amount, new int[amount]);
	    // }
	    // private int helper(int[] coins, int rem, int[] count) { // rem: remaining coins after the last step; count[rem]: minimum number of coins to sum up to rem
	    //     if(rem<0) return -1; // not valid
	    //     if(rem==0) return 0; // completed
	    //     if(count[rem-1] != 0) return count[rem-1]; // already computed, so reuse
	    //     int min = Integer.MAX_VALUE;
	    //     for(int coin : coins) {
	    //         int res = helper(coins, rem-coin, count);
	    //         if(res>=0 && res < min)
	    //             min = 1+res;
	    //     }
	    //     count[rem-1] = (min==Integer.MAX_VALUE) ? -1 : min;
	    //     return count[rem-1];
	        if(amount==0) return 0;
	        Arrays.sort(coins);
	        int len = coins.length;
	        for(int i =0;i<len/2;i++){
	            swap(coins,i,len-i-1);
	        }
	        int[] dp = new int[amount];
	    	for(int i:coins){
	    		if(i>amount) continue;
	    		dp[i-1] = 1;
	    		for(int j = i;j<amount;j++){
	    			if(dp[j]==0 && dp[j-i] != 0)
	    				dp[j] = dp[j-i]+1;
	    		}
	    	}
	        return dp[amount-1];
	    }
	    static void swap(int[] A,int i,int j){
	        int temp = A[i];
	        A[i] = A[j];
	        A[j] = A[i];
	    }

}
