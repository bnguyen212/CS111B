public abstract class Book {

   private String title, author;
   private int yearPublished;
   private static final int DEFAULT_YEAR_PUBLISHED = 2019;

   public Book(String title, String author, int yearPublished) {
      this.title = title;
      this.author = author;
      this.yearPublished= yearPublished;
   }
    public Book(String title, String author) {
        this(title, author, DEFAULT_YEAR_PUBLISHED);
    }
   public String getTitle() {
      return title;
   }
   public String getAuthor() {
      return author;
   }
   public int getYearPublished() {
      return yearPublished;
   }
   public void setAuthor(String author) {
      this.author = author;
   }
   public void setTitle(String title) {
      this.title = title;
   }
   public void setYearPublished(int yearPublished) {
      if(yearPublished > 0) {
         this.yearPublished = yearPublished;
      }
   }
   @Override
   public String toString() {
      return title + " by " + author + " (" + yearPublished + ")";
   }
   
   public abstract void read();
}