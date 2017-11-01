package test;

/*

Limited character set: 0123456789+*

Examples:
"4+3"  7
"7*4"  28
"4+3*7"  25
"4+5+6"

*/


import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void main(String[] args) {
    String s = "4+3*7";
     s = "4+5+6";
    // s = "4+3";
    // s = "7*4";
//    s = "4+3*70+8";
//    s ="4";
    //          i
    System.out.println(calculate(s));
    
  }
  static int calculate(String s){
    Deque<Integer> stack = new ArrayDeque<>();
    int num = 0;
    boolean isPlus = true;
    // if(s.length() ==0) return 0;
    for(int i = 0;i < s.length();i++){
      if(Character.isDigit(s.charAt(i))){
         num = num * 10 + s.charAt(i) - '0';
//        if(i == s.length()-1){
//          if(stack.isEmpty()){
//            stack.push(num);
//          } else {
//          int num1 = stack.pop();
//          int val = isPlus? num1+num:num1*num;
//          stack.push(val);
//             // stack.push(num); 
//           // } else {
//           //   stack.pop()
//           // }
//          }
//        }
        
      } 
//      else if(s.charAt(i) == '+'){
//        // stack.push(num);
//        if(!isPlus){
//          int num1 = stack.pop();
//          int val = num1*num;
//          stack.push(val);
//        } else {
//          stack.push(num); 
//        }
//        num = 0;
//        isPlus =true;
//        
//      } else {
//        if(!isPlus){
//          int num1 = stack.pop();
//          int val = num1*num;
//          stack.push(val);
//        } else {
//          stack.push(num); 
//        }
//        num = 0;
//        isPlus = false;
//      }
      if(!Character.isDigit(s.charAt(i)) || i == s.length()-1){
    	  if(!isPlus){
//            int num1 = stack.pop();
//            int val = num1*num;
//            stack.push(val);
    		  stack.push(stack.pop()*num);
          } else {
            stack.push(num); 
          }
          num = 0;
      }
      if(!Character.isDigit(s.charAt(i)))
    	  isPlus = s.charAt(i) == '+' ? true:false;
    }
    // num = num * 10 + s.charAt(s.length()-1) - '0';
    int res = 0;
    for(int i:stack){
      res += i;
    }
    // res += num;
    return res;
    // return isPlus ? num+stack.pop(): num*stack.pop();
  }
}

