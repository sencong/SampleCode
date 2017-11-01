package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinWin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aa", t = "aa";
		System.out.println(minWindow(s,t));
	}
	public static String minWindow(String s, String t) {
        Map<Character, Integer> tmap = new HashMap<>();
        int numT = 0;
        for(char c: t.toCharArray()){
            if(tmap.containsKey(c)){
                tmap.put(c,tmap.get(c)+1);
            } else {
                tmap.put(c,1);
            }
            numT ++;
        }
        int res = Integer.MAX_VALUE;
        String minStr = "";
        int numS = 0,start = 0;
        for(int end = 0; end < s.length(); end ++){
            char cur = s.charAt(end);
            if(tmap.getOrDefault(cur , 0) >0){
                numS ++;
            }
            tmap.compute(cur, (key,val)-> val == null? -1:val-1);
            while(numS == numT && start<=end){
                if(end-start+1 < res){
                    res = end-start+1;
                    minStr = s.substring(start,end+1);
                }
                if(tmap.get(s.charAt(start)) >0){
                    numS --;
                }
                tmap.compute(s.charAt(start), (key,val)-> val+1);
                start ++;
            }
        }
        return minStr;
    }
	public static int findCelebrity(int n) {
        boolean[] candidates = new boolean[n];
        Arrays.fill(candidates,true);
        for(int i = 0;i<n;i++){
            for(int j = 0; j <n; j++){
                if(i!= j && candidates[i] ){
                    if(knows(i, j) || !knows(j, i)){
                        candidates[i] = false;
                        break;
                    } else {
                        candidates[j] = false;
                    }
                }
            }
            if(candidates[i]) return i;
        }
        return -1;
    }
	static boolean knows(int a, int b){
		return true;
	}

}
