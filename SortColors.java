package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortColors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>(Arrays.asList(3,2,1,2,0,3,2,1,2,3,0,0,3));
		sortColors(list);
		System.out.println(list);
	}
	static void sortColors(List<Integer> list){
		int cut1 = 0, cut2 = list.size()-1;
		int leftCursor = 0, rightCursor = list.size()-1;
		while(leftCursor <= rightCursor){
			switch(list.get(leftCursor)){
				case 0: Collections.swap(list, cut1, leftCursor);
						cut1++;
						leftCursor++;
						break;
				case 1: leftCursor ++;
						break;
				case 2: Collections.swap(list, leftCursor, rightCursor);
						rightCursor--;
						break;
				case 3: Collections.swap(list, cut2, rightCursor);
						rightCursor--;
						Collections.swap(list, cut2, leftCursor);
						cut2--;
						break;
						
			}
		}
	}

}
