package test;

public class VariableNums {
	static int totalScore = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addScores(1,2,4,5);
		System.out.println(totalScore);
	}
	public static void addScores(int... values)
	{
	for (int i = 0; i < values.length; i++) // values is an int[]
	{
	totalScore = totalScore + values[i];
	}
	}

}
