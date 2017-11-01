package test;
import java.util.*;

public class CombinationalSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = {10, 1, 2, 7, 6, 1, 5};
		combinationSum2(candidates,8);
	}
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0)
            return res;
        Arrays.sort(candidates);
        helper(res,candidates, new ArrayList<>(), 0 , target);
        return res;
    }
    static void helper(List<List<Integer>> res,int[] candidates, List<Integer> path, int index,int target){
        if(index == candidates.length && target ==0){
            res.add(new ArrayList<Integer>(path));
        }
            
        for(int i = index; i< candidates.length;i++){
            if(candidates[i] > target)
                break;
            if(i > index && candidates[i] == candidates[i-1])
                continue;
            path.add(candidates[i]);
            helper(res,candidates,path,i + 1, target - candidates[i]);
            path.remove(path.size()-1);
        }
    }

}
