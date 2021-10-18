package parserapp;

import java.io.*;
import java.util.Arrays;

public class Reader {
	private String path;
	private int rowSize;
	private int colSize;
	
	public Reader(String path) {
		this.path = path;
	}

	public File openFile() throws IOException
	{
		return new File(path);
	}
	
	public String[][] readFile() throws IOException
	{
		 
		File file = openFile();
		
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