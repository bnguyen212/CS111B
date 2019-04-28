import java.util.*;

public class HomeworkM4Driver {
  public static void main(String[] args) {
    String[] wordArray1 = new String[5];
    wordArray1[0] = "a";
    wordArray1[1] = "b";
    wordArray1[2] = "c";
    System.out.println(countNull(wordArray1));
    System.out.println(countNull(wordArray1, 4));
    // // invoking the one-parameter method will return 2 (there are 2 nulls- one at
    // // index 3 and one at index 4)
    // // invoking the two-parameter method with starting index 4 will return 1
    // // (starting with index 4, there is 1 null at index 4)

    String[] wordArray2 = new String[10];
    wordArray2[0] = "apple";
    wordArray2[1] = "";
    wordArray2[2] = "cat";
    wordArray2[3] = " ";
    System.out.println(countNull(wordArray2));
    System.out.println(countNull(wordArray2, 7));
    // // invoking the one-parameter method will return 6 (there are 6 null spaces-
    // // index 4, 5, 6, 7, 8, 9)
    // // invoking the two-parameter method with starting index 7 will return 3
    // // (starting with index 7, there are 3 empty spaces- index 7, 8, and 9)

    // Triangle t1 = Triangle.EQUILATERAL;
    // Triangle t2 = Triangle.ISOSCELES;
    // Triangle t3 = Triangle.SCALENE;
    // System.out.println(t1.hasEqualSides());
    // System.out.println(t2.hasEqualSides());
    // System.out.println(t3.hasEqualSides());

    System.out.println(Customer.getCustomerCount());
    Order order1 = new Order("ABC123", 80.11);
    Order order2 = new Order("ABC456", 700.22);
    Order order3 = new Order("ABC78", 30.33);
    Order order4 = new Order("ABC90", 40.05);
    Customer cust1 = new Customer("Brian", order1);
    // ArrayList<Order> a1 = cust1.getOrders();
    System.out.println(cust1);
    System.out.println(cust1.getOrders());
    System.out.println(cust1.getAmountOwed());
    cust1.addOrder(order2);
    System.out.println(cust1);
    System.out.println(cust1.getOrders());
    System.out.println(cust1.getAmountOwed());
    cust1.addOrder(order3);
    System.out.println(cust1);
    System.out.println(cust1.getOrders());
    System.out.println(cust1.getAmountOwed());
    cust1.addOrder(order4);
    System.out.println(cust1);
    System.out.println(cust1.getOrders());
    System.out.println(cust1.getAmountOwed());
    System.out.println(Customer.getCustomerCount());
    Customer cust2 = new Customer("Ammy", order2);
    System.out.println(Customer.getCustomerCount());
    Customer cust3 = new Customer("Chenny", order3);
    System.out.println(Customer.getCustomerCount());
    Customer cust4 = new Customer("Frank");
    System.out.println(Customer.getCustomerCount());
  }

  public static enum Triangle {
    EQUILATERAL(3), ISOSCELES(2), SCALENE(0);
    private int numEqualSides;

    private Triangle(int numEqualSides) {
      this.numEqualSides = numEqualSides;
    }

    public boolean hasEqualSides() {
      return numEqualSides > 0;
    }
  }

  public static int countNull(String[] list) {
    return countNull(list, 0);
  }

  public static int countNull(String[] list, int start) {
    int count = 0;
    for (int index = start; index < list.length; index++) {
      if (list[index] == null) {
        count++;
      }
    }
    return count;
  }

}