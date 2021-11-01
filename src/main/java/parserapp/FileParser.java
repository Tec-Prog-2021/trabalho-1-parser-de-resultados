package parserapp;

import exceptions.EscritaNaoPermitidaException;
import java.io.FileWriter;
import java.io.IOException;

public class FileParser {

    public void parse(String inputFile, String outputFile, Character delimiter, int orientation) throws EscritaNaoPermitidaException {
        try {

            String content = "";
            
            Persistencia persistencia = new Persistencia();

            String values[][] = persistencia.readFile(inputFile);
            int rows = persistencia.getRowSize();
            int cols = persistencia.getColSize();

            if (orientation == Constants.ROW_ORIENTATION) {
                for (int i = 0;i < rows;i++) {
                    content += (i + 1); // identifiers
                    content += delimiter; 
                    int j = 0;
                    while(true) {
                        content += values[i][j++];
                        if (values[i][j] == null) break;
                        content += delimiter;
                    }
                    content += "\n";
                }
            } else if (orientation == Constants.COLUMN_ORIENTATION) {
                for (int i = 0;i < rows;i++) { // identifiers
                    content += (i + 1);
                    if (i != rows - 1) content += delimiter;
                }
                content += "\n";
                for (int j = 0;j < cols;j++) {
                    for (int i = 0;i < rows;i++) {
                        if (values[i][j] != null) content += values[i][j];
                        if (i != rows - 1 && values[i + 1][j] != null) content += delimiter;
                    }
                    content += "\n";
                }
            }

            persistencia.writeFile(outputFile, content);

        } catch (Exception e) {

            throw new EscritaNaoPermitidaException();
        
        }
        
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

      FileWriter writer = new FileWriter(outputFile);
      writer.write(content);
      writer.close();
    } catch (Exception e) {
      throw new EscritaNaoPermitidaException();
    }
  }
  
}
