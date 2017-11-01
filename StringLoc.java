package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringLoc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s ="CITADEL";
		List<String> list = combinations(s);
		System.out.println(Search(list,s));
		
	}
	static int Search(List<String> a,String b){
		Collections.sort(a);
		return Collections.binarySearch(a, b)+1;
	}
	static List<String> combinations(String str){
		char[] characters = str.toCharArray();
		Arrays.sort(characters);
		StringBuilder sb = new StringBuilder();
		List<String> res = new ArrayList<String>();
		int len = characters.length;
		backtrack(res,sb,characters,new boolean[len]);
		return res;
	}
	static void backtrack(List<String> list, StringBuilder sb, char [] nums, boolean [] used){
	    if(sb.length() == nums.length){
	        list.add(sb.toString());
	    } else{
	        for(int i = 0; i < nums.length; i++){
	            if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
	            used[i] = true; 
	            sb.append(nums[i]);
	            backtrack(list, sb, nums, used);
	            used[i] = false; 
	            sb.deleteCharAt(sb.length() - 1);
	        }
	    }
	}

}
