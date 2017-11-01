package test;
import java.util.*;

public class MinCost {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] costs = {{20,19,11,13,12,16,16,17,15,9,5,18},{3,8,15,17,19,8,18,3,11,6,7,12},{15,4,11,1,18,2,10,9,3,6,4,15}};
		System.out.println(minCostII(costs));
	}
	public static int minCostII(int[][] costs) {
        if(costs == null || costs.length ==0 || costs[0].length == 0)
            return 0;
        int n = costs.length, k = costs[0].length;
        int[][] total = new int[n][k];
        TreeMap<Integer,Integer> curMap = new TreeMap<>();
        TreeMap<Integer,Integer> preMap = new TreeMap<>();
        for(int i = 0;i < k; ++i){
            total[0][i] = costs[0][i];
            curMap.compute(costs[0][i], (key,val) -> val == null ? 1 : val+1);
        }
        for(int i = 1;i < n; ++i) {
            preMap = curMap;
            curMap = new TreeMap<>();
            for(int j = 0;j < k; ++j){
                preMap.compute(costs[i-1][j],(key,val) -> val == 1 ? null : val - 1);
                total[i][j] = preMap.firstKey() + costs[i][j];
                curMap.compute(costs[i][j], (key,val) -> val == null ? 1 : val+1);
                preMap.compute(costs[i-1][j],(key,val) -> val == null ? 1 : val + 1);
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0;i<k;i++){
            res = Math.min(res,total[n-1][i]);
        }
        return res;
    }

}
