package Library;

import java.util.*;

public class Library {
    private static final LibraryStore store = new LibraryStore();
    private static final List<Book> userStore = new ArrayList<>();

    private static boolean isAppRunning = true;

    public Library() {
        initializeLibrary();
    }


    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (isAppRunning) {
            System.out.print("Enter command: ");
            String[] commandLine = scanner.nextLine().split(" ");
            switch (commandLine[0]) {
                case "get" -> {
                    get(commandLine[1]);
                    System.out.println("\n\n\n");
                }
                case "put" -> {
                    put(commandLine[1]);
                    System.out.println("\n\n\n");
                }
                case "list" -> {
                    list();
                    System.out.println("\n\n\n");
                }
                case "all" -> {
                    all();
                    System.out.println("\n\n\n");
                }
                case "exit" -> {
                    System.out.println("App has been terminated.");
                    isAppRunning = false;
                }
                default -> {
                    System.out.println("Unknown command: " + commandLine[0]);
                    System.out.println("\n\n\n");
                }
            }
        }

    }

    private void get(String bookName) {
        var foundBooks = getBooksByName(bookName);

        if (isBooksListEmpty(foundBooks)) {
            return;
        }

        System.out.println("Choose book from the list:");
        boolean isBookSelected = false;
        Scanner scanner = new Scanner(System.in);
        while (!isBookSelected) {
            var bookIndex = scanner.nextInt();
            if (bookIndex < 1 || bookIndex > foundBooks.size()) {
                System.out.printf("Invalid number of book: %d. Repeat operation.\n", bookIndex);
                continue;
            }
            var selectedBook = foundBooks.get(bookIndex - 1);

            if (userStore.contains(selectedBook)) {
                System.out.println("This book has already been rented. Operation has been canceled.\n");
                return;
            }

            store.rentBook(selectedBook);
            userStore.add(selectedBook);
            isBookSelected = true;
            System.out.printf("Rented book: %s\n", selectedBook);
        }
    }

    private void put(String bookName) {
        ArrayList<Book> rentedBooks = new ArrayList<>();

        for (Book book : userStore) {
            if (book.getName().equals(bookName)) {
                rentedBooks.add(book);
            }
        }

        if (isBooksListEmpty(rentedBooks)) {
            return;
        }

        System.out.println("Choose book from the list:");
        boolean isBookSelected = false;
        Scanner scanner = new Scanner(System.in);
        while (!isBookSelected) {
            var bookIndex = scanner.nextInt();
            if (bookIndex < 1 || bookIndex > rentedBooks.size()) {
                System.out.printf("Invalid number of book: %d. Repeat operation.\n", bookIndex);
                continue;
            }
            var selectedBook = rentedBooks.get(bookIndex - 1);

            store.returnBook(selectedBook);
            userStore.remove(selectedBook);
            isBookSelected = true;
            System.out.printf("Returned book: %s\n", selectedBook);
        }
    }

    private boolean isBooksListEmpty(ArrayList<Book> bookList) {
        if (bookList.size() == 0) {
            System.out.println("No books found.");
            return true;
        }

        System.out.println("Found " + bookList.size() + " books:");
        for (int i = 0; i < bookList.size(); i++) {
            System.out.printf("(%d)\n%s\n", i + 1, bookList.get(i));
        }
        return false;
    }

    private void list() {
        if (userStore.size() == 0) {
            System.out.println("No books have been rented.");
            return;
        }
        System.out.println("Rented books:");
        for (int i = 0; i < userStore.size(); i++) {
            System.out.printf("(%d)\n%s\n", i + 1, userStore.get(i));
        }
    }

    private void all() {
        if (store.size() == 0) {
            System.out.println("No books in library.");
            return;
        }
        System.out.println("Books in library:");
        int index = 1;
        for (Map.Entry<Book, Integer> entry : store.entrySet()) {
            Optional<Integer> quantity = entry.getValue().describeConstable();
            if (quantity.isPresent()) {
                System.out.printf("(%d)\n%s\nQuantity:%s\n", index, entry.getKey(), entry.getValue());
            }
            index++;
        }
    }

    private ArrayList<Book> getBooksByName(String name) {
        ArrayList<Book> books = new ArrayList<>();
        for (Map.Entry<Book, Integer> entry : store.entrySet()) {
            if (entry.getKey().getName().equals(name)) {
                Optional<Integer> quantity = entry.getValue().describeConstable();
                if (quantity.isPresent() && quantity.get() > 0) {
                    books.add(entry.getKey());
                }
            }
        }
        return books;
    }

    private void initializeLibrary() {
        var authors1 = new ArrayList<String>();
        authors1.add("Mike");
        authors1.add("Jane");
        Book book1 = new Book("name1", "description", "1.1.2020", authors1);

        var authors2 = new ArrayList<String>();
        authors2.add("Mike");
        authors2.add("Kane");

        Book book2 = new Book("name2", "description", "1.1.2000", authors2);

        var authors3 = new ArrayList<String>();
        authors3.add("Mike");
        authors3.add("John");

        Book book3 = new Book("name3", "description", "1.1.2005", authors3);

        store.put(book1, 1);
        store.put(book2, 2);
        store.put(book3, 3);
    }
}
