public class HouseBoat extends House implements Comparable<HouseBoat> {
  private String name;

  public HouseBoat(int bedroomCount, double bathroomCount, boolean onSale, String name) {
    super(bedroomCount, bathroomCount, onSale);
    this.name = name;
  }

  @Override
  public String toString() {
    String str = "Boat Name: " + name + "\n" + super.toString();
    return str;
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof HouseBoat) {
      HouseBoat hb = (HouseBoat) obj;
      return name.equalsIgnoreCase(hb.name) && getBedroomCount() == hb.getBedroomCount();
    } else {
      return false;
    }
  }

  @Override
  public int compareTo(HouseBoat hb) {
    int compareName = name.compareToIgnoreCase(hb.name);
    if (compareName != 0) {
      return compareName;
    } else {
      return getBedroomCount() - hb.getBedroomCount();
    }
  }
}