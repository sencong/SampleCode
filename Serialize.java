package test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class TreeNode{
	TreeNode left,right;
	int val;
	TreeNode(int x) { val = x; }
}
public class Serialize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.right= new TreeNode(2);
		System.out.println(serialize(root));
	}
	
	public static String serialize(TreeNode root) {
        if (root == null) {
            return "{}";
        }

        // LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        // //Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // queue.add(root);

        // for (int i = 0; i < queue.size(); i++) {
        //     TreeNode node = queue.get(i);
        //     if (node == null) {
        //         continue;
        //     }
        //     queue.add(node.left);
        //     queue.add(node.right);
        // }
        List<TreeNode> list = new ArrayList<TreeNode>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            list.add(cur);
            if(cur!=null){
                stack.push(cur.right);
                stack.push(cur.left);
            }
        }
        

        while (list.get(list.size()-1) == null) {
            list.remove(list.size()-1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(list.get(0).val);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == null) {
                sb.append(",#");
            } else {
                sb.append(",");
                sb.append(list.get(i).val);
            }
        }
        sb.append("}");
        return sb.toString();
    }

}
