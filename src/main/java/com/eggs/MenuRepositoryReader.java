package com.eggs;
/**
 * This interface is for to provide a single method to
 * read from different types of sources
 * 
 * Every reader class must implement this interface
 * 
 * @author Csaba_Valyi
 *
 */
public interface MenuRepositoryReader {
	public MenuRepository read();
}
