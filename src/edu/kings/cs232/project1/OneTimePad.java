package edu.kings.cs232.project1;

/**
 * Class used for encrypting and decrypting in a "OneTimePad"-like form.
 * 
 * @author Andrea Siejna
 * 
 */
public class OneTimePad extends CypherText {

    /**
     * Constructor for the OneTimePad class
     */
    public OneTimePad() {
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
    public void encryptText(String plainText, String key) {

        // Create string holder
        String encryptedText = "";

        // To avoid error with unicode chars, ensure it is lowercase
        // and remove spaces
        plainText = plainText.toLowerCase();
        plainText = plainText.replaceAll(" ", "");
        key = key.toLowerCase();
        key = key.replaceAll(" ", "");

        // turn to char array
        char[] plainTextArray = plainText.toCharArray();
        char[] keyArray = key.toCharArray();

        // Loop through each letter of the plain text
        for (int i = 0; i < plainTextArray.length; i++) {

            // Sees if its white space, which in this case just concatenate
            if (plainTextArray[i] == ' ') {

                encryptedText = encryptedText.concat(String.valueOf(plainTextArray[i]));

            } else {

                // Grab the location of the letter in respect to the unicode
                int location = plainTextArray[i] - 97;

                // Do the same for the key
                int keyLocation = (keyArray[i] - 97);

                // Take the location and shift, then mod by alphabet length (26)
                // to ensure ONLY ABC characters, not other unicode ones
                // Referred to Java ASCII unicode chart
                int letterShift = ((location + keyLocation) % 26);

                // Switch location of the letter back into a letter
                char encryptedLetter = ((char) (letterShift + 97));

                // Concat to String, take value of since its a char
                encryptedText = encryptedText.concat(String.valueOf(encryptedLetter));

            }

        }

        // Set the cypher text to its encryption in all caps

        encryptedText = encryptedText.toUpperCase();
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
    public String decryptText(String key) {

        String decryptedText = "";
        String cypheredText = getCypherText();

        // Ensures we have text to work with
        if (cypheredText != "" || cypheredText != null) {

            cypheredText = cypheredText.toLowerCase();
            key = key.toLowerCase();
            key = key.replaceAll(" ", "");

            char[] cypherTextArray = cypheredText.toCharArray();
            char[] keyArray = key.toCharArray();

            for (int i = 0; i < cypherTextArray.length; i++) {

                if (cypherTextArray[i] == ' ') {

                    decryptedText = decryptedText.concat(String.valueOf(cypherTextArray[i]));
                } else {

                    int location = cypherTextArray[i] - 97;
                    int keyLocation = keyArray[i] - 97;

                    int letterShift = ((location - keyLocation) % 26);

                    char decryptedLetter = 0;

                    // If negative shift, do correct wrap-around
                    if (letterShift < 0) {

                        decryptedLetter = ((char) (letterShift + 122 + 1));

                        // Otherwise positive shift
                    } else {

                        decryptedLetter = ((char) (letterShift + 97));

                    }
                    decryptedText = decryptedText.concat(String.valueOf(decryptedLetter));

                }

            }

        } else {

        }

        decryptedText = decryptedText.toUpperCase();
        return decryptedText;

    }

}
