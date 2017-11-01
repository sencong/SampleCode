package test;
import java.util.*;

public class RIghtPointer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeLinkNode a = new TreeLinkNode(0);
		connect(a);
	}
	public static void connect(TreeLinkNode root) {
	    if(root == null) return;
	    Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
	    queue.add(root);
	    while (queue!=null) {
	        int size = queue.size();
	        for (int i = 0;i<size;i++) {
	            if(queue.peek().left != null) queue.offer(queue.peek().left);
	            if(queue.peek().right != null) queue.offer(queue.peek().right);
	            if(i<size-1) {
	                queue.poll().next = queue.peek();
	            } else {
	                queue.poll().next = null;
	            }
	        }
	    }
	}
	
}
class TreeLinkNode {
	 int val;
	 TreeLinkNode left, right, next;
	 TreeLinkNode(int x) { val = x; }
}


