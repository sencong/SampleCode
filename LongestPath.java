package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(10);
		root.left = new Node(2);
		root.right = new Node(5);
		Node dummy = root.left;
		dummy.left = new Node(3);
		dummy.right = new Node(4);
		dummy = root.right;
		dummy.left = new Node(-5);
		dummy.right = new Node(-1);
//		List<Node> nodes = longest(root).nodes;
//		for(Node node:nodes)
//			System.out.println(node.val);
		Map<Node,Boolean> map = new HashMap<>();
		longest(root,map);
		List<Node> res = new ArrayList<>();
		while(root!=null){
			res.add(root);
			if(map.get(root)){
				root = root.left;
			} else{
				root = root.right;
			}
		}
		for(Node node:res)
			System.out.println(node.val);
		
	}
	static int longest(Node root, Map<Node,Boolean> map){
//		List<Node> res = new ArrayList<>();
		if(root ==null) return 0;
		int leftRes = longest(root.left, map);
		int rightRes = longest(root.right,map);
		if(leftRes>rightRes){
//			res.add(root);
//			res.addAll(leftRes.nodes);
			map.put(root, true);
			return leftRes+root.val;
		} else {
//			res.add(root);
//			res.addAll(rightRes.nodes);
			map.put(root, false);
			return rightRes+root.val;
		}
		
	}

}
