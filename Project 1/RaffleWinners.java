import java.util.*;

public class RaffleWinners {
  public static void main(String[] args) {

    boolean repeat;
    do {
      System.out.println("Welcome to the Raffle Winner Program!");
      Scanner scan = new Scanner(System.in);

      System.out.println("What is the smallest raffle ticket number?");
      int startNumber = Integer.parseInt(scan.nextLine());
      while (startNumber <= 0) {
        System.out.println("WARNING: The smallest raffle ticket number must be greater than 0. Please try again:");
        startNumber = Integer.parseInt(scan.nextLine());
      }

      System.out.println("What is the largest raffle ticket number?");
      int endNumber = Integer.parseInt(scan.nextLine());
      while (endNumber - startNumber < 2) {
        System.out.println("WARNING: The largest raffle ticket number must be greater than the smallest raffle ticket number and there must be at least 3 tickets sold. Please try again:");
        endNumber = Integer.parseInt(scan.nextLine());
      }

      select3Winners(startNumber, endNumber);

      System.out.println("Do you want to run another raffle? Yes / No (y/n)");
      String decision = scan.nextLine();
      repeat = decision.equalsIgnoreCase("y") || decision.equalsIgnoreCase("yes") ? true : false;
    } while (repeat);

  }

  public static void select3Winners(int start, int end) {
    System.out.println("The winning raffle ticket numbers are:");
    Random generator = new Random();

    int winner1 = generator.nextInt(end - start + 1) + start;
    System.out.printf("Winner 1: %s\n", winner1);

    int winner2 = generator.nextInt(end - start + 1) + start;
    while (winner2 == winner1) {
      winner2 = generator.nextInt(end - start + 1) + start;
    }
    System.out.printf("Winner 2: %s\n", winner2);

    int winner3 = generator.nextInt(end - start + 1) + start;
    while (winner3 == winner1 || winner3 == winner2) {
      winner3 = generator.nextInt(end - start + 1) + start;
    }
    System.out.printf("Winner 3: %s\n", winner3);
  }
}