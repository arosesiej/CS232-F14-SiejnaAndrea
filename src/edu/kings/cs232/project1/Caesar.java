package edu.kings.cs232.project1;

/**
 * Class used for encrypting and decrypting in a "Caesar"-like form.
 * 
 * @author Andrea Siejna
 * 
 */
public class Caesar extends CypherText {

    /**
     * Constructor for the Caesar class
     */
    public Caesar() {
        super();
    }

    /**
     * Encrypts text.
     * 
     * @param plainText
     *            Regular text that will be encrypted
     * @param key
     *            Key used to encrypt text
     */
    @Override
    public void encryptText(String plainText, int key) {
        // Create string holder
        String encryptedText = "";

        // to avoid error with unicode chars, ensure it is lowercase
        plainText = plainText.toLowerCase();

        // turn to char array
        char[] plainTextArray = plainText.toCharArray();

        // Loop through each letter of the plain text
        for (int i = 0; i < plainTextArray.length; i++) {

            // Sees if its white space, which in this case just concatenate
            if (plainTextArray[i] == ' ') {

                encryptedText = encryptedText.concat(String.valueOf(plainTextArray[i]));

            } else {

                // Grab the location of the letter in respect to
                // the unicode
                int location = plainTextArray[i] - 97;

                // Take the location and shift, then mod by alphabet length (26)
                // to ensure ONLY ABC characters, not other unicode ones
                // Referred to Java ASCII unicode chart
                int letterShift = ((location + key) % 26);

                // Switch location of the letter back into a letter
                char encryptedLetter = ((char) (letterShift + 97));

                // Concat to String, take value of since its a char
                encryptedText = encryptedText.concat(String.valueOf(encryptedLetter));

            }

        }

        // Set the cypher text to its encryption

        setCypherText(encryptedText);
    }

    /**
     * 
     * Decrypts text.
     * 
     * @param key
     *            Key used to decrypt text
     * @return decryptedText Decrypted text
     */
    @Override
    public String decryptText(int key) {

        String decryptedText = "";
        String cypheredText = getCypherText();

        // Ensures we have text to work with
        if (cypheredText != "" || cypheredText != null) {

            cypheredText = cypheredText.toLowerCase();
            char[] cypherTextArray = cypheredText.toCharArray();

            for (int i = 0; i < cypherTextArray.length; i++) {

                if (cypherTextArray[i] == ' ') {

                    decryptedText = decryptedText.concat(String.valueOf(cypherTextArray[i]));
                } else {

                    int location = cypherTextArray[i] - 97;
                    int letterShift = ((location - key) % 26);
                    char decryptedLetter = 0;

                    if (letterShift < 0) {
                        decryptedLetter = ((char) (letterShift + 122 + 1));

                    } else {
                        decryptedLetter = ((char) (letterShift + 97));
                    }
                    decryptedText = decryptedText.concat(String.valueOf(decryptedLetter));

                }

            }

        } else {

        }

        return decryptedText;

    }

}
