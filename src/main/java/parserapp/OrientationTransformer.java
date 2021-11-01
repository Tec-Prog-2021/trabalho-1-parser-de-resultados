package parserapp;

public class OrientationTransformer {

    private String[][] initialContent;
    private int rows;
    private int cols;

    public OrientationTransformer(String[][] initialContent, int rows, int cols){
        this.initialContent = initialContent;
        this.rows = rows;
        this.cols = cols;
    }
    
    public String transform(int orientation, Character delimiter) {
        if (orientation == Constants.ROW_ORIENTATION) {
            return transformToRow(delimiter);
        } else if (orientation == Constants.COLUMN_ORIENTATION) {
            return transformToColumn(delimiter);
        }
        return "";
    }
    
    private String transformToRow(Character delimiter) {
        String content = "";

        for (int i = 0;i < rows;i++) {
            content += (i + 1); // identifiers
            content += delimiter; 
            int j = 0;
            while(true) {
                content += initialContent[i][j++];
                if (initialContent[i][j] == null) break;
                content += delimiter;
            }
            content += "\n";
        }

        return content;
    } 

    private String transformToColumn(Character delimiter) {
        String content = "";

        for (int i = 0;i < rows;i++) { // identifiers
            content += (i + 1);
            if (i != rows - 1) content += delimiter;
        }
        
        content += "\n";
        for (int j = 0;j < cols;j++) {
            for (int i = 0;i < rows;i++) {
                if (initialContent[i][j] != null) content += initialContent[i][j];
                if (i != rows - 1 && initialContent[i + 1][j] != null) content += delimiter;
            }
            content += "\n";
        }

        return content;
    } 
}
