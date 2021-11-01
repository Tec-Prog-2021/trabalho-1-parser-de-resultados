package parserapp;

import exceptions.EscritaNaoPermitidaException;
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

      Writer writer = new Writer(outputFile);
      writer.writeFile(content);
    } catch (Exception e) {
      throw new EscritaNaoPermitidaException();
    }
  }
  
}
