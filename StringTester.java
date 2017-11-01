package test;

import java.util.ArrayList;

public class StringTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {9,9,9,8,9,8,7,9,8,8,8,9,8,9,8,8,6,9};
		System.out.println(partitionArray(a,9));
		
	}
	public static int partitionArray(int[] nums, int k) {
	    //write your code here
	    //if(nums ==null || nums.length==0) return 0;
	    int l = 0, r = nums.length-1,cur =0;
	    while(cur<=r){
	        if(nums[cur]<k){
	            while(r>l && nums[l]<k) l++;
	            swap(nums,l,cur);
	            l++;
	        } else {
	            while(r>l && nums[r]>=k) r--;
	            swap(nums,cur,r);
	            r--;
	        }
	        cur++;
	    }
	    return r+1;
    }
    static void swap(int[] nums,int l,int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

}
