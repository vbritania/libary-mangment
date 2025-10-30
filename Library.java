import java.util.ArrayList;

public class Library {
    private ArrayList<Book> booklist;
    private ArrayList<User> userlist;
    
    public Library() {
        this.booklist = new ArrayList<>();
        this.userlist = new ArrayList<>();
    }

    //add funktionen
    public void addbook(Book book){
        booklist.add(book);
    }

    public void adduser(User benutzer){
        userlist.add(benutzer);
    }

    //get funktionen
    public ArrayList<Book> getbooklist(){
        return booklist;
    }
    
    public ArrayList<User> getuserlist(){
        return userlist;
    }

    //such funktionen 
    public Book searchbookbyid(int bookId){
        for (Book book : booklist) {  
            if (book.getbookid() == bookId) {
                return book;
            }
        }
        return null;
    }

    //User nach Benutzername finden
    public User findUserByUsername(String username) {
        for (User user : userlist) {
            if (user.getbenutzer().equals(username)) {
                return user;
            }
        }
        return null;
    }

    //Alle Buecher anzeigen
    public void showAllBooks() {
        for (Book book : booklist) {
            System.out.println(book.toString());
        }
    }

    //Verfuegbare Buecher anzeigen
    public void showAvailableBooks() {
        for (Book book : booklist) {
            if (!book.istAusgeliehen()) {
                System.out.println(book.toString());
            }
        }
    }

    //Alle User anzeigen
    public void showAllUsers() {
        for (User user : userlist) {
            System.out.println(user.toString());
        }
    }
}