package parserapp;

import exceptions.*;
import java.io.FileWriter;
import java.io.IOException;

public class FileParser {

    public void parse(String inputFile, String outputFile, Character delimiter, int orientation) 
      throws ArquivoNaoEncontradoException, EscritaNaoPermitidaException {
        try {
            Persistencia persistencia = new Persistencia();

            String values[][] = persistencia.readFile(inputFile);
            int rows = persistencia.getRowSize();
            int cols = persistencia.getColSize();

            OrientationTransformer transformer = new OrientationTransformer(values, rows, cols);
      
            String content = transformer.transform(orientation, delimiter);

            persistencia.writeFile(outputFile, content);
        } catch (Exception e) {
            throw new EscritaNaoPermitidaException();
        }
    }

}
  

