package test;

public class StampDispenser {
	int[] stampDenominations;
    /**
     * Constructs a new StampDispenser that will be able to dispense the given 
     * types of stamps.
     *
     * @param stampDenominations The values of the types of stamps that the 
     *     machine should have.  Should be sorted in descending order and 
     *     contain at least a 1.
     */
    public StampDispenser(int[] stampDenominations)
    {
    	this.stampDenominations  = stampDenominations;
    }
 
    /**
     * Returns the minimum number of stamps that the machine can dispense to
     * fill the given request.
     *
     * @param request The total value of the stamps to be dispensed.
     */
    public int calcMinNumStampsToFillRequest(int request)
    {  
    	int[] dp = new int[request];
    	for(int i:stampDenominations){
    		if(i>request) continue;
    		dp[i-1] = 1;
    		for(int j = i;j<request;j++){
//    			if(dp[j-i] != 0)
//    				dp[j] =dp[j]==0?dp[j-i]+1:Math.min(dp[j-i]+1,dp[j]);
    			if(dp[j-i] != 0)
    				dp[j] =dp[j]==0?dp[j-i]+1:Math.min(dp[j-i]+1,dp[j]);
    		}
    	}
        return dp[request-1];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] denominations = { 90, 30, 24, 10, 6, 2, 1 };
        StampDispenser stampDispenser = new StampDispenser(denominations);
        assert stampDispenser.calcMinNumStampsToFillRequest(18) == 3;
        stampDispenser.calcMinNumStampsToFillRequest(21);
        stampDispenser.calcMinNumStampsToFillRequest(7);
        stampDispenser.calcMinNumStampsToFillRequest(0);
        denominations = new int[]{ 5, 2, 1 };
        stampDispenser.calcMinNumStampsToFillRequest(11);
	}

}
