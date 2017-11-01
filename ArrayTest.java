package test;

public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a []= new int[8][6];
		a[0][1] = 1;
//		System.out.println(a.length);
		print(a);
	}
	static void print(int[] a []){
		System.out.println(a.length);
		System.out.println(a[0].length);
	}

}
