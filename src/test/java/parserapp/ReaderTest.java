package parserapp;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import parserapp.Reader;

import parserapp.Constants;

public class ReaderTest {

 	@Test
	public void testOpenFileSuccess() throws IOException {
	 	Reader reader = new Reader(Constants.FILE_PATH + "analysisMemory.out");
		 
		File f = reader.openFile();
		assertTrue(f.getAbsoluteFile().toString().contains("analysisMemory.out"));
	}
	
 	@Test
	public void testOpenFileFail() throws IOException {
		
		try {
			Reader reader = new Reader(Constants.FILE_PATH + "analysisMemory.out");
			
			reader.openFile();
		} catch (Exception e) {
			String expectetedException = "No such file or directory";
			
			assertTrue(e.getMessage().contains(expectetedException));
		}
	
		
	} 
	
 	@Test
	public void testMemoryRowSize() throws IOException {
		Reader reader = new Reader(Constants.FILE_PATH + "analysisMemory.out");
	
		reader.readFile();
		
		assertEquals(20, reader.getRowSize());

	}
	
	@Test
	public void testMemoryColSize() throws IOException {
		Reader reader = new Reader(Constants.FILE_PATH + "analysisMemory.out");
	
		reader.readFile();
		
		assertEquals(11, reader.getColSize());

	}
	
	@Test
	public void testTimeRowSize() throws IOException {
		Reader reader = new Reader(Constants.FILE_PATH + "analysisTime.out");
	
		reader.readFile();
		
		assertEquals(20, reader.getRowSize());

	}
	
	@Test
	public void testTimeColSize() throws IOException {
		Reader reader = new Reader(Constants.FILE_PATH + "analysisTime.out");
	
		reader.readFile();
		
		assertEquals(11, reader.getColSize());

	}  
}