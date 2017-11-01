package test;
import java.util.*;

public class Vertical {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNodes root = new TreeNodes(1);
		root.left = new TreeNodes(2);
		root.right = new TreeNodes(3);
		TreeNodes q = new TreeNodes(4);
		System.out.println(verticalOrder(root));
	}
	public static List<List<Integer>> verticalOrder(TreeNodes root) {
		List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Map<Integer,List<Integer>> map = new HashMap<>();
        Queue<Integer> colQueue = new ArrayDeque<>();
        Queue<TreeNodes> nodeQueue = new ArrayDeque<>();
        nodeQueue.offer(root);
        colQueue.offer(0);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while(!nodeQueue.isEmpty()){
            TreeNodes curNode = nodeQueue.poll();
            int curCol = colQueue.poll();
            map.computeIfAbsent(curCol, k->new ArrayList<>()).add(curNode.val);
            if(min < curCol) min = curCol;
            if(max > curCol) max = curCol;
            if(curNode.left != null){
                nodeQueue.offer(curNode.left);
                colQueue.offer(curCol-1);
            }
            if(curNode.right != null){
                nodeQueue.offer(curNode.right);
                colQueue.offer(curCol+1);
            }
        }
        for(int i = min;i<max;i++){
            res.add(map.get(i));
        }
        return res;
    }
}
