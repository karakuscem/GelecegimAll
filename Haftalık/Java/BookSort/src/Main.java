import java.util.Set;
import java.util.TreeSet;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("The Lord of the Rings", 1000, "J. R. R. Tolkien", "1954");
        Book book2 = new Book("The Hobbit", 300, "J. R. R. Tolkien", "1937");
        Book book3 = new Book("The Silmarillion", 500, "J. R. R. Tolkien", "1977");
        Book book4 = new Book("The Children of Húrin", 250, "J. R. R. Tolkien", "2007");
        Book book5 = new Book("The Fall of Gondolin", 300, "J. R. R. Tolkien", "2018");

        Set<Book> books = new TreeSet<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        for (Book book : books) {
            System.out.println(book.getName());
        }
    }
}