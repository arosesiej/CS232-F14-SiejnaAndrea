package edu.kings.cs232.project1;

/**
 * Exception class used when there is no text present.
 * 
 * @author Andrea Siejna
 * @version 10.20.14
 * 
 */
public class NoSuchTextException extends RuntimeException {

    /**
     * ID
     */
    private static final long serialVersionUID = -9057746123197330693L;

    /**
     * Constructor for the NoSuchTextException class
     */
    public NoSuchTextException() {
        super();
    }

}
