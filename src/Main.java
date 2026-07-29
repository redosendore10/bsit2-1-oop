import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    // ===== Book class =====
    static class Book {
        String title;
        String author;
        boolean checkedOut;

        Book(String title, String author) {
            this.title = title;
            this.author = author;
            this.checkedOut = false;
        }

        String status() {
            return checkedOut ? "Borrowed" : "Available";
        }

        public String toString() {
            return title + " by " + author + " [" + status() + "]";
        }
    }

    // ===== Library class
    static ArrayList<Book> catalog = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    // ===== Program entry point
    public static void main(String[] args) {
        int selection = -1;

        while (selection != 0) {
            printMenu();
            selection = getSelection();

            if (selection == 1) {
                addBook();
            } else if (selection == 2) {
                listBooks();
            } else if (selection == 3) {
                borrowBook();
            } else if (selection == 4) {
                returnBook();
            } else if (selection == 5) {
                searchBook();
            } else if (selection == 0) {
                System.out.println("Closing the library system. See you next time!");
            } else {
                System.out.println("That's not a valid option, try again.");
            }
        }

        input.close();
    }

    static void printMenu() {
        System.out.println();
        System.out.println("===== Library Menu =====");
        System.out.println("1. Add a book");
        System.out.println("2. List all books");
        System.out.println("3. Borrow a book");
        System.out.println("4. Return a book");
        System.out.println("5. Search a book");
        System.out.println("0. Exit");
        System.out.print("Choice: ");
    }

    static int getSelection() {
        String line = input.nextLine().trim();
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    static void addBook() {
        System.out.print("Title: ");
        String title = input.nextLine();
        System.out.print("Author: ");
        String author = input.nextLine();

        catalog.add(new Book(title, author));
        System.out.println("\"" + title + "\" has been added to the library.");
    }

    static void listBooks() {
        if (catalog.size() == 0) {
            System.out.println("The catalog is currently empty.");
            return;
        }

        System.out.println("---- Current Catalog ----");
        for (int i = 0; i < catalog.size(); i++) {
            System.out.println((i + 1) + ") " + catalog.get(i));
        }
    }

    static void borrowBook() {
        System.out.print("Title to borrow: ");
        String title = input.nextLine();
        int index = findBook(title);

        if (index == -1) {
            System.out.println("Could not find a book titled \"" + title + "\".");
            return;
        }

        Book book = catalog.get(index);
        if (book.checkedOut) {
            System.out.println("\"" + book.title + "\" is already checked out.");
        } else {
            book.checkedOut = true;
            System.out.println("Checked out: " + book.title);
        }
    }

    static void returnBook() {
        System.out.print("Title to return: ");
        String title = input.nextLine();
        int index = findBook(title);

        if (index == -1) {
            System.out.println("Could not find a book titled \"" + title + "\".");
            return;
        }

        Book book = catalog.get(index);
        if (!book.checkedOut) {
            System.out.println("\"" + book.title + "\" isn't checked out, nothing to return.");
        } else {
            book.checkedOut = false;
            System.out.println("Checked in: " + book.title);
        }
    }

    static void searchBook() {
        System.out.print("Title to search: ");
        String title = input.nextLine();
        int index = findBook(title);

        if (index == -1) {
            System.out.println("No matching book for \"" + title + "\".");
        } else {
            System.out.println("Match found -> " + catalog.get(index));
        }
    }

    static int findBook(String title) {
        for (int i = 0; i < catalog.size(); i++) {
            if (catalog.get(i).title.equalsIgnoreCase(title)) {
                return i;
            }
        }
        return -1;
    }
}
