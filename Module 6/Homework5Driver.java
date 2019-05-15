import java.util.*;

public class Homework5Driver {
  public static void main(String[] args) {
    // CookBook b1 = new CookBook("Dinners in 20 Minutes", "Brian Nguyen");
    // CookBook b2 = new CookBook("The Keto Diet", "Adam Sandler", 2018, 130);
    // CookBook b3 = new CookBook("Healthy Choices", "Jessica Masters", 2010, 50);
    // CookBook b4 = new CookBook("Eating Salad", "Angelina Jolie", 2017, 150);
    // ArrayList<CookBook> bookshelf = new ArrayList<CookBook>();
    // bookshelf.add(b1);
    // bookshelf.add(b2);
    // bookshelf.add(b3);
    // bookshelf.add(b4);
    // Collections.sort(bookshelf);
    // System.out.println(bookshelf);
    // for(CookBook book : bookshelf) {
    //   if (book.isFeatured(2015, 100)) {
    //     System.out.println(book);
    //   }
    // }

    Book b1 = new CookBook("The Keto Diet", "Adam Sandler");
    Book b2 = new CookBook("Eating Salad", "Angelina Jolie", 2017, 150);
    Book b3 = new ChildrenBook("Sleeping Beauty", "Charles Perrault", 1697);
    Book b4 = new ChildrenBook("Harry Potter and the Goblet of Fire", "J. K. Rowling", 2000);
    Book[] library = new Book[] {b1, b2, b3, b4};
    int totalRecipes = 0;
    for (Book book : library) {
      if (book instanceof CookBook) {
        CookBook cb = (CookBook) book;
        totalRecipes += cb.getRecipeCount();
      }
    }
    System.out.println("Total recipe count: " + totalRecipes);

  }
}