package test;

import java.util.ArrayDeque;
import java.util.Queue;

public class DeleteString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxMoves("aabbaab", "ab"));
	}
	static int maxMoves(String s, String t) {
		if (s == null || t == null || s.indexOf(t) == -1)
            return 0;
        int sLen = s.length(), tLen = t.length();
        int maxPossible = sLen / tLen;
        int[][] dp = new int[sLen+1][sLen+1];
        int res = 1;
        Queue<StringBuilder> queue = new ArrayDeque<>();
        queue.offer(new StringBuilder());
        while (!queue.isEmpty() && res <= maxPossible){
            int size = queue.size();
            boolean exist = false;
            for (int i = 0 ; i < size; i++) {
                StringBuilder cur = queue.poll();
                for(int j = 0; j <= cur.length(); j++){
                    StringBuilder temp = new StringBuilder(cur).insert(j,t);
                    int start =s.indexOf(temp.toString());
                    if(start != -1) {
                        for (int k = 0; k <start; k++)
                            dp[k][start+tLen] = Math.max(dp[k][start+tLen], dp[k][start] + res);
                        for (int k = start + tLen; k <= sLen; k++)
                            dp[start][k] = Math.max(dp[start][k], dp[start + tLen][k] + res);
                        exist = true;
                    }
                        
                }
            }
            if(exist)
                res ++;
            else
                break;
        }
        return res;
    }

}
