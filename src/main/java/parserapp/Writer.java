package parserapp;

import java.io.*;
import exceptions.EscritaNaoPermitidaException;
import java.io.FileWriter;
import java.io.IOException;


import exceptions.ArquivoNaoEncontradoException;

public class Writer {
	private String path;
	
	public Writer(String path) {
		this.path = path;
	}

	public FileWriter openFile() throws ArquivoNaoEncontradoException
	{
		try {

			return new FileWriter(this.path);
		
		} catch(Exception e) {
		
			throw new ArquivoNaoEncontradoException();
		
		}
	}
	
	public void writeFile(String content) throws EscritaNaoPermitidaException {
		try {

			FileWriter writer = this.openFile();
			writer.write(content);
			writer.close();			
			
		} catch(Exception e) {
			throw new EscritaNaoPermitidaException();
		}	
	}

}