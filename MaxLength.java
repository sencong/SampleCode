package test;

import java.util.Arrays;

public class MaxLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {4,3,2,6};
		int sum = 0, curSum = 0, n = A.length;
        for(int i = 0; i< n; i++){
            sum += A[i];
            curSum += i*A[i];
        }
        int res = curSum;
        for(int i = 1; i < n; i++){
            curSum += sum - n*A[i];
            res = Math.max(res,curSum);
        }
        System.out.println(res);
	}

}
