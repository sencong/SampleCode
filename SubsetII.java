package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,2,2};
		System.out.println(subsetsWithDup(a));
	}
	static List<List<Integer>> subsetsWithDup(int[] nums) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	   
	    //if(nums.length == 0){
	        //return result;
	    //}
	    
	    Arrays.sort(nums);
	    dfs(nums, 0, new ArrayList<Integer>(), result);
	    return result;
	    }

	    public static void dfs(int[] s, int index, List<Integer> path, List<List<Integer>> result){
	        result.add(new ArrayList<Integer>(path));
	    
	        for(int i = index; i < s.length; i++){
	            if(i>0&&i>index&&s[i]==s[i-1]) {
	                continue;
	            }
	            path.add(s[i]);
	            dfs(s, i+1, path, result);
	            path.remove(path.size()-1);
	        }
	    
	    }

}
