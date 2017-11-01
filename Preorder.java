package test;

public class Preorder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 2, 1, 3, 0, 3 };
		System.out.println(verifyPreorder(a));
	}

	public static boolean verifyPreorder(int[] preorder){
		int low = Integer.MIN_VALUE, index = -1;
		for (int i : preorder) {
			if (i < low)
				return false;
			while (index >= 0 && i > preorder[index])
				low = preorder[index--];
			preorder[++index] = i;
		}
		return true;
	}
}
