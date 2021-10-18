package parserapp;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import parserapp.Menu.DelimitadorInvalidoException;

public class MenuTest {
	private Menu menu;
	
	@Before
	public void setup() {
		menu = new Menu();
	}
	 
	@Test
    public void testeDelimitadorInvalido() throws DelimitadorInvalidoException {
		Menu testando = new Menu();
		
		Exception exception = assertThrows(DelimitadorInvalidoException.class, () -> {
	        testando.ValidacaoDelimitador("stringInvalida");
	    });

	    String expectedMessage = "Inválido";
	    String actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
    }
	
	@Test
    public void testeDelimitadorValido() throws DelimitadorInvalidoException {
		Menu testando = new Menu();
		
		String delimitador = "\n";
		testando.ValidacaoDelimitador(delimitador);
	   
	    assertEquals(delimitador, testando.ValidacaoDelimitador(delimitador));
    }
}
