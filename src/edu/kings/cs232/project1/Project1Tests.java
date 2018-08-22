package edu.kings.cs232.project1;

/**
 * Test class for all the classes in this project.
 * 
 * @author Andrea Siejna
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class Project1Tests {

    // BEGIN OF CAESAR TEST CASES

    /**
     * Test method for Caesar's getCypherText method.
     */
    @Test
    public void testCaesarGetCypherText() {
        Caesar cypherTest = new Caesar();
        cypherTest.setCypherText("Hello");
        assertEquals("Incorrect accessor method", "Hello", cypherTest.getCypherText());
    }

    /**
     * Test method for Caesar's getCypherText method.
     */
    @Test(expected = NoSuchTextException.class)
    public void testCaesarGetCypherTextThrowsException() throws NoSuchTextException {
        Caesar cypherTest = new Caesar();
        Caesar cypherTest2 = new Caesar();

        cypherTest.setCypherText("");
        cypherTest2.setCypherText(null);

        cypherTest.getCypherText();
    }

    /**
     * Test method for Caesar's decryptText method.
     */
    @Test(expected = InvalidOperationException.class)
    public void testCaesarDecryptTextThrowsException() throws InvalidOperationException {
        Caesar cypherTest = new Caesar();
        cypherTest.decryptText("a");
    }

    /**
     * Test method for Caesar's decryptText method.
     */
    @Test
    public void testCaesarDecryptText() {
        Caesar cypherTest = new Caesar();
        cypherTest.setCypherText("wklv lv d vhfuhw phvvdjh");
        assertEquals("Incorrect decryption!", "this is a secret message", cypherTest.decryptText(3));
    }

    /**
     * Test method for Caesar's decryptText method.
     */
    @Test
    public void testCaesarDecryptText2() {
        Caesar cypherTest = new Caesar();
        cypherTest.setCypherText("fnuu qnuux cqnan bruuh");
        assertEquals("Incorrect decryption!", "well hello there silly", cypherTest.decryptText(9));
    }

    /**
     * Test method for Caesar's encryptText method.
     */
    @Test(expected = InvalidOperationException.class)
    public void testCaesarEncryptTextThrowsException() throws InvalidOperationException {
        Caesar cypherTest = new Caesar();
        cypherTest.encryptText("Hello world", "a");
    }

    /**
     * Test method for Caesar's encryptText method.
     */
    @Test
    public void testCaesarEncryptText() {
        Caesar cypherTest = new Caesar();
        cypherTest.setCypherText("blah");
        cypherTest.encryptText("this is a secret message", 3);
        assertEquals("Incorrect encryption!", "wklv lv d vhfuhw phvvdjh", cypherTest.getCypherText());
    }

    // END OF CAESAR TEST CASES

    // BEGIN OF RAILFENCE TEST CASES

    /**
     * Test method for RailFence's getCypherText method.
     */
    @Test
    public void testRailFenceGetCypherText() {
        RailFence cypherTest = new RailFence();
        cypherTest.setCypherText("Hello");
        assertEquals("Incorrect accessor method", "Hello", cypherTest.getCypherText());
    }

    /**
     * Test method for RailFence's getCypherText method.
     */
    @Test(expected = NoSuchTextException.class)
    public void testRailFenceGetCypherTextThrowsException() throws NoSuchTextException {
        RailFence cypherTest = new RailFence();
        RailFence cypherTest2 = new RailFence();

        cypherTest.setCypherText("");
        cypherTest2.setCypherText(null);

        cypherTest.getCypherText();
    }

    /**
     * Test method for RailFence's decryptText method.
     */
    @Test(expected = InvalidOperationException.class)
    public void testRailFenceDecryptTextThrowsException() 
            throws InvalidOperationException {
        RailFence cypherTest = new RailFence();
        cypherTest.decryptText("a");
    }

    /**
     * Test method for RailFence's decryptText method.
     */
    @Test
    public void testRailFenceDecryptText() {
        RailFence cypherTest = new RailFence();
        cypherTest.setCypherText("DUIRY TNENT SRMSA THKCD HJJPC ZOIWA OIJ");
        assertEquals("Incorrect decryption!", 
                "DRJUMPISCRAZYTOTHINKWECANDOTHISJJ", 
                cypherTest.decryptText(3));
    }

    /**
     * Test method for RailFence's encryptText method.
     */
    @Test(expected = InvalidOperationException.class)
    public void testRailFenceEncryptTextThrowsException() 
                throws InvalidOperationException {
        RailFence cypherTest = new RailFence();
        cypherTest.encryptText("Hello world", "a");
    }

    /**
     * Test method for RailFence encryptText method.
     */
    @Test
    public void testRailFenceEncryptText() {
        RailFence cypherTest = new RailFence();
        cypherTest.setCypherText("blah");
        cypherTest.encryptText("DR JUMP IS CRAZY TO THINK WE CAN DO THIS", 3);
        assertEquals("Incorrect encryption!", "DUIRY TNENT SRMSA THKCD HJJPC ZOIWA OIJ", cypherTest.getCypherText());
    }

    // END OF RAILFENCE TEST CASES
    // BEGIN OF ONETIMEPAD TEST CASES

    /**
     * Test method for OneTimePad's getCypherText method.
     */
    @Test
    public void testOneTimePadGetCypherText() {
        OneTimePad cypherTest = new OneTimePad();
        cypherTest.setCypherText("Hello");
        assertEquals("Incorrect accessor method", "Hello", cypherTest.getCypherText());
    }

    /**
     * Test method for OneTimePad's getCypherText method.
     */
    @Test(expected = NoSuchTextException.class)
    public void testOneTimePadGetCypherTextThrowsException() throws NoSuchTextException {
        OneTimePad cypherTest = new OneTimePad();
        OneTimePad cypherTest2 = new OneTimePad();

        cypherTest.setCypherText("");
        cypherTest2.setCypherText(null);

        cypherTest.getCypherText();
    }

    /**
     * Test method for OneTimePad's decryptText method.
     */
    @Test(expected = InvalidOperationException.class)
    public void testOneTimePadDecryptTextThrowsException() throws InvalidOperationException {
        OneTimePad cypherTest = new OneTimePad();
        cypherTest.decryptText(1);
    }

    /**
     * Test method for OneTimePad's decryptText method.
     */
    @Test
    public void testOneTimePadDecryptText() {
        OneTimePad cypherTest = new OneTimePad();
        cypherTest.setCypherText("QVTAMDWPRHNMH");
        assertEquals("Incorrect decryption!", "CIPHERSAREFUN",
                cypherTest.decryptText("One Time Pad is unbreakable only if the key is longer than the message"));
    }

    /**
     * Test method for OneTimePad's encryptText method.
     */
    @Test(expected = InvalidOperationException.class)
    public void testOneTimePadEncryptTextThrowsException() throws InvalidOperationException {
        OneTimePad cypherTest = new OneTimePad();
        cypherTest.encryptText("Hello world", 1);
    }

    /**
     * Test method for OneTimePad's encryptText method.
     */
    @Test
    public void testOneTimePadEncryptText() {
        OneTimePad cypherTest = new OneTimePad();
        cypherTest.setCypherText("blah");
        cypherTest.encryptText("Ciphers are fun",
                "One Time Pad is unbreakable only if the key is longer than the message");
        assertEquals("Incorrect encryption!", "QVTAMDWPRHNMH", cypherTest.getCypherText());
    }

    // END OF ONETIMEPAD TEST CASES
    // BEGIN OF PLAYFAIR TEST CASES

    /**
     * Test method for PlayFair's getCypherText method.
     */
    @Test
    public void testPlayFairGetCypherText() {
        PlayFair cypherTest = new PlayFair();
        cypherTest.setCypherText("Hello");
        assertEquals("Incorrect accessor method", "Hello", cypherTest.getCypherText());
    }

    /**
     * Test method for PlayFair's getCypherText method.
     */
    @Test(expected = NoSuchTextException.class)
    public void testPlayFairGetCypherTextThrowsException() throws NoSuchTextException {
        PlayFair cypherTest = new PlayFair();
        PlayFair cypherTest2 = new PlayFair();

        cypherTest.setCypherText("");
        cypherTest2.setCypherText(null);

        cypherTest.getCypherText();
    }

    /**
     * Test method for PlayFair's decryptText method.
     */
    @Test(expected = InvalidOperationException.class)
    public void testPlayFairDecryptTextThrowsException() throws InvalidOperationException {
        PlayFair cypherTest = new PlayFair();
        cypherTest.decryptText(1);
    }

    /**
     * Test method for PlayFair's decryptText method.
     */
    @Test
    public void testPlayFairDecryptText() {
        PlayFair cypherTest = new PlayFair();
        cypherTest.setCypherText("ga bu aq qr nz ah ef");
        assertEquals("Incorrect decryption!", "secretmesxsage", cypherTest.decryptText("KINGS RULES"));
    }

    /**
     * Test method forPlayFair's encryptText method.
     */
    @Test(expected = InvalidOperationException.class)
    public void testPlayFairEncryptTextThrowsException() 
            throws InvalidOperationException {
        PlayFair cypherTest = new PlayFair();
        cypherTest.encryptText("Hello world", 1);
    }

    /**
     * Test method for PlayFair's encryptText method.
     */
    @Test
    public void testPlayFairEncryptText() {
        PlayFair cypherTest = new PlayFair();
        cypherTest.setCypherText("blah");
        cypherTest.encryptText("secret message", "KINGS RULES");
        assertEquals("Incorrect encryption!", 
                "ga bu aq qr nz ah ef", 
                cypherTest.getCypherText());
    }

    // END OF PLAYFAIR TEST CASES

}
