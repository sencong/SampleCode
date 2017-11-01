package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListCompare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] test = {"((())",")()()((()"};
		for(String s:test){
			System.out.println(valid(s));
		}
	}
	static String valid(String s){
		StringBuilder res = new StringBuilder();
		int leftParenthesis = 0;
		for(char c:s.toCharArray()){
			if(c =='('){
				leftParenthesis++;
				res.append(c);
			} else {
				if(leftParenthesis <=0){
					continue;
				} else{
					res.append(c);
					leftParenthesis--;
				}
			}
		}
		if(leftParenthesis >0){
			res.reverse();
			int index = 0;
			for(int i = 0;i<res.length();i++){
				while(res.charAt(i) == '('){
					res.deleteCharAt(i);
					leftParenthesis--;
					if(leftParenthesis ==0) return res.reverse().toString();
				}
				
			}
			
		}
		return res.toString();
	}

}
