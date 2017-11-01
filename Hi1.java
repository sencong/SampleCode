package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Hi1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s="a",t="b";
//		
//		System.out.println(anagram(s,t));
		int[] nums = {4,1,-1,2,-1,2,3};
		System.out.println(topKFrequent(nums,2));
	}
	public static List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
           
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = 
            new PriorityQueue<>((a,b)->(a.getValue()-b.getValue()));
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if (minHeap.size() < k)
                minHeap.offer(entry);
            else {
                if (minHeap.peek().getValue() < entry.getValue()) {
                    minHeap.poll();
                    minHeap.offer(entry);
                }       
            }
        }
        
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : minHeap )     
            res.add(entry.getKey()); 
        return res;
	
	}
	public static boolean anagram(String s, String t) {
        // write your code here
        if(s.length()!=t.length()) return false;
        //int len =s.length();
        LinkedList<Integer> l = new LinkedList<>();
        Map<Character,Integer> map = new HashMap<>();
        for(char cur:s.toCharArray()){
            map.put(cur,map.getOrDefault(cur,0)+1);
        }
        for(char cur:t.toCharArray()){
            //if(!map.containsKey(cur)) return false;
        	Integer v1= map.get(cur);
        	System.out.println(v1==1||v1==null);
            map.compute(cur,(k,v)->(v==1||v==null)?null:v-1);
        }
        return map.isEmpty();
    }
	
}
