public class Order {
  private String orderID;
  private double total; // cost of the order

  public Order(String orderID, double total) {
    this.orderID = orderID;
    this.total = total;
  }

  public String getOrderID() {
    return orderID;
  }

  public double getTotal() {
    return total;
  }

  @Override
  public String toString() {
    String s = orderID + " - $" + total;
    return s;
  }
}