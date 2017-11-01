package test;
import java.util.*;

public class MergeSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1,0};
		int[] nums2 = {2};
		merge(nums1,1,nums2,1);
		
	}
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int cursor1 = m - 1, cursor2 = n - 1, cur = m+n-1;
        while(cursor1 >=0 || cursor2 >=0 ){
            if(cursor1 >=0 && cursor2 >=0){
                if(nums1[cursor1] >= nums2[cursor2]){
                    nums1[cur--] = nums1[cursor1--];
                } else {
                    nums1[cur--] = nums1[cursor2--];
                }
                    
            } else if(cursor1 >=0){
                nums1[cur--] = nums1[cursor1--];
            } else {
                nums1[cur--] = nums2[cursor2--];
            }
        }
    }

}
