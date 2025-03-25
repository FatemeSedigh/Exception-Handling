public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        handleLibraryOperation(() -> library.listBooks());

        Book[] booksToAdd = {
                createBookSafely("Java Programming", 300),
                createBookSafely("Design Patterns", -3),
                createBookSafely(null, 100),
                createBookSafely("", 400)
        };

        for (Book book : booksToAdd) {
            if (book != null) {
                handleLibraryOperation(() -> library.addBook(book));
            }
        }

        handleLibraryOperation(() -> library.listBooks());

        handleLibraryOperation(() -> library.borrowBook("Java Programming"));
        handleLibraryOperation(() -> library.returnBook("Clean Code"));
        handleLibraryOperation(() -> library.returnBook("Java Programming"));
    }

    private static Book createBookSafely(String title, int pageCount) {
        try {
            return new Book(title, pageCount);
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating book: " + e.getMessage());
            return null;
        }
    }

    private static void handleLibraryOperation(LibraryOperation operation) {
        try {
            operation.execute();
        } catch (EmptyLibraryException | BookNotFoundException | InvalidBookException e) {
            System.out.println(e.getMessage());
        }
    }

    @FunctionalInterface
    private interface LibraryOperation {
        void execute() throws EmptyLibraryException, BookNotFoundException, InvalidBookException;
    }
}