package parserapp;

import exceptions.*;
import java.io.FileWriter;
import java.io.IOException;

public class FileParser {

  public void parse(
    String inputFile,
    String outputFile,
    Character delimiter,
    int orientation
  )
    throws EscritaNaoPermitidaException {
    try {
      Reader reader = new Reader(inputFile);

      String values[][] = reader.readFile();
      int rows = reader.getRowSize();
      int cols = reader.getColSize();

      OrientationTransformer transformer = new OrientationTransformer(
        values,
        rows,
        cols
      );

      String content = transformer.transform(orientation, delimiter);

      this.writeFile(outputFile, content);

    } catch (Exception e) {
      throw new EscritaNaoPermitidaException();
    }
  }

  public FileWriter openFile(String path) throws ArquivoNaoEncontradoException
	{
		try {

			return new FileWriter(path);
		
		} catch(Exception e) {
		
			throw new ArquivoNaoEncontradoException();
		
		}
	}
	
	public void writeFile(String path, String content) throws EscritaNaoPermitidaException {
		try {

			FileWriter writer = this.openFile(path);
			writer.write(content);
			writer.close();
			
		} catch(Exception e) {
			throw new EscritaNaoPermitidaException();
		}	
	}
  
}
