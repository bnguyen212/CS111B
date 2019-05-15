public class ChildrenBook extends Book {

  public ChildrenBook(String title, String author, int yearPublished) {
    super(title, author, yearPublished);
  }

  @Override
  public void read() {
    System.out.println("Reading...");
  }

}
