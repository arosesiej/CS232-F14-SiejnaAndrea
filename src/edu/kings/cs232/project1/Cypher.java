package edu.kings.cs232.project1;

/**
 * The methods of this interface should be documented, but this will be left for
 * students to do in the classes implementing this interface. Sorry!
 * 
 * @author Maria Jump
 * @version 2014.09.22
 */
public interface Cypher {
	public String decryptText(int key) throws InvalidOperationException;

	public String decryptText(String key) throws InvalidOperationException;

	public void encryptText(String plaintext, int key)
			throws InvalidOperationException;

	public void encryptText(String plaintext, String key)
			throws InvalidOperationException;

	public String getCypherText() throws NoSuchTextException;

	public void setCypherText(String text);
}