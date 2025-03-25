public class BookNotFoundException extends Exception {
    public BookNotFoundException(String message) {
        super(message);
    }
}

public class InvalidBookException extends Exception {
    public InvalidBookException(String message) {
        super(message);
    }
}

public class EmptyLibraryException extends Exception {
    public EmptyLibraryException(String message) {
        super(message);
    }
}
