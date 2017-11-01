package test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class sen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {4,5,6,7,0,1,2};
		System.out.println(search(a,0));
	}
	public static int search(int[] nums, int target) {
        int start = 0, end = nums.length -1 ;
        if(start > end)
            return -1;
        while(start + 1 < end){
            int mid = start + (end- start) >> 1;
            if(nums[mid] == target)
                return mid;
            if(nums[start] < nums[mid]){
                if(nums[mid] > target && nums[start] <= target){
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if(nums[mid] < target && nums[end] >= target){
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if(nums[start] == target){
            return start;
        } 
        if(nums[end] == target){
            return end;
        }
        return -1;
    }

}