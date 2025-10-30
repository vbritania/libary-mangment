import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        
        // Test bucher hinzufuegen - Mangas und Comics
        library.addbook(new Book("Tatsuki Fujimoto", "Fire Punch", false, 1));
        library.addbook(new Book("Tatsuki Fujimoto", "Chainsaw Man", false, 2));
        library.addbook(new Book("Takehiko Inoue", "Vagabond", false, 3));
        library.addbook(new Book("Inio Asano", "Goodnight Punpun", false, 4));
        library.addbook(new Book("Q Hayashida", "Dorohedoro", false, 5));
        
        // Test user hinzufuegen
        library.adduser(new User("admin", "admin123", true));
        library.adduser(new User("kuzi", "67", false));
        library.adduser(new User("lina", "123456", false));
        
        boolean programmLaeuft = true;
        
        while (programmLaeuft) {
            System.out.println("Willkommen in der Bibliothek");
            System.out.println("1. Als Admin anmelden");
            System.out.println("2. Als User anmelden"); 
            System.out.println("3. Programm beenden");
            System.out.print("Was moechtest du tun: ");
            
            int auswahl = scanner.nextInt();
            scanner.nextLine();
            
            if (auswahl == 1) {
                // Admin login
                System.out.print("Dein Benutzername: ");
                String benutzer = scanner.nextLine();
                System.out.print("Dein Passwort: ");
                String passwort = scanner.nextLine();
                
                User user = library.findUserByUsername(benutzer);
                if (user != null && user.getpassword().equals(passwort) && user.isAdmin()) {
                    System.out.println("Login erfolgreich! Hallo Admin");
                    adminMenu(library, scanner);
                } else {
                    System.out.println("Falsche Daten oder kein Admin");
                }
                
            } else if (auswahl == 2) {
                // User login
                System.out.print("Dein Benutzername: ");
                String benutzer = scanner.nextLine();
                System.out.print("Dein Passwort: ");
                String passwort = scanner.nextLine();
                
                User user = library.findUserByUsername(benutzer);
                if (user != null && user.getpassword().equals(passwort)) {
                    System.out.println("Login erfolgreich! Hallo " + user.getbenutzer());
                    userMenu(library, scanner, user);
                } else {
                    System.out.println("Falsche Login Daten");
                }
                
            } else if (auswahl == 3) {
                // Programm beenden
                programmLaeuft = false;
                System.out.println("Bis bald!");
            } else {
                System.out.println("Das war keine gute Auswahl");
            }
        }
        scanner.close();
    }
    
    public static void adminMenu(Library library, Scanner scanner) {
        boolean imAdminMenu = true;
        
        while (imAdminMenu) {
            System.out.println("Admin Menu");
            System.out.println("1. Neues Buch hinzufuegen");
            System.out.println("2. Alle Buecher anzeigen");
            System.out.println("3. Alle User anzeigen");
            System.out.println("4. Zurueck zum Hauptmenu");
            System.out.print("Was moechtest du tun: ");
            
            int auswahl = scanner.nextInt();
            scanner.nextLine();
            
            if (auswahl == 1) {
                // Buch hinzufuegen
                System.out.print("Autor des Buches: ");
                String autor = scanner.nextLine();
                System.out.print("Titel des Buches: ");
                String titel = scanner.nextLine();
                System.out.print("Book ID: ");
                int bookId = scanner.nextInt();
                scanner.nextLine();
                
                library.addbook(new Book(autor, titel, false, bookId));
                System.out.println("Buch wurde hinzugefuegt");
                
            } else if (auswahl == 2) {
                // Alle buecher anzeigen
                System.out.println("Alle Buecher in der Bibliothek:");
                library.showAllBooks();
                
            } else if (auswahl == 3) {
                // Alle user anzeigen
                System.out.println("Alle User:");
                library.showAllUsers();
                
            } else if (auswahl == 4) {
                // Zurueck zum hauptmenu
                imAdminMenu = false;
            } else {
                System.out.println("Das war keine gute Auswahl");
            }
        }
    }
    
    public static void userMenu(Library library, Scanner scanner, User user) {
        boolean imUserMenu = true;
        
        while (imUserMenu) {
            System.out.println("User Menu - Hallo " + user.getbenutzer());
            System.out.println("1. Verfuegbare Buecher anzeigen");
            System.out.println("2. Buch ausleihen");
            System.out.println("3. Buch zurueckgeben");
            System.out.println("4. Meine ausgeliehenen Buecher anzeigen");
            System.out.println("5. Ausloggen");
            System.out.print("Was moechtest du tun: ");
            
            int auswahl = scanner.nextInt();
            scanner.nextLine();
            
            if (auswahl == 1) {
                // Verfuegbare buecher anzeigen
                System.out.println("Verfuegbare Buecher:");
                library.showAvailableBooks();
                
            } else if (auswahl == 2) {
                // Buch ausleihen
                System.out.print("Book ID die du ausleihen willst: ");
                int bookId = scanner.nextInt();
                scanner.nextLine();
                
                Book buch = library.searchbookbyid(bookId);
                if (buch != null) {
                    user.borrowBook(buch);
                } else {
                    System.out.println("Buch mit dieser ID gibt es nicht");
                }
                
            } else if (auswahl == 3) {
                // Buch zurueckgeben
                System.out.print("Book ID die du zurueckgeben willst: ");
                int bookId = scanner.nextInt();
                scanner.nextLine();
                
                user.returnbookById(bookId);
                
            } else if (auswahl == 4) {
                // Ausgeliehene buecher anzeigen
                user.showBorrowedBooks();
                
            } else if (auswahl == 5) {
                // Ausloggen
                imUserMenu = false;
                System.out.println("Erfolgreich ausgeloggt");
            } else {
                System.out.println("Das war keine gute Auswahl");
            }
        }
    }
}