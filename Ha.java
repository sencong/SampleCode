package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Ha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0;i<5;i++){
			pq.offer(i*i-10);
		}
//		for(int i :pq){
//			System.out.println(i);
//		}
		Iterator<Integer> iter = pq.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}
	

}
