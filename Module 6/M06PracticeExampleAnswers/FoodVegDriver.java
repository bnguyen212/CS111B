import java.util.*;
/*
Write code that would go inside of a 
  driver program. Create an ArrayList of Food objects- some vegetables and some not. 
Write a loop to print the name of each food. Also count how many green vegetables are in the list.
 */
public class FoodVegDriver {

	public static void main(String[] args) {
		ArrayList<Food> foodList = new ArrayList<>();
		foodList.add(new Food("bread"));
		foodList.add(new Vegetable("asparagus"));
		foodList.add(new Vegetable("carrot", false));
		foodList.add(new Vegetable("broccolli", true));
		foodList.add(new Food("cheese"));
		foodList.add(new Vegetable("ASPARAGUS", true));
		foodList.add(new Food("BREAD"));
		foodList.add(new Food("bread"));
		foodList.add(new Vegetable("broccolli", true));
		
		int greenCount = 0;
		for(Food food : foodList) {
			System.out.println(food);
			
			if(food instanceof Vegetable) {
				Vegetable vegetable = (Vegetable) food;
				if(vegetable.isGreen()) {
					greenCount++;
				}
			}
		}
		System.out.println("There are " + greenCount + " green veggies on the list.");
		
		int duplicateCount = 0;
		for(int i=0; i<foodList.size(); i++) {
			for(int j=i+1; j<foodList.size(); j++) {
				if(foodList.get(i).equals(foodList.get(j))) {
					// note this will only accurately count the Vegetable duplicates!
					// Food did not override equals, so the Object version is used- 
					// so the equals method only checks if they are aliases, 
					// instead of whether the characteristics match!
					duplicateCount++;
				}
			}
		}
		System.out.println("There are " + duplicateCount + " duplicates in the list.");

	}

}
