public class Book {
    private String author;
    private String title;
    private boolean ausgeliehen;
    private int bookid;
  
    //full konstrukter
    public Book(String author, String title, boolean ausgeliehen, int bookid){
        this.author = author;
        this.title = title;
        this.ausgeliehen = ausgeliehen;
        this.bookid = bookid;
    }

    //get funktionen
    public String getauthor() {
        return this.author;
    }
    public String gettitle() {
        return this.title;
    }
    public boolean getausgeliehen() {
        return this.ausgeliehen;
    }
    public int getbookid(){
        return this.bookid;
    }
    public boolean istAusgeliehen() {
        return ausgeliehen; 
    }

    //Andern von buch sachen
    public void settitle(String title){
        this.title = title;
    }

    public void setauthor(String author){
        this.author = author;
    }

    public void setausgeliehen(boolean status){
        this.ausgeliehen = status;
    }
    
    public void setbookid(int bookid){
        this.bookid = bookid;
    }

    //ausgeliehn true setzen bzw false
    public void ausleihen(){
        this.ausgeliehen = true;
    }

    public void zurueckgeben(){
        this.ausgeliehen = false;
    }
   
    
    @Override
    public String toString(){
        return "Der Author des Buches " + this.title + " ist " + this.author + " (" + this.bookid + " )";
    }
}