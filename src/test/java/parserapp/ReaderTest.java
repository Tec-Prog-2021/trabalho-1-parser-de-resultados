package parserapp;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import parserapp.Reader;

import parserapp.Constants;

import exceptions.ArquivoNaoEncontradoException;

public class ReaderTest {

 	@Test
	public void testOpenFileSuccess() throws ArquivoNaoEncontradoException {
	 	Reader reader = new Reader(Constants.FILE_PATH + "analysisMemory.out");
		 
		File f = reader.openFile();
		assertTrue(f.getAbsoluteFile().toString().contains("analysisMemory.out"));
	}
	
 	@Test
	public void testOpenFileFail() throws ArquivoNaoEncontradoException {
		
		try {
			Reader reader = new Reader(Constants.FILE_PATH + "analysisMemory.out");
			
			reader.openFile();
		} catch (Exception e) {
			String expectetedException = "No such file or directory";
			
			assertTrue(e.getMessage().contains(expectetedException));
		}
		
	} 
	
 	@Test
	public void testMemoryRowSize() throws ArquivoNaoEncontradoException {
		Reader reader = new Reader(Constants.FILE_PATH + "analysisMemory.out");
	
		reader.readFile();
		
		assertEquals(21, reader.getRowSize());

	}
	
	@Test
	public void testMemoryColSize() throws ArquivoNaoEncontradoException {
		Reader reader = new Reader(Constants.FILE_PATH + "analysisMemory.out");
	
		reader.readFile();
		
		assertEquals(11, reader.getColSize());

	}
	
	@Test
	public void testTimeRowSize() throws ArquivoNaoEncontradoException {
		Reader reader = new Reader(Constants.FILE_PATH + "analysisTime.out");
	
		reader.readFile();
		
		assertEquals(21, reader.getRowSize());

	}
	
	@Test
	public void testTimeColSize() throws ArquivoNaoEncontradoException {
		Reader reader = new Reader(Constants.FILE_PATH + "analysisTime.out");
	
		reader.readFile();
		
		assertEquals(11, reader.getColSize());

	}  
}