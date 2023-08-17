package a.crud.h2.app.exception;

public class ResourceNotFoundException extends Exception { // RuntimeException

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
