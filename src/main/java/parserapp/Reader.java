package parserapp;

import java.io.*;

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
	
	public float[][] readFile() throws IOException
	{
		 
		File file = openFile();
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		float[][] values = new float[10000][10000];
		 
		String st;
		
		 
		int i = -1;
		int j = 0;
		
		while ((st = br.readLine()) != null) {
			if(!st.contains("-")) {
				values[i][j] = Float.parseFloat(st);
				j++;
			 } else {
				 i++;
				 j = 0;
			 }
		 }
		
		 setRowSize(i);
		 setColSize(j);
		
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