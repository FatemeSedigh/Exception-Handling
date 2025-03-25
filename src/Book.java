public class Book {
    private final String title;
    private final int pageCount;

    public Book(String title, int pageCount) throws IllegalArgumentException {
        if (title == null) {
            throw new IllegalArgumentException("Title cannot be null");
        }

        if (title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }

        if (pageCount <= 0) {
            throw new IllegalArgumentException("Page count must be positive");
        }

        this.title = title.trim();
        this.pageCount = pageCount;
    }

    public String getTitle() {
        return title;
    }

    public int getPageCount() {
        return pageCount;
    }

    @Override
    public String toString() {
        return String.format("%s (%d pages)", title, pageCount);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Book other = (Book) obj;
        return pageCount == other.pageCount &&
                title.equals(other.title);
    }

    @Override
    public int hashCode() {
        return 31 * title.hashCode() + pageCount;
    }
}