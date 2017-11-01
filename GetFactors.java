package test;
import java.util.*;

public class GetFactors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getFactors(12));
	}
	public static List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(result, new ArrayList<Integer>(), n, 2);
        return result;
    }

    public static void helper(List<List<Integer>> result, List<Integer> item, int n, int start){
        if (n <= 1) {
            if (item.size() > 1) {
                result.add(new ArrayList<Integer>(item));
            }
            return;
        }
    
        for (int i = start; i <= Math.sqrt(n); ++i) {
//            if(i>Math.sqrt(n)) i =n;
            if (n % i == 0) {
                item.add(i);
                helper(result, item, n/i, i);
                item.remove(item.size()-1);
            }
        }
    }

}
