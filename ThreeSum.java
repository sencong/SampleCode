package test;
import java.util.*;

public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] tests = {{-1, 0, 1, 2, -1, -4}};
		for(int[] test:tests){
			System.out.println(test);
			System.out.println(threeSum(test));
		}

	}
//	public static List<List<Integer>> threeSum(int[] nums){
//		List<List<Integer>> res = new ArrayList<>();
//		if(nums == null ||nums.length ==0) return res;
//		Set<Integer> set = new HashSet<>();
//		for(int num : nums){
//			set.add(num);
//		}
//		ArrayList<Integer> numList = new ArrayList<>(set);
//		Collections.sort(numList);
//		for(int i = 0;i<numList.size();i++){
//			int left = i, right = numList.size()-1;
//			while(left <= right){
//				int sum = numList.get(i) + numList.get(left) + numList.get(right);
//				if(sum == 0){
//					res.add(Arrays.asList(numList.get(i) , numList.get(left) , numList.get(right)));
//					left++;
//					right--;
//				} else if(sum > 0){
//					right--;
//				} else {
//					left++;
//				}
//			}
//		}
//		return res;
//	}
	public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return res;
        Arrays.sort(nums);
        for (int i = 0; i< nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int target = - nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target)
                    res.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                else if (nums[left] + nums[right] < target)
                    left ++;
                else
                    right --;
            }
        }
        return res;
    }

}
