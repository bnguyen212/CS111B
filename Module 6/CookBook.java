import java.util.*;

public class CookBook extends Book implements Comparable<CookBook> {
  private int recipeCount;

  private static final int DEFAULT_RECIPE_COUNT = 100;

  public CookBook(String title, String author, int yearPublished, int recipeCount) {
    super(title, author, yearPublished);
    this.recipeCount = recipeCount;
  }

  public CookBook(String title, String author) {
    super(title, author);
    this.recipeCount = DEFAULT_RECIPE_COUNT;
  }

  public int getRecipeCount() {
    return recipeCount;
  }

  public void setRecipeCount(int recipeCount) {
    if (recipeCount > 0) {
      this.recipeCount = recipeCount;
    }
  }

  @Override
  public void read() {
    Random generator = new Random();
    int recipeNumber = generator.nextInt(recipeCount) + 1;
    System.out.println("Reading recipe #" + recipeNumber);
  }

  @Override
  public String toString() {
    return super.toString() + "\ncontains " + recipeCount + " recipes";
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof CookBook) {
      CookBook cb = (CookBook) obj;
      boolean sameTitle = getTitle().equals(cb.getTitle());
      boolean sameAuthor = getAuthor().equalsIgnoreCase(cb.getAuthor());
      boolean sameYearPublished = getYearPublished() == cb.getYearPublished();
      boolean sameRecipeCount = recipeCount == cb.recipeCount;
      return sameTitle && sameAuthor && sameYearPublished && sameRecipeCount;
    } else {
      return false;
    }
  }

  @Override
  public int compareTo(CookBook cb) {
    if (getTitle().equalsIgnoreCase(cb.getTitle())) {
      if (getAuthor().equals(cb.getAuthor())) {
        return recipeCount - cb.recipeCount;
      } else {
        return getAuthor().compareTo(cb.getAuthor());
      }
    } else {
      return getTitle().compareToIgnoreCase(cb.getTitle());
    }
  }

  public boolean isFeatured(int year, int recipeCount) {
    return getYearPublished() >= year && this.recipeCount >= recipeCount;
  }

}