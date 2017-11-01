package test;
import java.util.*;
public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,3,3,2,4};
		if (nums == null || nums.length < 3)
            System.out.println("true, over");
		boolean flag1 = false,flag2 = false;
        for (int i = 1; i< nums.length - 1; i++) {
            if (nums[i] < nums[i-1]) {
                if ((i >=2 && nums[i] < nums[i-2]) || flag1)
                	System.out.println("false, over");
                else {
                    flag1 = true;
                }
            }
            if (nums[i] > nums[i+1]) {
                if ((i < nums.length - 2 && nums[i] > nums[i + 2]) || flag2)
                	System.out.println("false, over");
                else {
                    flag2 = true;
                }
            }
        }
        System.out.println("true, over");

	}

}
