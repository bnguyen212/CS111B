import java.util.ArrayList;

public class AudioStoreAccount {

	private String name, accountID;
	private double balance;
	private ArrayList<AudioItem> itemList;
	
	public static final double DEFAULT_INITIAL_BALANCE = 0;

	public AudioStoreAccount(String name, String accountID, double balance) {
		this.name = name;
		this.accountID = accountID;
		this.balance = balance;
		itemList = new ArrayList<AudioItem>();
	}
	public AudioStoreAccount(String name, String accountID) {
		this(name, accountID, DEFAULT_INITIAL_BALANCE);
	}
	
	public String getName() {
		return name;
	}
	public String getAccountId() {
		return accountID;
	}
	public ArrayList<AudioItem> getItemList() {
		return itemList;
	}
	public double getBalance() {
		return balance;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAccountId(String accountID) {
		this.accountID = accountID;
	}
	public void setBalance(double balance) {
		if(balance >= 0) {
			this.balance = balance;
		}
	}
	
	public String toString() {
		return name + " (" + accountID + ")"
				+ "\nBalance: " + balance;
	}
	
	public boolean addItem(AudioItem newItem) {
		double itemPrice = newItem.getPrice();
		if(balance >= itemPrice) {
			balance = balance - itemPrice;
			return itemList.add(newItem);
		} else {
			System.out.println("Insufficient Funds");
			return false;
		}
	}
	
	public boolean removeItem(AudioItem newItem) {
		return itemList.remove(newItem);
	}

}
