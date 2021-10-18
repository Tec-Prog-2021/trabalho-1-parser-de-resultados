package interfaceUsuario;

import static org.junit.Assert.assertThrows;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import interfaceUsuario.CamposMenu;
import interfaceUsuario.CamposMenu.DelimitadorInvalidoException;

public class Testes {
	private CamposMenu menu;
	
	@Before
	public void setup() {
		menu = new CamposMenu();
	}
	 
	 
	@Test
    public void testeDelimitadorInvalido() throws DelimitadorInvalidoException {
		CamposMenu testando = new CamposMenu();
		
		Exception exception = assertThrows(DelimitadorInvalidoException.class, () -> {
	        testando.ValidacaoDelimitador("stringInvalida");
	    });

	    String expectedMessage = "Inválido";
	    String actualMessage = exception.getMessage();
	    //System.out.println(actualMessage.contains(expectedMessage));
	    Assert.assertTrue(actualMessage.contains(expectedMessage));
		//equals(calc.Teste("sdfasd"));
    }
	
	@Test
    public void testeDelimitadorValido() throws DelimitadorInvalidoException {
		CamposMenu testando = new CamposMenu();
		
		String delimitador = "\n";
		testando.ValidacaoDelimitador(delimitador);
	   
	    Assert.assertEquals(delimitador, testando.ValidacaoDelimitador(delimitador));
    }

	
	
}
