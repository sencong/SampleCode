package test;

import java.util.Scanner;
import java.util.TreeSet;

public class SellBuy {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
		int n = 2;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(4);
        int[] a = new int[n];
        int res = Integer.MAX_VALUE;
        for(int arr_i=1; arr_i < n; arr_i++){
            int cur = a[arr_i-1];
            res = Math.min(res, set.higher(cur)-cur);
            res = Math.min(res, cur - set.lower(cur));
            set.add(cur);
        }
        System.out.println(res);
        
    }

}
