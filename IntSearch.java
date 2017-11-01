package test;

public class IntSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] values = {0, 1, 2, 3, 4, 4, 5, 6, 7, 8, 8, 8, 9};
		Matches res = findMatches(values, 4);
		System.out.println(res.getFirstMatchIndex()+" "+res.getNumberOfMatches());
	}

	public static Matches findMatches(int[] values, int query) {
		if(values.length==0){
			return new Matches(-1,0); // when values contains nothing, there is no value queried in values 
		}
		// Use binary search to find the first occurrence of query
		int start = 0;
		int end = values.length-1;
		int first = 0; // the index of first occurrence of query, just initially assign it to 0 to make the program compile
		while(start+1 < end){
			int mid = start +((end-start)>>1);
			if(values[mid] >= query){
				end = mid;
			} else {
				start = mid;
			}
		}
		if(values[start] == query){
			first = start;
		} else if(values[end] == query){
			first = end;
		} else {
			return new Matches(-1, 0);
		}	
		
		start = 0;
		end = values.length-1;
		int last = values.length-1; // the index of first occurrence of query, just initially assign it to 0 to make the program compile
		while(start+1 < end){
			int mid = start +((end-start)>>1);
			if(values[mid] <= query){
				start = mid;
			} else {
				end = mid;
			}
		}
		if(values[end] == query){
			last = end;
		} else if(values[start] == query){
			last = start;
		} else {
			return new Matches(-1, 0);
		}
	
		return new Matches(first, last-first+1);
	
	}
	
	/**
	
	* Encapsulates the position of the first match and the number of
	
	* occurrences of an integer in an array.
	
	*/
	
		public static class Matches {
	
			private int firstMatchIndex;
	
			private int numberOfMatches;
	
			public Matches(int firstMatchIndex, int numberOfMatches) {
	
				this.firstMatchIndex = firstMatchIndex;
	
				this.numberOfMatches = numberOfMatches;
	
			}
	
	
	
			public int getFirstMatchIndex() {
	
				return this.firstMatchIndex;
	
			}
	
			public int getNumberOfMatches() {
	
				return this.numberOfMatches;
	
			}
	
		}

}
