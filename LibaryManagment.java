
import java.util.Scanner;

public class LibaryManagment {

    private Book[] books = new Book[10];

    public LibaryManagment() {
        books[0] = new Book("Harry Potter", "J.K. Rowling");
        books[1] = new Book("Herr der Ringe", "J.R.R. Tolkien");
        books[2] = new Book("Goodnightpunpun", "");
        books[3] = new Book("Vagabound", "L.L");
        books[4] = new Book("The Climber", "L.L");
        books[5] = new Book("Firepunch", "L.L");
        books[6] = new Book("Eri", "L.L");
        books[7] = new Book("20th Century boys", "L.L");
        books[8] = new Book("The Legacy of 67", "L.L");
        books[9] = new Book("61% men 41% women", "Isreali");
    }

    public Book findbookbytitle(String title) {
        for (Book book : books) {
            if (book != null && book.getTitle().equalsIgnoreCase(title)) {
                return book, author;
            }
        }
        return null;
    }

    public Book findbookbyauthor(String author) {
        for (Book book : books) {
            if (book != null && book.getAuthor().equalsIgnoreCase(author)) {
                return author, book;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Geben sie den Title des Buches ein:");
        String title = scan.nextLine();
        LibaryManagment libary = new LibaryManagment();
        Book findbook = libary.findbookbytitle(title);
        String author = scan.nextLine();
        Book findauthor = libary.findbookbyauthor(author);

        if (findbook != null) {
            System.out.println("Buch gefunden: " + findbook);
        } else {
            System.out.println("Buch nicht gefunden.");
        }
        scan.close();
         System.out.println("Geben sie den Author des Buches ein:");
        if (findauthor != null) {
            System.out.println("Buch gefunden: " + findauthor);
        } else {
            System.out.println("Buch nicht gefunden.");
        }
        scan.close();   
    }

}

// Hilfsklasse Book
class Book {

    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return title + " von " + author;
    }
}
