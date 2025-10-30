import java.util.ArrayList;

public class User {
    private String benutzer;
    private String password;
    private int userid;
    private ArrayList<Book> borrowedBooks;
    private boolean isAdmin;
    private static int nextuserid = 1; // Automatische ID-Vergabe

    // Konstruktor
    public User(String benutzer, String password, boolean isAdmin) {
        this.benutzer = benutzer;
        this.password = password;
        this.isAdmin = isAdmin;
        this.borrowedBooks = new ArrayList<>();
        this.userid = nextuserid;
        nextuserid++;
    }
    
    // get - show
    public String getbenutzer() {
        return this.benutzer;
    }
    public String getpassword() {
        return this.password;
    }
    
    public int getuserid(){
        return this.userid;
    }
    public boolean isAdmin(){
        return isAdmin;
    }

    public ArrayList<Book> getBorrowedBooks() { 
        return borrowedBooks; 
    }

    //Setter fur adminmenu
    public void setUsername(String username) {
         this.benutzer = username; 
        }

    public void setPassword(String password) {
         this.password = password; 
        }

    public void setAdmin(boolean isAdmin) { 
        this.isAdmin = isAdmin; 
    }

    //Buch ausleihen
    public boolean borrowBook(Book book) {
        if (!book.istAusgeliehen()) {
            borrowedBooks.add(book);
            book.ausleihen();
            System.out.println("Glueckwunsch du hast das Buch ausgeliehen");
            return true;
        } else {
            System.out.println("Das Buch ist bereits ausgeliehen");
            return false;
        }
    }
    
    //Buch zurueckgeben
    public boolean returnbook(Book borrowedBook){
        if (borrowedBooks.contains(borrowedBook)) {
            borrowedBooks.remove(borrowedBook);
            borrowedBook.zurueckgeben();
            System.out.println("Erfolgreich zurueckgegeben Glueckwunsch");
            return true;
        } else {
            System.out.println("Dieses Buch haben sie noch nicht ausgeliehen");
            return false;
        }
    }

    //buch zurueckgeben durch ID
    public boolean returnbookById(int bookId) {
        for (Book book : borrowedBooks) {
            if (book.getbookid() == bookId) {
                return returnbook(book);
            }
        }
        System.out.println("Buch nicht gefunden!");
        return false;
    }

    //Ausgeliehene Buecher anzeigen
    public void showBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("Keine Buecher ausgeliehen");
            return;
        }
        for (Book book : borrowedBooks) {
            System.out.println("ID: " + book.getbookid() + " | " + book.gettitle() + " von " + book.getauthor());
        }
    }

    
    @Override
    public String toString(){
        return this.benutzer + this.userid;
    }
}