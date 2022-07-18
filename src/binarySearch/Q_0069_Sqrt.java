package binarySearch;

public class Q_0069_Sqrt {
	public int mySqrt(int x) {
        // Handle edge case 
		if(x <= 1) return Math.min(x, Integer.MAX_VALUE);
		int left = 1, right = x;
		while(left <= right) {
			int mid = left + (right-left)/2;
			if(mid * mid == x) {
				return mid;
			} else if(mid*mid < x) {
				left = mid+1;
			} else {
				right = mid-1;
			}
		}
		return right;
	}
}
