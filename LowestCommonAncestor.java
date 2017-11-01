package test;

public class LowestCommonAncestor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNodes root = new TreeNodes(1);
		root.left = new TreeNodes(2);
		root.right = new TreeNodes(3);
		TreeNodes q = new TreeNodes(4);
		System.out.println(lowestCommonAncestor(root, null,null ));
	}
	public static TreeNodes lowestCommonAncestor(TreeNodes root, TreeNodes p, TreeNodes q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        
        // Divide
        TreeNodes left = lowestCommonAncestor(root.left, p, q);
        TreeNodes right = lowestCommonAncestor(root.right, p, q);
        
        // Conquer
        if (left != null && right != null) {
            return root;
        } 
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
        
    }

}
class TreeNodes{
	int val;
	TreeNodes left;
	TreeNodes right;
	TreeNodes(int x) { val = x; }
}
