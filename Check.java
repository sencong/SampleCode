package test;

import java.util.HashMap;
import java.util.Map;

public class Check {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int runningSum = 0;
        for (int i=0;i<nums.length;i++) {
            runningSum += nums[i];
            if (k != 0) {
                runningSum %= k; 
            }
            // Integer prev = map.get(runningSum);
            // if (prev != null ) {
            //     if(i-prev >1)
            //         return true;
            // } else {
            //     map.put(runningSum, i);
            // }
             int t = i;
             int temp = map.compute(runningSum,(key,value)->(value==null)?t:value);
             if(i-temp>1) 
                 return true;
//            if(map.containsKey(runningSum)){
//                if(i-map.get(runningSum)>1)
//                    return true;
//            } else {
//                map.put(runningSum,i);
//            }
        }
        return false;
    }

}
