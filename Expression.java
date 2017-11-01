package test;
import java.util.*;

public class Expression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num = "105";
		System.out.println(addOperators(num,5));

	}
	public static List<String> addOperators(String num, int target) {
        List<String> rst = new ArrayList<String>();
        if(num == null || num.length() == 0) return rst;
        helper(rst, new StringBuilder(), num, target, 0, 0, 0);
        return rst;
    }
    public static void helper(List<String> res, StringBuilder path, String num, int target, int pos, long eval, long multi){
    	if(pos == num.length()&&target == eval){
            res.add(path.toString());
            return;
        }
        int l = path.length();
        long cur = 0;
        for(int i = pos; i < num.length(); i++){
            //if(i != pos && num.charAt(pos) == '0') break;
            cur = cur *10 + num.charAt(i) - '0';
            if(pos == 0){
                helper(res, path.append(cur), num, target, i + 1, cur, cur);
            }
            else{
                helper(res, path.append("+").append(cur), num, target, i+1, eval + cur , cur);
                path.setLength(l);
                helper(res, path.append("-").append(cur), num, target, i+1, eval -cur, -cur);
                path.setLength(l);
                helper(res, path.append("*").append(cur), num, target, i+1, eval - multi + multi * cur, multi * cur );
            }
            path.setLength(l);
        }
    }
}
