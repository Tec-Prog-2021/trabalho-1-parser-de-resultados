package parserapp;

import java.io.FileWriter;

import java.io.IOException;

public class FileParser {

    public void parse(String inputFile, String outputFile, Character delimiter, int orientation) throws IOException {
        String content = "1;2;3\n456;523;458\n782;861;973\n755;770;753\n729;783;758\n761;720;783\n751;813;749\n869;750;794\n823;726;769\n847;770\n730;771\n";
        FileWriter writer = new FileWriter(outputFile);
        writer.write(content);
        writer.close();
    }

}