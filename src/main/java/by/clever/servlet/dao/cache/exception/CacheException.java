package by.clever.servlet.dao.cache.exception;

import java.io.Serial;

/**
 * Exception class for work with cashes
 */
public class CacheException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 5139757603430711247L;

    public CacheException() {
        super();
    }

    public CacheException(String message) {
        super(message);
    }

    public CacheException(Exception e) {
        super(e);
    }
    public CacheException(String message, Exception e) {
        super(message, e);
    }
}
