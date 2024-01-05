package by.clever.servlet.dao.exception;

import java.io.Serial;

/**
 * Exception class to be thrown in DAO
 */
public class DAOException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 7665657603430758825L;

    public DAOException() {
        super();
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(Exception e) {
        super(e);
    }

    public DAOException(String message, Exception e) {
        super(message, e);
    }
}
