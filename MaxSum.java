package test;
import java.util.*;
public class MaxSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = {{1,0,1},{0,-2,3}};
		System.out.println(maxSumSubmatrix(a,10));
	}
	
    static int maxSumSubmatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int m = Math.min(row,col);
        int n = Math.max(row,col);
        boolean colIsBig = col > row;
        int res = Integer.MIN_VALUE;
        for(int i = 0;i<m;i++){   
            int[] array = new int[n];
            for(int j = i; j<m; j++){
                int val = 0;
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                for(int k = 0;k<n;k++){
                    array[k]=array[k]+ (colIsBig ? matrix[j][k] : matrix[k][j]);
                    val = val + array[k];
                    if(set.last() >= val - target){
                        res = Math.max(res, set.floor(target));
                    }
                    set.add(val);
                }
            }
        }
        return res;
    }
}
