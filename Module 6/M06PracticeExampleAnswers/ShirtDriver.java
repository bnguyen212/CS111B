import java.util.*;

public class ShirtDriver {
	public static void main(String[] args) {
		
		Shirt[] shirts = new Shirt[5];
		// showing different ways to fill up the array- with or without a local variable
		shirts[0] = new Shirt(Shirt.Size.LARGE, "Black", 19.99);
		Shirt tempShirt = new Shirt(Shirt.Size.SMALL, "Red", 39.99);
		shirts[1] = tempShirt;
		shirts[2] = new Sweatshirt(Shirt.Size.MEDIUM, "Gray", 19.99, true);
		Sweatshirt tempSweatshirt = new Sweatshirt(Shirt.Size.SMALL, "Pink", 10, false);
		shirts[3] = tempSweatshirt;
		shirts[4] = new Sweatshirt(Shirt.Size.LARGE, "Green", 39.99);
		
		int hoodedCount = 0;
		for(Shirt shirt : shirts) {
			System.out.println(shirt);
			if(shirt instanceof Sweatshirt) {
				Sweatshirt sweatshirt = (Sweatshirt) shirt;
				if(sweatshirt.isHooded()) {
					hoodedCount++;
				}
			}
		}
		System.out.println("There are " + hoodedCount + " hooded sweatshirts.");
		
		Arrays.sort(shirts); // Arrays.sort(...) for arrays; Collections.sort(...) for ArrayLists
		// System.out.println(Arrays.toString(shirts)); // could use this to print on a single line
		
		for(Shirt shirt : shirts) {
			System.out.println(shirt);
		}
	}
}
