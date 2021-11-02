package parserapp;

import java.io.*;
import java.util.Arrays;
import java.io.FileWriter;

import exceptions.ArquivoNaoEncontradoException;
import exceptions.EscritaNaoPermitidaException;

public class Persistencia {
	private int rowSize;
	private int colSize;
	
	public Persistencia() {}

	public File openFileToRead(String path) throws ArquivoNaoEncontradoException {
		try {
			return new File(path);
		} catch(Exception e) {
			throw new ArquivoNaoEncontradoException();
		}
	}
	
	public FileWriter openFileToWrite(String path) throws ArquivoNaoEncontradoException {
		try {
			return new FileWriter(path);
		} catch(Exception e) {
			throw new ArquivoNaoEncontradoException();
		}
	}

	public String[][] readFile(String path) throws ArquivoNaoEncontradoException {
		try {

			File file = openFileToRead(path);
		
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			String[][] values = new String[10000][10000];

			for (int i = 0;i < 10000;i++) Arrays.fill(values[i], null);
			
			String st;
			
			int i = -1, rows = 0;
			int j = 0, cols = 0;

			while ((st = br.readLine()) != null) {
				if(!st.contains("-")) {
					values[i][j] = st;
					j++;
				} else {
					rows++;
					cols = Math.max(cols, j);
					i++;
					j = 0;
				}
			}
			
			setRowSize(rows);
			setColSize(cols);
			
			br.close();
				
			return values;

		} catch(Exception e) {
			throw new ArquivoNaoEncontradoException();
		}
	
	}

	public void writeFile(String path, String content) throws EscritaNaoPermitidaException {
		try {
			FileWriter writer = openFileToWrite(path);
			writer.write(content);
			writer.close();		
		} catch(Exception e) {
			throw new EscritaNaoPermitidaException();
		}
	}	

	public int getRowSize() {
		return rowSize;
	}

	public void setRowSize(int rowSize) {
		this.rowSize = rowSize;
	}

	public int getColSize() {
		return colSize;
	}

	public void setColSize(int colSize) {
		this.colSize = colSize;
	}

}