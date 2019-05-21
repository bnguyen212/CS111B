public class House {
  private int bedroomCount;
  private double bathroomCount;
  private boolean onSale;
  private static int DEFAULT_BEDROOM_COUNT = 1;
  private static double DEFAULT_BATHROOM_COUNT = 1;
  private static boolean DEFAULT_STATUS = true;

  public House(int bedroomCount, double bathroomCount, boolean onSale) {
    if (bedroomCount < 1) {
      bedroomCount = DEFAULT_BEDROOM_COUNT;
    }
    if (bathroomCount < 1) {
      bathroomCount = DEFAULT_BATHROOM_COUNT;
    }
    this.bedroomCount = bedroomCount;
    this.bathroomCount = bathroomCount;
    this.onSale = onSale;
  }

  public House() {
    this.bedroomCount = DEFAULT_BEDROOM_COUNT;
    this.bathroomCount = DEFAULT_BATHROOM_COUNT;
    this.onSale = DEFAULT_STATUS;
  }

  public int getBedroomCount() {
    return bedroomCount;
  }

  public void setBedroomCount(int newCount) {
    if (newCount > 0) {
      bedroomCount = newCount;
    }
  }

  public double getBathroomCount() {
    return bathroomCount;
  }

  public void setBathroomCount(double newCount) {
    if (newCount >= 1) {
      bathroomCount = newCount;
    }
  }

  public boolean getOnSaleStatus() {
    return onSale;
  }

  public void switchOnSaleStatus() {
    onSale = !onSale;
  }

  @Override
  public String toString() {
    String str = "Number of Bedrooms: " + bedroomCount + "\nNumber of Bathrooms: " + bathroomCount
        + "\nThis house is currently ";
    if (!onSale) {
      str += "NOT ";
    }
    str += "on sale.";
    return str;
  }
}