package test;

import java.util.ArrayList;
import java.util.List;

public class Local {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num = "00";
		
		System.out.println(addOperators(num, 0));
	}
	public static List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if(num == null || num.length() == 0)
            return res;
        helper(res, new StringBuilder(), num, target, 0, 0, 0);
        return res;
    }
    static void helper(List<String> res, StringBuilder path, String num, int target, int pos, long eval, long mult){
        if(pos == num.length()&&target == eval){
            res.add(path.toString());
            return;
        }
        int pathLen = path.length();
        long cur = 0;
        for(int i = pos; i<num.length(); i++){
            cur = cur *10 + num.charAt(i) - '0';
            if(pos == 0){
                helper(res,path.append(cur), num, target, i + 1, cur, cur);
                path.setLength(pathLen);
            } else {
                helper(res, path.append("+").append(cur), num, target, i + 1 , eval + cur , cur);
                path.setLength(pathLen);
                helper(res, path.append("-").append(cur), num, target, i + 1 , eval - cur , -cur);
                path.setLength(pathLen);
                helper(res, path.append("*").append(cur), num, target, i + 1 , eval - mult + mult * cur , mult * cur);
                path.setLength(pathLen);
            }
        }
        
    }
}
