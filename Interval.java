package test;

public class Interval {
	private double low , high;
	public Interval(double low, double high) {
		this.low = low;
		this.high = high;
	}
	public boolean overlaps(Interval other) {
		if (low > other.high)
			return false;
		if (high < other.low)
			return false;
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Interval a = new Interval(3,4);
//		Interval b = new Interval(4.5,7);
//		System.out.println(a.overlaps(b));
		
		for (int i = -10 ; i < 10; i++)
			System.out.println(i & 0x7fffffff);
		
		String[] students = new String[10];
		String studentName = "Peter Smith";
		students[0] = studentName;
		studentName = null;
		
	}

}
