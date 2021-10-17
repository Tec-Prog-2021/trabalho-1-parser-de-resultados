package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import application.Reader;

class ReaderTest {

	@Test
	void testOpenFileSuccess() throws IOException {
		
		Reader reader = new Reader("analysisMemory.out");
		
		File f = reader.openFile();
		assertTrue(f.getAbsoluteFile().toString().contains("analysisMemory.out"));
	
	}
	
	@Test
	void testOpenFileFail() throws IOException {
		
		try {
			Reader reader = new Reader("anaisMemory.out");
			
			reader.openFile();
		} catch (Exception e) {
			String expectetedException = "No such file or directory";
			
			assertTrue(e.getMessage().contains(expectetedException));
		}
	
		
	}
	
	@Test
	void testMemoryRowSize() throws IOException {
		Reader reader = new Reader("analysisMemory.out");
	
		reader.readFile();
		
		assertEquals(20, reader.getRowSize());

	}
	
	@Test
	void testMemoryColSize() throws IOException {
		Reader reader = new Reader("analysisMemory.out");
	
		reader.readFile();
		
		assertEquals(11, reader.getColSize());

	}
	
	@Test
	void testTimeRowSize() throws IOException {
		Reader reader = new Reader("analysisTime.out");
	
		reader.readFile();
		
		assertEquals(20, reader.getRowSize());

	}
	
	@Test
	void testTimeColSize() throws IOException {
		Reader reader = new Reader("analysisTime.out");
	
		reader.readFile();
		
		assertEquals(11, reader.getColSize());

	}
}
