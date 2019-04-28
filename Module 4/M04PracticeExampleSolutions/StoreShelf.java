import java.util.*;

public class StoreShelf {
	
	private String description;
	private ArrayList<RetailItem> itemsOnShelf;
	private RetailItem.PriceRange rangeAllowed;
	private static int countHighPriceItemsAcrossShelves = 0;
	
	public StoreShelf(String description, RetailItem.PriceRange rangeAllowed) {
		this.description = description;
		this.rangeAllowed = rangeAllowed;
		this.itemsOnShelf = new ArrayList<RetailItem>();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<RetailItem> getItemsOnShelf() {
		return new ArrayList<RetailItem>(itemsOnShelf); // makes a shallow copy so the list cannot be directly manipulated; note that individual RetailItem objects can still be changed
	}
	
	public RetailItem.PriceRange getPriceRangeAllowed() {
		return rangeAllowed;
	}

	// omitted setter for the item list- this can only be modified by the add and remove methods
	// omitted setter for the range; it is possible the range might change- if you want to allow this, consider what you need to do to the list of items on the shelf to ensure that the objects remains in a valid state!

	public static int getCountHighPriceItemsAcrossShelves() {
		return StoreShelf.countHighPriceItemsAcrossShelves;
	}
	
	public String toString() {
		return description + "\t" + getNumberOfItemsOnShelf() + " items\t" + getNumberOfTotalUnitsOnShelf() + " total units";
	}
	
	public void empty() {
		// itemsOnShelf.clear(); cannot do this because the static variable won't be appropriately updated!
		Iterator<RetailItem> iterator = itemsOnShelf.iterator();
		while(iterator.hasNext()) {
			RetailItem itemToRemove = iterator.next();
			if(itemToRemove.getPriceRange()==RetailItem.PriceRange.HIGH) {
				StoreShelf.countHighPriceItemsAcrossShelves--;
			}
			iterator.remove();
		}
	}
	public int getNumberOfItemsOnShelf() {
		return itemsOnShelf.size();
	}
	public int getNumberOfTotalUnitsOnShelf() {
		int count = 0;
		for(RetailItem item : itemsOnShelf) {
			count += item.getUnits();
		}
		return count;
	}
	public double getTotalPriceOfUnitsOnShelf() {
		double totalPrice = 0;
		for(RetailItem item : itemsOnShelf) {
			totalPrice += item.getPrice() * item.getUnits();
		}
		return totalPrice;
	}
	public boolean addItem(RetailItem item) {
		if(rangeAllowed==item.getPriceRange()) {
			if(item.getPriceRange()==RetailItem.PriceRange.HIGH) {
				StoreShelf.countHighPriceItemsAcrossShelves++;
			}
			return itemsOnShelf.add(item);
		} else {
			return false;
		}
	}
	public boolean removeItem(RetailItem item) {
		boolean success = itemsOnShelf.remove(item);
		if(success && item.getPriceRange()==RetailItem.PriceRange.HIGH) {
			StoreShelf.countHighPriceItemsAcrossShelves--;
		}
		return success;
	}
	
	
}
