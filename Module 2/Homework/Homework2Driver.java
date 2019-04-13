public class Homework2Driver {
  public static void main(String[] args) {
    // Person p = new Person("John Smith", "123 Main Street", 42, "1234567890");
    // String s = p.getPhoneNumber();
    // // System.out.print(p);
    // // System.out.print(String.to(p));
    // // System.out.print(p.toString());
    // // p.toString();
    // // System.out.println(p.vote());
    // p.toString();
    // int n = 2;
    // shrink(n);
    // System.out.print(n);

    Book book1 = new Book("To Kill a Mockingbird", "Harper Lee", 1960);
    Book book2 = new Book("Modeling Monetary Economies", "Bruce Champ & Scott Freeman & Joseph Haslag", 2011);
    Book book3 = new Book("Pride and Prejudice", "Jane Austen", 1813);
    System.out.println("Book #1: \n" + book1);
    System.out.println();
    System.out.printf("Book #2 has %s author(s).\n", book2.getAuthorCount());
    System.out.println();
    System.out.println("Was book #3 published before the digital age? " + book3.isPublishedBeforeDigitalAge());




  }

  public static void shrink(int q) {
    q = q / 2;
  }
}