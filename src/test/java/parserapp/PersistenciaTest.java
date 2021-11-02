package parserapp;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import parserapp.Persistencia;

import parserapp.Constants;

import exceptions.ArquivoNaoEncontradoException;

public class PersistenciaTest {

 	@Test
	public void testOpenFileSuccess() throws ArquivoNaoEncontradoException {
	 	Persistencia persistencia = new Persistencia();
		 
		File f = persistencia.openFileToRead(Constants.FILE_PATH + "analysisMemory.out");
		assertTrue(f.getAbsoluteFile().toString().contains("analysisMemory.out"));
	}
	
 	@Test
	public void testOpenFileFail() throws ArquivoNaoEncontradoException {
		
		try {
			Persistencia persistencia = new Persistencia();
			
			persistencia.openFileToRead(Constants.FILE_PATH + "analysisMemory.out");
		} catch (Exception e) {
			String expectetedException = "No such file or directory";
			
			assertTrue(e.getMessage().contains(expectetedException));
		}
		
	} 
	
 	@Test
	public void testMemoryRowSize() throws ArquivoNaoEncontradoException {
		Persistencia persistencia = new Persistencia();
	
		persistencia.readFile(Constants.FILE_PATH + "analysisMemory.out");
		
		assertEquals(21, persistencia.getRowSize());

	}
	
	@Test
	public void testMemoryColSize() throws ArquivoNaoEncontradoException {
		Persistencia persistencia = new Persistencia();
	
		persistencia.readFile(Constants.FILE_PATH + "analysisMemory.out");
		
		assertEquals(11, persistencia.getColSize());

	}
	
	@Test
	public void testTimeRowSize() throws ArquivoNaoEncontradoException {
		Persistencia persistencia = new Persistencia();
	
		persistencia.readFile(Constants.FILE_PATH + "analysisMemory.out");
		
		assertEquals(21, persistencia.getRowSize());

	}
	
	@Test
	public void testTimeColSize() throws ArquivoNaoEncontradoException {
		Persistencia persistencia = new Persistencia();
	
		persistencia.readFile(Constants.FILE_PATH + "analysisMemory.out");
		
		assertEquals(11, persistencia.getColSize());

	}  
}