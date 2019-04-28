import java.util.ArrayList;

public class Customer {
  private String name;
  private ArrayList<Order> orderList;
  private static int customerCount = 0;

  public Customer(String name) {
    this.name = name;
    orderList = new ArrayList<Order>();
    // added this line below
    customerCount++;
  }

  public Customer(String name, Order firstOrder) {
    this(name);
    if (firstOrder != null) {
      orderList.add(firstOrder);
    }
  }

  public String getName() {
    return name;
  }

  public void setName(String newName) {
    if (newName != null && newName.length() > 0) {
      name = newName;
    }
  }

  public ArrayList<Order> getOrders() {
    return new ArrayList<Order>(orderList);
  }

  // There is no setter method for orderList.
  // Use addOrder or removeOrder to modify orderList.

  @Override
  public String toString() {
    String s = "Customer Name: " + name + "\nNumber of Orders: " + orderList.size();
    return s;
  }

  public double getAmountOwed() {
    double total = 0.0;
    for (Order order : orderList) {
      total += order.getTotal();
    }
    return total;
  }

  public boolean addOrder(Order newOrder) {
    if (newOrder != null && getAmountOwed() < 800) {
      orderList.add(newOrder);
      return true;
    } else {
      return false;
    }
  }

  public static int getCustomerCount() {
    return customerCount;
  }
}