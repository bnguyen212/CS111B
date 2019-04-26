import java.util.Arrays;

public class MoreArrayFun {
	
	public static void main(String[] args) {
		int[] testArray = {1, 3, 6, 8, 4, 2};
		System.out.println("before doubleValues method: " + Arrays.toString(testArray));
		doubleValues(testArray);
		System.out.println("after doubleValues method: " + Arrays.toString(testArray));
		int[] testArray2 = createNewDoubleArray(testArray);
		System.out.println("after createNewDoubleArray method: " + Arrays.toString(testArray));
		System.out.println("testArray2 after createNewDoubleArray method: " + Arrays.toString(testArray2));
	}
	
	public static void doubleValues(int[] array) {
		for(int i=0; i<array.length; i++) {
			array[i] = array[i] * 2;
		}
		
	}
	
	public static int[] createNewDoubleArray(int[] array) {
		int[] newArray = new int[array.length];
		for(int i=0; i<array.length; i++) {
			newArray[i] = array[i] * 2;
		}
		return newArray;
	}
	
	public static boolean hasDuplicates(int[] numbers) {
		boolean hasDups = false;
		
		for(int i=0; (i<numbers.length && !hasDups); i++) {
			int currentNumber = numbers[i];
			
			for(int j=i+1; (j<numbers.length && !hasDups); j++) {
				
				int innerNumber = numbers[j];
				if(currentNumber == innerNumber) {
					hasDups = true;
				}
			}
		}
		return hasDups;
	}
}
