
public class CustomerDriver {

	public static void main(String[] args) {
		Customer[] customers = new Customer[4];
		
		Address address1 = new Address("123 Main Street", "Townville", "CA", "12345");
		
		customers[0] = new Customer("Rick Regular", "R124", new Address("567 Poplar Ave", "Treeton", "CA", "34578"));
		customers[1] = new Customer("Carl Consumer", "C123", address1);
		customers[2] = new PreferredCustomer("Candy Consumer", "C561", address1, 6);
		customers[3] = new PreferredCustomer("Lorna Long", "L980", new Address("59 Key Street", "Computown", "CA", "49850"), 15);

		int totalYearsPreferred = 0;
		for(int i=0; i<customers.length; i++) {
			System.out.println(customers[i].toString());
			customers[i].inviteSale();
			customers[i].birthdayReward();
			
			if(customers[i] instanceof PreferredCustomer) {
				PreferredCustomer pCustomer = (PreferredCustomer) customers[i];
				totalYearsPreferred += pCustomer.getYears();
			}
		}
		System.out.println("The preferred customers add to to " + totalYearsPreferred + " years!");
	}

}
