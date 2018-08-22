package edu.kings.cs232.project1;

/**
 * Class used for encrypting and decrypting in a "RailFence"-like form.
 * 
 * @author Andrea Siejna
 * 
 */
public class RailFence extends CypherText {

    /**
     * Constructor for the RailFence class
     */
    public RailFence() {
        super();
    }

    /**
     * Encrypts text.
     * 
     * @param plainText
     *            Regular text that will be encrypted.
     * @param key
     *            Key used to encrypt text.
     */
    @Override
    public void encryptText(String plainText, int key) {
        String encryptedText = "";

        // avoid error, remove spaces and turn to uppercase
        plainText = plainText.replaceAll(" ", "");
        plainText = plainText.toUpperCase();

        int cols = 0;

        int numOfExtraLetters = 0;
        int remainingLetters = 0;

        // if the length isn't an even division of the key (to make cols)
        if (plainText.length() % key != 0) {

            // Take the remaining numbers left over in a to-be column
            remainingLetters = (plainText.length() % key);

            // Subtract the key by the remaining letters to find how many "J"'s
            // there would be
            numOfExtraLetters = key - remainingLetters;

            // The new length of the string is the old length plus the J's
            int newLength = plainText.length() + numOfExtraLetters;

            // Use this to find new number of columns to evenly split the string
            // into
            cols = (newLength / key);

        } else {
            cols = plainText.length() / key;
        }

        // key = rows, cols = cols;
        char[][] railFenceTable = new char[key][cols];

        // Where to begin the character count of the old string
        int charCount = 0;

        // Loop through each column
        for (int i = 0; i < cols; i++) {

            // Loop through each row
            for (int j = 0; j < key; j++) {

                // Grabs the specific letter from the old string
                // If count went over the plainText's strings then add a random
                // "J"
                if (charCount < plainText.length()) {

                    // Set that specific index in the row/column to the letter
                    // at that count
                    railFenceTable[j][i] = plainText.charAt(charCount++);

                } else {
                    railFenceTable[j][i] = 'J';
                }
            }
        }

        // Loop through the rows
        for (int i = 0; i < key; i++) {

            // Loop through the columns
            for (int j = 0; j < cols; j++) {

                // Take that specific char value, turn into String and concat to
                // the encryptedText that will be returned
                encryptedText = encryptedText.concat(String.valueOf(railFenceTable[i][j]));

            }

        }

        // Turn to StringBuilder to handle better
        StringBuilder encryptedTextBuild = new StringBuilder(encryptedText);

        // Loop through each letter and add spaces after each fifth letter
        for (int i = 0; i < encryptedTextBuild.length(); i += 6) {

            // Insert space
            encryptedTextBuild.insert(i, " ");

        }

        // Turn the builder back into the string
        // and trim whitespace
        encryptedText = encryptedTextBuild.toString();
        encryptedText = encryptedText.trim();

        // Set cypherText to the now encryptedText
        setCypherText(encryptedText);
    }

    /**
     * Decrypts text.
     * 
     * @param key
     *            Key used to decrypt text.
     * @return decryptedText Text that was decrypted.
     */
    @Override
    public String decryptText(int key) {
        
        String cypheredText = getCypherText();

        String decryptedText = "";

        // avoid error, turn to uppercase
        cypheredText = cypheredText.toUpperCase();
        cypheredText = cypheredText.replaceAll(" ", "");

        int numOfExtraLetters = 0;
        int remainingLetters = 0;
        int cols = 0;

        // if the length isn't an even division of the key (to make cols)
        if (cypheredText.length() % key != 0) {

            // Take the remaining numbers left over in a to-be column
            remainingLetters = (cypheredText.length() % key);

            // Subtract the key by the remaining
            // letters to find how many "J"'s
            // there would be
            numOfExtraLetters = key - remainingLetters;

            // The new length of the string is the old length plus the J's
            int newLength = cypheredText.length() + numOfExtraLetters;

            // Use this to find new number of columns to evenly split the string
            // into
            cols = (newLength / key);

        } else {
            cols = cypheredText.length() / key;
        }

        // key = rows, cols = cols;
        char[][] railFenceTable = new char[key][cols];

        // Where to begin the character count of the old string
        int charCount = 0;

        // Loop through each row
        for (int i = 0; i < key; i++) {

            // Loop through each column
            for (int j = 0; j < cols; j++) {

                // Grabs the specific letter from the old string
                // If count went over the encryptedText's strings then do
                // nothing
                if (charCount < cypheredText.length()) {

                    // Set that specific index in the row/column to the letter
                    // at that count
                    char charText = cypheredText.charAt(charCount++);

                    railFenceTable[i][j] = charText;

                }
            }
        }

        // Loop through the columns
        for (int i = 0; i < cols; i++) {

            // Loop through the rows
            for (int j = 0; j < key; j++) {

                // Take that specific char value, turn into String and concat to
                // the decrypted text that will be returned
                decryptedText = decryptedText.concat(String.valueOf(railFenceTable[j][i]));

            }

        }

        // TODO FIGURE OUT HOW TO REMOVE EXTRA LETTERS AT END

        // StringBuilder decryptedTextBuild = new StringBuilder(decryptedText);
        //
        // decryptedTextBuild.reverse();
        //
        // //Reverse String to remove LAST two extra J's from string
        // decryptedText = decryptedTextBuild.toString();
        //
        // //For however many extra letters exist, remove a 'J' - padding
        // for (int i = 0; i < remainingLetters; i++) {
        //
        //
        // decryptedText = decryptedText.replaceFirst("J", "");
        //
        //
        // }
        //
        // decryptedTextBuild.reverse();
        //
        // //Reverse String to remove LAST two extra J's from string
        // decryptedText = decryptedTextBuild.toString();
        //

        return decryptedText;
    }

}