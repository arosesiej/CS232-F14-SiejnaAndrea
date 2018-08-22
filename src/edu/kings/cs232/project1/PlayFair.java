package edu.kings.cs232.project1;

/**
 * Class used for encrypting and decrypting in a "PlayFair"-like form.
 * 
 * @author Andrea Siejna
 * 
 */
public class PlayFair extends CypherText {

    /**
     * Constructor for the PlayFair class
     */
    public PlayFair() {
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
        String encryptedText = "";

        // Avoid error, turn to lowercase, remove spaces
        key = key.toLowerCase();
        key = key.replaceAll(" ", "");

        plainText = plainText.toLowerCase();
        plainText = plainText.replaceAll(" ", "");

        // Alphabet to generate key table (J is replaced with I only)
        String alphabet = "abcdefghiklmnopqrstuvwxyz";

        // Loop through each letter of the builder(key)
        // and compare it to the alphabet. If the letter
        // is in the key, then remove it from the alphabet
        // and the key too
        for (int i = 0; i < key.length(); i++) {

            // Grab letter at specific index in the keyBuilder
            String letter = String.valueOf(key.charAt(i));

            // Remove letter from alphabet
            alphabet = alphabet.replaceAll(letter, "");

        }
        // Create a new key to use for the key table
        String newKey = "";

        // Loop through each letter in the key
        for (int i = 0; i < key.length(); i++) {

            // If the new key doesn't contain the letter at that index,
            // then add it to the new key
            if (!newKey.contains(String.valueOf(key.charAt(i)))) {
                newKey = newKey.concat(String.valueOf(key.charAt(i)));
            }

        }

        // Make key the same as new key plus the new alphabet
        key = newKey;
        key = key.concat(alphabet);

        int rows = 5;
        int cols = 5;

        // Create a table of this keyword
        String[][] keywordTable = new String[rows][cols];

        // Create a count for the specific letter
        // in the keyword
        int letterCount = 0;

        // Loop through each column
        for (int i = 0; i < cols; i++) {

            // Loop through each row
            for (int j = 0; j < rows; j++) {

                // Grab the letter in the keyword string
                // Increment letter count

                String letter = String.valueOf(key.charAt(letterCount++));

                // Set this location to letter
                keywordTable[i][j] = letter;

            }

        }

        // FINISHED CREATING THE ACCURATE KEY TABLE

        // BEGIN TO CREATE ACCURATE DIAGRAPHS OF SECRET MESSAGE

        // See if plainText can be evenly broken up
        // Otherwise, add X to the end
        if (plainText.length() % 2 == 0) {

        } else {
            plainText = plainText.concat("x");
        }

        // Create diagraphs
        // Create an index for each pair of letters,
        String[] plainTextArray = new String[plainText.length() / 2];

        // Create a count for the specific letter
        // in the keyword
        int plainTextLetterCount = 0;

        // Loop through each index in the array
        for (int i = 0; i < plainTextArray.length; i++) {

            // Grab pair
            String pair = String.valueOf(plainText.charAt(plainTextLetterCount))
                    + String.valueOf(plainText.charAt(plainTextLetterCount + 1));

            // Increment letter count in the plainText
            plainTextLetterCount += 2;

            plainTextArray[i] = pair;

        }

        // BEGIN CHECKS FOR 1ST CONDITION
        // Check to see if pairs are the same letter
        // Loop through each pair
        // See if change happened

        String newPlainText = "";
        boolean xChange = false;
        for (int i = 0; i < plainTextArray.length; i++) {

            String letterOne = String.valueOf(plainTextArray[i].charAt(0));
            String letterTwo = String.valueOf(plainTextArray[i].charAt(1));

            // If yes then add an 'X' between
            if (letterOne.equals(letterTwo)) {
                plainTextArray[i] = letterOne + "x" + letterTwo;
                xChange = true;
            }

            newPlainText += plainTextArray[i];
        }

        // if it was the case that there was an X,
        // Create new diagraphs
        if (xChange) {
            // Create diagraphs
            // Create an index for each pair of letters,
            String[] newPlainTextArray = new String[newPlainText.length() / 2];

            // Create a count for the specific letter
            // in the keyword
            int newPlainTextLetterCount = 0;

            // Loop through each index in the array
            for (int i = 0; i < newPlainTextArray.length; i++) {

                // Grab pair
                String pair = String.valueOf(newPlainText.charAt(newPlainTextLetterCount))
                        + String.valueOf(newPlainText.charAt(newPlainTextLetterCount + 1));

                // Increment letter count in the plainText
                newPlainTextLetterCount += 2;

                newPlainTextArray[i] = pair;

            }

            plainTextArray = newPlainTextArray;
        }

        // FINISHED 1ST CONDITION

        // Create Strings of each row in the keyword table
        String row0 = "";
        String row1 = "";
        String row2 = "";
        String row3 = "";
        String row4 = "";

        for (int col = 0; col < 5; col++) {
            row0 = row0.concat(keywordTable[0][col]);
        }

        for (int col = 0; col < 5; col++) {
            row1 = row1.concat(keywordTable[1][col]);
        }

        for (int col = 0; col < 5; col++) {
            row2 = row2.concat(keywordTable[2][col]);
        }

        for (int col = 0; col < 5; col++) {
            row3 = row3.concat(keywordTable[3][col]);
        }

        for (int col = 0; col < 5; col++) {
            row4 = row4.concat(keywordTable[4][col]);
        }

        // Create Strings of each column in the keyword table
        String col0 = "";
        String col1 = "";
        String col2 = "";
        String col3 = "";
        String col4 = "";

        for (int row = 0; row < 5; row++) {
            col0 = col0.concat(keywordTable[row][0]);
        }

        for (int row = 0; row < 5; row++) {
            col1 = col1.concat(keywordTable[row][1]);
        }

        for (int row = 0; row < 5; row++) {
            col2 = col2.concat(keywordTable[row][2]);
        }

        for (int row = 0; row < 5; row++) {
            col3 = col3.concat(keywordTable[row][3]);
        }

        for (int row = 0; row < 5; row++) {
            col4 = col4.concat(keywordTable[row][4]);
        }

        // Loop through each pair
        for (int i = 0; i < plainTextArray.length; i++) {

            // Grab first and second letter of each pair
            char plainFirstLetter = plainTextArray[i].charAt(0);
            char plainSecondLetter = plainTextArray[i].charAt(1);

            // Create placeholders for the first letter's location
            // in the row and do the same for the second letter.

            int plainFirstLocationInKeyRow = 0;
            int plainSecondLocationInKeyRow = 0;

            // Create placeholders for the first letter's location
            // in the column and do the same for the second letter.

            int plainFirstLocationInKeyCol = 0;
            int plainSecondLocationInKeyCol = 0;

            // Create placeholder for the row in which each letter
            // can be found in as well.
            String rowFirstFound = "";
            String rowSecondFound = "";

            // Create placeholder for the column in which each letter
            // can be found in as well.
            String colFirstFound = "";
            String colSecondFound = "";

            // Find what row the first letter is in
            // as well as its location in the row
            if ((row0.indexOf(plainFirstLetter)) != -1) {
                plainFirstLocationInKeyRow = row0.indexOf(plainFirstLetter);
                rowFirstFound = row0;
            } else if ((row1.indexOf(plainFirstLetter)) != -1) {
                plainFirstLocationInKeyRow = row1.indexOf(plainFirstLetter);
                rowFirstFound = row1;
            } else if ((row2.indexOf(plainFirstLetter)) != -1) {
                plainFirstLocationInKeyRow = row2.indexOf(plainFirstLetter);
                rowFirstFound = row2;
            } else if ((row3.indexOf(plainFirstLetter)) != -1) {
                plainFirstLocationInKeyRow = row3.indexOf(plainFirstLetter);
                rowFirstFound = row3;
            } else if (((row4.indexOf(plainFirstLetter)) != -1)) {
                plainFirstLocationInKeyRow = row4.indexOf(plainFirstLetter);
                rowFirstFound = row4;
            }

            // Find what row the second letter is in
            // as well as its location in the row
            if ((row0.indexOf(plainSecondLetter)) != -1) {
                plainSecondLocationInKeyRow = row0.indexOf(plainSecondLetter);
                rowSecondFound = row0;
            } else if ((row1.indexOf(plainSecondLetter)) != -1) {
                plainSecondLocationInKeyRow = row1.indexOf(plainSecondLetter);
                rowSecondFound = row1;
            } else if ((row2.indexOf(plainSecondLetter)) != -1) {
                plainSecondLocationInKeyRow = row2.indexOf(plainSecondLetter);
                rowSecondFound = row2;

            } else if ((row3.indexOf(plainSecondLetter)) != -1) {
                plainSecondLocationInKeyRow = row3.indexOf(plainSecondLetter);
                rowSecondFound = row3;

            } else if (((row4.indexOf(plainSecondLetter)) != -1)) {
                plainSecondLocationInKeyRow = row4.indexOf(plainSecondLetter);
                rowSecondFound = row4;
            }

            // Find what column the first letter is in
            // as well as its location in the column
            if ((col0.indexOf(plainFirstLetter)) != -1) {
                plainFirstLocationInKeyCol = col0.indexOf(plainFirstLetter);
                colFirstFound = col0;
            } else if ((col1.indexOf(plainFirstLetter)) != -1) {
                plainFirstLocationInKeyCol = col1.indexOf(plainFirstLetter);
                colFirstFound = col1;
            } else if ((col2.indexOf(plainFirstLetter)) != -1) {
                plainFirstLocationInKeyCol = col2.indexOf(plainFirstLetter);
                colFirstFound = col2;
            } else if ((col3.indexOf(plainFirstLetter)) != -1) {
                plainFirstLocationInKeyCol = col3.indexOf(plainFirstLetter);
                colFirstFound = col3;
            } else if (((col4.indexOf(plainFirstLetter)) != -1)) {
                plainFirstLocationInKeyCol = col4.indexOf(plainFirstLetter);
                colFirstFound = col4;
            }

            // Find what column the second letter is in
            // as well as its location in the column
            if ((col0.indexOf(plainSecondLetter)) != -1) {
                plainSecondLocationInKeyCol = col0.indexOf(plainSecondLetter);
                colSecondFound = col0;
            } else if ((col1.indexOf(plainSecondLetter)) != -1) {
                plainSecondLocationInKeyCol = col1.indexOf(plainSecondLetter);
                colSecondFound = col1;
            } else if ((col2.indexOf(plainSecondLetter)) != -1) {
                plainSecondLocationInKeyCol = col2.indexOf(plainSecondLetter);
                colSecondFound = col2;
            } else if ((col3.indexOf(plainSecondLetter)) != -1) {
                plainSecondLocationInKeyCol = col3.indexOf(plainSecondLetter);
                colSecondFound = col3;
            } else if (((col4.indexOf(plainSecondLetter)) != -1)) {
                plainSecondLocationInKeyCol = col4.indexOf(plainSecondLetter);
                colSecondFound = col4;
            }

            // 2nd condition for PlayFair
            // If they're in the same row, replace with letter to their right
            // and wrap accordingly to that row.
            if (rowFirstFound.equals(rowSecondFound)) {

                plainFirstLetter = rowFirstFound.charAt((plainFirstLocationInKeyRow + 1) % 5);
                plainSecondLetter = rowSecondFound.charAt((plainSecondLocationInKeyRow + 1) % 5);

            }

            // 3rd condition for PlayFair
            // If they're in the same column, replace with letter underneath
            // and wrap accordingly to that column.
            else if (colFirstFound.equals(colSecondFound)) {

                plainFirstLetter = colFirstFound.charAt((plainFirstLocationInKeyCol + 1) % 5);
                plainSecondLetter = colSecondFound.charAt((plainSecondLocationInKeyCol + 1) % 5);

            }

            // 4th condition
            // Otherwise replace them with the corresponding
            // location of the other letter's location in the
            // same letter's own row
            else {
                plainFirstLetter = rowFirstFound.charAt(plainSecondLocationInKeyRow);
                plainSecondLetter = rowSecondFound.charAt(plainFirstLocationInKeyRow);
            }

            // Set this pair to its new characters
            plainTextArray[i] = "" + plainFirstLetter + plainSecondLetter;
        }

        for (int i = 0; i < plainTextArray.length; i++) {
            encryptedText = encryptedText.concat(plainTextArray[i] + " ");
        }

        encryptedText = encryptedText.trim();
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
        String cypherText = getCypherText();

        // Avoid error, turn to lowercase, remove spaces
        key = key.toLowerCase();
        key = key.replaceAll(" ", "");

        cypherText = cypherText.toLowerCase();
        cypherText = cypherText.replaceAll(" ", "");

        // Alphabet to generate key table (J is replaced with I only)
        String alphabet = "abcdefghiklmnopqrstuvwxyz";

        // Loop through each letter of the builder(key)
        // and compare it to the alphabet. If the letter
        // is in the key, then remove it from the alphabet
        // and the key too
        for (int i = 0; i < key.length(); i++) {

            // Grab letter at specific index in the keyBuilder
            String letter = String.valueOf(key.charAt(i));

            // Remove letter from alphabet
            alphabet = alphabet.replaceAll(letter, "");

        }
        // Create a new key to use for the key table
        String newKey = "";

        // Loop through each letter in the key
        for (int i = 0; i < key.length(); i++) {

            // If the new key doesn't contain the letter at that index,
            // then add it to the new key
            if (!newKey.contains(String.valueOf(key.charAt(i)))) {
                newKey = newKey.concat(String.valueOf(key.charAt(i)));
            }

        }

        // Make key the same as new key plus the new alphabet
        key = newKey;
        key = key.concat(alphabet);

        int rows = 5;
        int cols = 5;

        // Create a table of this keyword
        String[][] keywordTable = new String[rows][cols];

        // Create a count for the specific letter
        // in the keyword
        int letterCount = 0;

        // Loop through each column
        for (int i = 0; i < cols; i++) {

            // Loop through each row
            for (int j = 0; j < rows; j++) {

                // Grab the letter in the keyword string
                // Increment letter count

                String letter = String.valueOf(key.charAt(letterCount++));

                // Set this location to letter
                keywordTable[i][j] = letter;

            }

        }

        // Create diagraphs
        // Create an index for each pair of letters,
        String[] cypherTextArray = new String[cypherText.length() / 2];

        // Create a count for the specific letter
        // in the keyword
        int cypherTextLetterCount = 0;

        // Loop through each index in the array
        for (int i = 0; i < cypherTextArray.length; i++) {

            // Grab pair
            String pair = String.valueOf(cypherText.charAt(cypherTextLetterCount))
                    + String.valueOf(cypherText.charAt(cypherTextLetterCount + 1));

            // Increment letter count in the cypherText
            cypherTextLetterCount += 2;

            cypherTextArray[i] = pair;

        }

        // Create Strings of each row in the keyword table
        String row0 = "";
        String row1 = "";
        String row2 = "";
        String row3 = "";
        String row4 = "";

        for (int col = 0; col < 5; col++) {
            row0 = row0.concat(keywordTable[0][col]);
        }

        for (int col = 0; col < 5; col++) {
            row1 = row1.concat(keywordTable[1][col]);
        }

        for (int col = 0; col < 5; col++) {
            row2 = row2.concat(keywordTable[2][col]);
        }

        for (int col = 0; col < 5; col++) {
            row3 = row3.concat(keywordTable[3][col]);
        }

        for (int col = 0; col < 5; col++) {
            row4 = row4.concat(keywordTable[4][col]);
        }

        // Create Strings of each column in the keyword table
        String col0 = "";
        String col1 = "";
        String col2 = "";
        String col3 = "";
        String col4 = "";

        for (int row = 0; row < 5; row++) {
            col0 = col0.concat(keywordTable[row][0]);
        }

        for (int row = 0; row < 5; row++) {
            col1 = col1.concat(keywordTable[row][1]);
        }

        for (int row = 0; row < 5; row++) {
            col2 = col2.concat(keywordTable[row][2]);
        }

        for (int row = 0; row < 5; row++) {
            col3 = col3.concat(keywordTable[row][3]);
        }

        for (int row = 0; row < 5; row++) {
            col4 = col4.concat(keywordTable[row][4]);
        }

        // Loop through each pair
        for (int i = 0; i < cypherTextArray.length; i++) {

            // Grab first and second letter of each pair
            char cypherFirstLetter = cypherTextArray[i].charAt(0);
            char cypherSecondLetter = cypherTextArray[i].charAt(1);

            // Create placeholders for the first letter's location
            // in the row and do the same for the second letter.

            int cypherFirstLocationInKeyRow = 0;
            int cypherSecondLocationInKeyRow = 0;

            // Create placeholders for the first letter's location
            // in the column and do the same for the second letter.

            int cypherFirstLocationInKeyCol = 0;
            int cypherSecondLocationInKeyCol = 0;

            // Create placeholder for the row in which each letter
            // can be found in as well.
            String rowFirstFound = "";
            String rowSecondFound = "";

            // Create placeholder for the column in which each letter
            // can be found in as well.
            String colFirstFound = "";
            String colSecondFound = "";

            // Find what row the first letter is in
            // as well as its location in the row
            if ((row0.indexOf(cypherFirstLetter)) != -1) {
                cypherFirstLocationInKeyRow = row0.indexOf(cypherFirstLetter);
                rowFirstFound = row0;
            } else if ((row1.indexOf(cypherFirstLetter)) != -1) {
                cypherFirstLocationInKeyRow = row1.indexOf(cypherFirstLetter);
                rowFirstFound = row1;
            } else if ((row2.indexOf(cypherFirstLetter)) != -1) {
                cypherFirstLocationInKeyRow = row2.indexOf(cypherFirstLetter);
                rowFirstFound = row2;
            } else if ((row3.indexOf(cypherFirstLetter)) != -1) {
                cypherFirstLocationInKeyRow = row3.indexOf(cypherFirstLetter);
                rowFirstFound = row3;
            } else if (((row4.indexOf(cypherFirstLetter)) != -1)) {
                cypherFirstLocationInKeyRow = row4.indexOf(cypherFirstLetter);
                rowFirstFound = row4;
            }

            // Find what row the second letter is in
            // as well as its location in the row
            if ((row0.indexOf(cypherSecondLetter)) != -1) {
                cypherSecondLocationInKeyRow = row0.indexOf(cypherSecondLetter);
                rowSecondFound = row0;
            } else if ((row1.indexOf(cypherSecondLetter)) != -1) {
                cypherSecondLocationInKeyRow = row1.indexOf(cypherSecondLetter);
                rowSecondFound = row1;
            } else if ((row2.indexOf(cypherSecondLetter)) != -1) {
                cypherSecondLocationInKeyRow = row2.indexOf(cypherSecondLetter);
                rowSecondFound = row2;

            } else if ((row3.indexOf(cypherSecondLetter)) != -1) {
                cypherSecondLocationInKeyRow = row3.indexOf(cypherSecondLetter);
                rowSecondFound = row3;

            } else if (((row4.indexOf(cypherSecondLetter)) != -1)) {
                cypherSecondLocationInKeyRow = row4.indexOf(cypherSecondLetter);
                rowSecondFound = row4;
            }

            // Find what column the first letter is in
            // as well as its location in the column
            if ((col0.indexOf(cypherFirstLetter)) != -1) {
                cypherFirstLocationInKeyCol = col0.indexOf(cypherFirstLetter);
                colFirstFound = col0;
            } else if ((col1.indexOf(cypherFirstLetter)) != -1) {
                cypherFirstLocationInKeyCol = col1.indexOf(cypherFirstLetter);
                colFirstFound = col1;
            } else if ((col2.indexOf(cypherFirstLetter)) != -1) {
                cypherFirstLocationInKeyCol = col2.indexOf(cypherFirstLetter);
                colFirstFound = col2;
            } else if ((col3.indexOf(cypherFirstLetter)) != -1) {
                cypherFirstLocationInKeyCol = col3.indexOf(cypherFirstLetter);
                colFirstFound = col3;
            } else if (((col4.indexOf(cypherFirstLetter)) != -1)) {
                cypherFirstLocationInKeyCol = col4.indexOf(cypherFirstLetter);
                colFirstFound = col4;
            }

            // Find what column the second letter is in
            // as well as its location in the column
            if ((col0.indexOf(cypherSecondLetter)) != -1) {
                cypherSecondLocationInKeyCol = col0.indexOf(cypherSecondLetter);
                colSecondFound = col0;
            } else if ((col1.indexOf(cypherSecondLetter)) != -1) {
                cypherSecondLocationInKeyCol = col1.indexOf(cypherSecondLetter);
                colSecondFound = col1;
            } else if ((col2.indexOf(cypherSecondLetter)) != -1) {
                cypherSecondLocationInKeyCol = col2.indexOf(cypherSecondLetter);
                colSecondFound = col2;
            } else if ((col3.indexOf(cypherSecondLetter)) != -1) {
                cypherSecondLocationInKeyCol = col3.indexOf(cypherSecondLetter);
                colSecondFound = col3;
            } else if (((col4.indexOf(cypherSecondLetter)) != -1)) {
                cypherSecondLocationInKeyCol = col4.indexOf(cypherSecondLetter);
                colSecondFound = col4;
            }

            // 2nd condition for PlayFair
            // If they're in the same row, replace with letter to their right
            // and wrap accordingly to that row.
            if (rowFirstFound.equals(rowSecondFound)) {

                cypherFirstLetter = rowFirstFound.charAt((cypherFirstLocationInKeyRow - 1) % 5);
                cypherSecondLetter = rowSecondFound.charAt((cypherSecondLocationInKeyRow - 1) % 5);

            }

            // 3rd condition for PlayFair
            // If they're in the same column, replace with letter underneath
            // and wrap accordingly to that column.
            else if (colFirstFound.equals(colSecondFound)) {

                cypherFirstLetter = colFirstFound.charAt((cypherFirstLocationInKeyCol - 1) % 5);
                cypherSecondLetter = colSecondFound.charAt((cypherSecondLocationInKeyCol - 1) % 5);

            }

            // 4th condition
            // Otherwise replace them with the corresponding
            // location of the other letter's location in the
            // same letter's own row
            else {
                cypherFirstLetter = rowFirstFound.charAt(cypherSecondLocationInKeyRow);
                cypherSecondLetter = rowSecondFound.charAt(cypherFirstLocationInKeyRow);
            }

            // Set this pair to its new characters
            cypherTextArray[i] = "" + cypherFirstLetter + cypherSecondLetter;
        }

        for (int i = 0; i < cypherTextArray.length; i++) {
            decryptedText = decryptedText.concat(cypherTextArray[i]);
        }

        return decryptedText;
    }

}