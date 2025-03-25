public class Book {
    private String title;
    private int pageCount;

    public Book(String title, int pageCount) throws IllegalArgumentException {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty or null");
        }
        if (pageCount <= 0) {
            throw new IllegalArgumentException("Page count must be positive");
        }

        this