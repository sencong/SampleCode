package test;

public class CountPosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5, 5, 1, 7, 2, 3, 5};
		System.out.println(position(arr,5));
	}
	static int position(int[] arr,int target){
//		if(arr.length ==0) 
//			return -1;
//		int start = 0, end = arr.length-1;
//		int left = 0,right = 0;
////		boolean leftTest = false;
//		while(start< end){
//			if(left<= right){
//				if(arr[start] == target)					
//					left++;
//				start++;	
//			} else {
//				if(arr[end] != target)					
//					right++;
//				end--;				
//			}				
//		}
//		if(left == right)
//			return arr[start] == target? start-1:start;
//		else 
//			return -1;
		int sum = 0, seg =0,len = arr.length;
		for(int i = 0;i<len;i++){
			if(arr[i]==target){
				sum ++;
				seg ++;
			} else {
				seg =0;
			}
		}
		return arr[len-1] != target || sum > seg? len - sum: len;
	}
}
