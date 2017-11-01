package test;
import java.util.*;

public class LeastBricks {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		List<List<Integer>> wall = new ArrayList<>();
//		wall.add(Arrays.asList(1,2,2,1));
//		wall.add(Arrays.asList(3,1,2));
//		wall.add(Arrays.asList(1,3,2));
//		wall.add(Arrays.asList(2,4));
//		wall.add(Arrays.asList(3,1,2));
//		wall.add(Arrays.asList(1,3,1,1));
//		wall.add(Arrays.asList(1,2,2,1));
//		wall.add(Arrays.asList(3,1,2));
//		wall.add(Arrays.asList(1,3,2));
		wall.add(Arrays.asList(9,1));
		wall.add(Arrays.asList(6,3,1));
		wall.add(Arrays.asList(2,4,1,3));
		System.out.println(leastBricks(wall));
		
	}
	public static int leastBricks(List<List<Integer>> wall) {
		if(wall ==null || wall.size()==0 || wall.get(0).size()==0) return 0;
        int len =0;
        for(int i:wall.get(0)){
            len +=i;
        }
        if(len==0) return 0;
        if(len==1) return wall.size();
        int res =Integer.MAX_VALUE;
        List<Set<Integer>> cuts = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for(List<Integer> list:wall){
            Set<Integer> cutPos = new HashSet<>();
            int curPos =0;
            for(int j:list){
                curPos += j;
                visited.add(curPos);
                if(j!=len) cutPos.add(curPos);
            }
            cuts.add(cutPos);
        }
        for(int i=1;i<len;i++){
            if(i>1 && !visited.contains(i-1)) continue;
            int curNum =0;
            for(Set<Integer> set:cuts){
                curNum += set.contains(i)?0:1;
            }
            res = Math.min(res,curNum);
        }
        return res;
    }

}
