package test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Hello {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {0};
		sortColors(A);
		System.out.println(A);
		
	}
	public static void sortColors(int[] nums) {
        int cut1 =0, cut2 = nums.length-1,i=0;
        while(i<=cut2){
            if(nums[i] == 0){
                swap(nums,cut1,i);
                cut1++;
            } else if(nums[i]==1){
                i++;
            } else if(nums[i]==2){
                swap(nums,cut2,i);
                cut2--;
            }
        }
    }
    static void swap(int[] A,int i,int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] =temp;
    }
	
}
