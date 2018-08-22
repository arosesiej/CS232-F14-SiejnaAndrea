package edu.kings.cs232.project1;

/**
 * Abstract class that holds the methods needed for cyphering text.
 * 
 * @author Andrea Siejna
 * @version 10.20.14
 * 
 */
public abstract class CypherText implements Cypher {

    /**
     * The cypher-ed text used in this class.
     */
    private String cypherText;

    /**
     * Constructor for the CypherText class.
     */
    public CypherText() {
        cypherText = "";
    }

    /**
     * Decrypts the cypher text using the key and returns the resulting String.
     * If called on a class that does not use this type of key, the exception is
     * thrown.
     * 
     * @param key
     *            Key used to decrypt text.
     * @return The decrypted text.
     * @throws InvalidOperationException
     *             Exception thrown when illegal key is used.
     */
    public String decryptText(int key) throws InvalidOperationException {
        throw new InvalidOperationException();
    }

    /**
     * Decrypts the cypher text using the key and returns the resulting String.
     * If called on a class that does not use this type of key, the exception is
     * thrown.
     * 
     * @param key
     *            Key used to decrypt text.
     * @return The decrypted text.
     * @throws InvalidOperationException
     *             Exception thrown when illegal key is used.
     * 
     */
    public String decryptText(String key) throws InvalidOperationException {
        throw new InvalidOperationException();
    }

    /**
     * Encrypts the given plainText using the key and then uses that to set the
     * instance’s cypher text. If called on a class that does not use this type
     * of key, the exception is thrown.
     * 
     * 
     * @param plainText
     *            The regular text to encrypt.
     * @param key
     *            Key used to encrypt text.
     * @throws InvalidOperationException
     *             Exception thrown when illegal key is used.
     */
    public void encryptText(String plainText, int key) throws InvalidOperationException {
        throw new InvalidOperationException();
    }

    /**
     * Encrypts the given plainText using the key and then uses that to set the
     * instance’s cypher text. If called on a class that does not use this type
     * of key, the exception is thrown.
     * 
     * 
     * @param plainText
     *            The regular text to encrypt.
     * @param key
     *            Key used to encrypt text.
     * @throws InvalidOperationException
     *             Exception thrown when illegal key is used.
     */
    public void encryptText(String plainText, String key) throws InvalidOperationException {
        throw new InvalidOperationException();
    }

    /**
     * Accessor method for the cypherText field. Returns the cypher text stored
     * in the instance. If the cypher text equals null or is the empty String
     * (i.e., “”), then this method should throw the NoSuchTextException.
     * 
     * @return cypherText The current cypher-ed text.
     * @throws NoSuchTextException
     *             Exception thrown when no such text exists.
     */
    public String getCypherText() throws NoSuchTextException {

        if (cypherText.equals("") || cypherText.equals(null)) {
            throw new NoSuchTextException();
        }

        return cypherText;
    }

    /**
     * Mutator method for the cypherText field. Specifies that the instance
     * should handle the given encrypted String.
     * 
     * @param text
     *            Text to set the cyphered text to.
     */
    public void setCypherText(String text) {
        cypherText = text;
    }

}
