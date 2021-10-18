package parserapp;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Reader reader = new Reader("analysisMemory.out");
		//Reader reader = new Reader("analysisTime.out");
		
		float[][] values = new float[10000][10000];
		
		values = reader.readFile();
		
		 for(int k = 0; k <= reader.getRowSize(); k++) {
			 for(int w = 0; w < reader.getColSize(); w++) {
				 System.out.print(values[k][w] + " ");
			 }
			 System.out.print("\n");
		  }
		 
		 System.out.println("Row: " + reader.getRowSize());
		 System.out.println("Col: " + reader.getColSize());
		     
	}
}
