package library.cloud.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class LibraryException extends ResponseStatusException {
    public LibraryException(HttpStatus status) {
        super(status);
    }

    public LibraryException(HttpStatus status, String reason) {
        super(status, reason);
    }

    public LibraryException(HttpStatus status, String reason, Throwable cause) {
        super(status, reason, cause);
    }
}
