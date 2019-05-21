import java.util.*;

class Driver {

  public static void main(String[] args) {
    // ArrayList<Integer> arr = new ArrayList<>();
    // arr.add(-1);
    // arr.add(3);
    // arr.add(0);
    // arr.add(-3);
    // arr.add(5);
    // arr.add(-2);
    // System.out.println(Arrays.toString(getAbsoluteValueArray(arr)));

    // ArrayList<House> houses = new ArrayList<House>();
    // House h1 = new House();
    // House h2 = new House(3, 5, false);
    // House h3 = new House(7, 1, true);
    // House h4 = new House(-1, -2, true);
    // houses.add(h1);
    // houses.add(h2);
    // houses.add(h3);
    // houses.add(h4);
    // int count = 0;
    // for (House house : houses) {
    // if (house.getOnSaleStatus()) {
    // count++;
    // }
    // }
    // System.out.println("There are " + count + " houses on sale.");
    // System.out.println("House #1 and #3 are the same: " +
    // similarAndBothForSale(h1, h3));
    // System.out.println("House #1 and #4 are the same: " +
    // similarAndBothForSale(h1, h4));

    // HouseBoat h5 = new HouseBoat(2, 5, false, "Brian's Boat");
    // HouseBoat h6 = new HouseBoat(2, 3, true, "brian's boat");
    // HouseBoat h7 = new HouseBoat(1, 2, true, "CS111Boat");
    // System.out.println(h5.equals(h6));
    // System.out.println(h6.equals(h7));

    // HouseBoat h8 = new HouseBoat(2, 5, false, "ABoat Time");
    // HouseBoat h9 = new HouseBoat(2, 5, false, "Vitamin Sea");
    // HouseBoat h10 = new HouseBoat(2, 5, false, "Knot Shore");
    // HouseBoat h11 = new HouseBoat(4, 5, false, "Vitamin Sea");
    // HouseBoat h12 = new HouseBoat(2, 5, false, "Knot on Call");
    // HouseBoat h13 = new HouseBoat(2, 5, false, "ALoan at Sea");
    // ArrayList<HouseBoat> boats = new ArrayList<HouseBoat>();
    // boats.add(h8);
    // boats.add(h9);
    // boats.add(h10);
    // boats.add(h11);
    // boats.add(h12);
    // boats.add(h13);
    // for (HouseBoat h : boats) {
    // System.out.println(h.getName() + " " + h.getBedroomCount());
    // }
    // Collections.sort(boats);
    // for (HouseBoat h : boats) {
    // System.out.println(h.getName() + " " + h.getBedroomCount());
    // }

    // double d = 5/2;
    // int a = 10;
    // int b = 3;
    // a -= b;
    // int answer = a % b;
    // System.out.println(answer);
    // for(int i=0; i<5; i++) {
    // System.out.println(i);
    // }
    // System.out.println("Ended with " + i);
    // for(int i=0; i<=5; i++) {
    // System.out.println(i);
    // }
    // System.out.println("**********");
    // int j=1;
    // while(j<7) {
    // System.out.println(j-1);
    // j++;
    // }
    // int n = 4;
    // String s = n + "";
    // double d = n;
    // System.out.println(d);

    // String text = "I love this class.";
    // text.toUpperCase();
    // System.out.println(text);

    // String text = "Learning Java is fun.";
    // String result = text.substring(1, 4);
    // System.out.println(result);

    // String a = "3", b = "2";
    // int y = 4, z = 5;
    // System.out.println(a + b + y + z);

    // String a = "3", b = "4";
    // int y = 6, z = 7;
    // System.out.println(y + z + a + b);

    // String name = "Jess!";
    // if(name.length() < 5) {
    // System.out.println("hi ");
    // } else if(name.length() > 10) {
    // System.out.println("hello");
    // }

    // int[] nums = new int[8];
    // System.out.println(nums[8]);

    // int[] numbers = {1, 2, 3};
    // System.out.println(numbers);

    // ArrayList<Integer> numbers = new ArrayList<Integer>();
    // numbers.add(2);
    // numbers.add(5);
    // numbers.add(7);
    // numbers.remove(1);
    // System.out.println(numbers.get(1));

    // int n = 6;
    // method(n);
    // System.out.println(n);
    // ClassB test = new ClassB(1,2,3,4);
    // test.methodB();

    // try {
    //   System.out.println("Enter a number without a decimal.");
    //   Scanner scan = new Scanner(System.in);
    //   int num = scan.nextInt();
    // } catch (InputMismatchException ex) {
    //   System.out.println("bad input");
    // }
    // System.out.println(num);
  }

  public static void method(int number) {
    number++;
  }

  public static int[] getAbsoluteValueArray(ArrayList<Integer> list) {
    int[] arr = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      arr[i] = Math.abs(list.get(i));
    }
    return arr;
  }

  public static boolean similarAndBothForSale(House house1, House house2) {
    boolean bothOnSale = house1.getOnSaleStatus() && house2.getOnSaleStatus();
    boolean sameBathroomCount = Math.abs(house1.getBathroomCount() - house2.getBathroomCount()) < 0.00001;
    boolean sameBedroomCount = house1.getBedroomCount() == house2.getBedroomCount();
    return bothOnSale && (sameBathroomCount || sameBedroomCount);
  }

  public enum GameResult {
    WIN("win"), TIE("tie"), LOSS("loss");
    private String outcome;

    private GameResult(String outcome) {
      this.outcome = outcome;
    }

    public String getOutcome() {
      return this.outcome;
    }
  }

}