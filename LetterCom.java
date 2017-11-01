package test;
import java.util.*;
public class LetterCom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(letterCombinations("2"));
	}
	public static List<String> letterCombinations(String digits) {
        String[] map = {"","", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res = new ArrayList<>();
        helper(new StringBuilder(), map, 0, digits,res);
        return res;
    }
    static void helper(StringBuilder path, String[] map, int index, String digits,List<String> res){
        if(digits.length() ==0 )
            return;
        if(index == digits.length()){
            res.add(path.toString());
            return;
        }
        
        String curPool = map[digits.charAt(index)];
        for(int i = 0; i < curPool.length() ; ++ i){
            char curChar = curPool.charAt(i);
            helper(path.append(curChar), map, index+1,digits,res);
            path.deleteCharAt(path.length() -1 );
        }
    }

}
