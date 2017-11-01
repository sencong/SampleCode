package test;
import java.util.*;

public class Differentways {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "2-1-1";
		System.out.println(diffWaysToCompute(s));
	}
    public static List<Integer> diffWaysToCompute(String input) {
    	return dfs(input, new HashMap<>());
    }
    static List<Integer> dfs(String input, Map<String, List<Integer>> map){
        if(map.containsKey(input))
            return map.get(input);
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < input.length(); ++i){
            char cur = input.charAt(i);
            if(cur == '+' || cur == '-'|| cur == '*'){
                String left = input.substring(0,i), right = input.substring(i+1);
                List<Integer> leftResult = dfs(left, map);
                List<Integer> rightResult = dfs(right, map);
                for(int l : leftResult){
                    for(int r : rightResult){
                        
                        switch(cur){
                            case '+': 
                                res.add(l+r);
                                break;
                            case '-':
                                res.add(l-r);
                                break;
                            case '*':
                                res.add(l*r);
                        }
                    }
                }
            }
        }
        if(res.isEmpty())
            res.add(Integer.parseInt(input));
 
        map.put(input,res);
        return res;
    }

}
