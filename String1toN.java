package test;

public class String1toN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(string1UpToN(1));
	}
	public static String string1UpToN(int n) {
		  return RAppendUpTo(new StringBuilder(), 1, n).toString(); 
		}
		private static StringBuilder RAppendUpTo(StringBuilder sb, int start, int end) {
		  if (start < end)
		    return sb;
		  return RAppendUpTo(sb.append(' ').append(start),start + 1, end);
		}

}
