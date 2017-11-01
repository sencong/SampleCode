package test;

import java.util.Scanner;

public class Input {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "mississippi", t ="";
		System.out.println(t.charAt(0));
//		System.out.println(strStr(s,t));
	}
	public static int strStr(String haystack, String needle) {
        int m = haystack.length(), n =needle.length();
        if(n==0) return 0;
        for(int i=0;i<=m-n;i++){
            for(int j = 0;i<n;j++){
                if(haystack.charAt(i+j)==needle.charAt(j)){
                    if(j==n-1) return i;
                } else {
                    break;
                }
            }
        }
        return -1;
    }

}
