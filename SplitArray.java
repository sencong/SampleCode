package test;

public class SplitArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {7,2,5,10,8};
		System.out.println(splitArray(a,2));
	}
	public static int splitArray(int[] nums, int m) {
        int left = 0, right = 0;
        for(int num:nums){
            left = Math.max(left,num);
            right += num;
        }
        while(left < right){
            int mid = left + (right-left)/2;
            if(canSplit(nums,mid, m)){
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
        
    }
    static boolean canSplit(int[] nums, int minSum, int segments){
        int seg = 1, cursor = 0, curSum = 0;
        while(cursor<nums.length){
        	curSum += nums[cursor];
            if(curSum > minSum){
                seg++;
                if(seg > segments) return false;
                curSum = nums[cursor];
            }
            cursor ++;
        }
        return true;
    }

}
