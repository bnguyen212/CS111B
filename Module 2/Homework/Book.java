public class Book {
  private String title, author;
  private int publicationYear;

  public Book(String initialTitle, String initialAuthor, int initialPublicationYear) {
    title = initialTitle;
    author = initialAuthor;
    publicationYear = initialPublicationYear;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String newTitle) {
    if (newTitle != null && newTitle.length() > 0) {
      title = newTitle;
    }
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String newAuthor) {
    if (newAuthor != null && newAuthor.length() > 0) {
      author = newAuthor;
    }
  }

  public int getPublicationYear() {
    return publicationYear;
  }

  public void setPublicationYear(int newPublicationYear) {
    if (newPublicationYear > 0) {
      publicationYear = newPublicationYear;
    } else {
      System.out.println("Publication Year cannot be a negative number.");
    }
  }

  public String toString() {
    String s = "Title: " + title + "\nAuthor: " + author + "\nPublication Year: " + publicationYear;
    return s;
  }

  public boolean isPublishedBeforeDigitalAge() {
    return publicationYear < 1990;
  }

  public int getAuthorCount() {
    int count = 1;
    for (char ch : author.toCharArray()) {
      if (ch == '&') {
        count++;
      }
    }
    return count;
  }

}