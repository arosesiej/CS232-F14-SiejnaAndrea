package edu.kings.cs232.project1;

import java.util.Scanner;

/**
 * 
 * Main class in which a user can play with the ciphers.
 * 
 * @author Andrea Siejna
 * 
 */
public class Main {

    /**
     * Main class for a user to use the ciphers.
     * 
     * @param args
     */
    public static void main(String args[]) {

        // Create scanner for input
        Scanner inputCipher = new Scanner(System.in);

        // User input
        String userInput = "";

        String cypherText = "";
        String plainText = "";

        boolean finished = false;

        // Repeat until user types quit
        do {

            // Prompt user for cipher
            System.out.println("Which encryption algorithm would you like?");
            System.out.println("If none, then type 'quit'.");
            userInput = inputCipher.nextLine();
            userInput = userInput.toLowerCase();
            userInput = userInput.replaceAll(" ", "");

            // If quit then finished = true;
            if (userInput.equals("quit")) {
                finished = true;
            } 
            else {

                Scanner inputCrypt = new Scanner(System.in);

                // Prompt whether to encrypt or decrypt
                // Take the answer and modify to make it
                // easier to work with.
                System.out.println("Enter (1) for encrypt or "
                        + "(any other number) to decrypt: ");
                int answer = inputCrypt.nextInt();

                // answer - 1, anything else

                Scanner inputInt = new Scanner(System.in);
                
                Scanner inputString = new Scanner(System.in);

                if (answer == 1) {

                    // Prompt for text to encrypt and the key
                    System.out.println("Enter your text to encrypt:");
                    plainText = inputString.nextLine();

                    if (userInput.equals("caesar")) {
                        Caesar cipher = new Caesar();

                        System.out.println("Enter your key:");
                        int keyInt = inputInt.nextInt();

                        cipher.encryptText(plainText, keyInt);
                        System.out.println(cipher.getCypherText());
                        
                        
                    } else if (userInput.equals("railfence")) {
                        RailFence cipher = new RailFence();
                        
                        System.out.println("Enter your key:");
                        int keyInt = inputInt.nextInt();
                        
                        cipher.encryptText(plainText, keyInt);
                        System.out.println(cipher.getCypherText());
                        
                    } else if (userInput.equals("onetimepad")) {
                        OneTimePad cipher = new OneTimePad();
                        
                        System.out.println("Enter your key:");
                        String keyString = inputString.nextLine();
                        
                        cipher.encryptText(plainText, keyString);
                        System.out.println(cipher.getCypherText());
                        
                    } else if (userInput.equals("playfair")) {
                        PlayFair cipher = new PlayFair();
                        
                        System.out.println("Enter your key:");
                        String keyString = inputString.nextLine();
                        
                        cipher.encryptText(plainText, keyString);
                        System.out.println(cipher.getCypherText());
                        
                    } else {
                    }

                } else {

                    System.out.println("Enter your text to decrypt:");
                    cypherText = inputString.nextLine();
                    cypherText = cypherText.toLowerCase();
                    cypherText = cypherText.replaceAll(" ", "");

                    if (userInput.equals("caesar")) {
                        Caesar cipher = new Caesar();
                        
                        System.out.println("Enter your key:");
                        int keyInt = inputInt.nextInt();
                        
                        cipher.setCypherText(cypherText);
                        cipher.decryptText(keyInt);
                        
                    } else if (userInput.equals("railfence")) {
                        RailFence cipher = new RailFence();
                        
                        System.out.println("Enter your key:");
                        int keyInt = inputInt.nextInt();
                        
                        cipher.setCypherText(cypherText);
                        cipher.decryptText(keyInt);

                    } else if (userInput.equals("onetimepad")) {
                        OneTimePad cipher = new OneTimePad();
                        
                        System.out.println("Enter your key:");
                        String keyString = inputString.nextLine();
                        
                        cipher.setCypherText(cypherText);
                        cipher.decryptText(keyString);

                    } else if (userInput.equals("playfair")) {
                        PlayFair cipher = new PlayFair();
                        
                        System.out.println("Enter your key:");
                        String keyString = inputString.nextLine();
                        
                        cipher.setCypherText(cypherText);
                        cipher.decryptText(keyString);
                        
                    } else {
                    }

                }

            }

        } while (!finished);

    }
}