package parserapp;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import junitx.framework.FileAssert;

import java.io.*;

import parserapp.FileParser;

import parserapp.Constants;

public class FileParserTest {

    private FileParser parser;

    private static String TEST_FILES_PATH = "./src/test/resources/"; 

    @Before
    public void setup(){
        parser = new FileParser();
    }
    
    @Test
    public void testParser1() throws IOException {
        String inputPath = TEST_FILES_PATH + "inputTest1.out";
        String outputPath = TEST_FILES_PATH + "outputTest1.out";
        String expectedPath = TEST_FILES_PATH + "expectedTest1.out";
        parser.parse(inputPath, outputPath, ';', Constants.COLUMN_ORIENTATION);
        File expected = new File(expectedPath);
        File actual = new File(outputPath);
        FileAssert.assertEquals("Saída diferente da esperada.", expected, actual);
    } 
}
