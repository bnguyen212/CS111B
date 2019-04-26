import java.util.Arrays;

public class ArrayCopy {

	public static void main(String[] args) {
		int[] nums1 = {1, 2, 3, 4, 5};
		int[] nums2 = new int[nums1.length]; // create a new array the same size as nums1
		
		for(int i=0; i<nums1.length; i++) {
			nums2[i] = nums1[i];
		}
		
		int[] smallArray = new int[100];
		
		for(int i=0; i<smallArray.length; i++) {
			smallArray[i] = i+1;
		}
		// other code that manipulates the array

		int[] biggerArray = new int[200]; // declare a bigger array
		for(int i=0; i<smallArray.length; i++) {
			biggerArray[i] = smallArray[i];
		}
		
		int oldSmallArraySize = smallArray.length;
		smallArray = biggerArray;
		for(int i=oldSmallArraySize; i<smallArray.length; i++) {
			smallArray[i] = i+1;
		}
		System.out.println(Arrays.toString(smallArray));
		System.out.println(Arrays.toString(biggerArray));
	
		
	}

}
