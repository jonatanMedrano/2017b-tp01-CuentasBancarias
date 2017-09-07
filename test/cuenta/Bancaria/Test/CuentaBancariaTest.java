package cuenta.Bancaria.Test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cuenta.Bancaria.CuentaBancaria;

public class CuentaBancariaTest {

	
	@Before
	public void setUp(){
		CuentaBancaria cuentaOrigen = new CuentaBancaria(12345678, 100);
		CuentaBancaria cuentaDestino = new CuentaBancaria(12345678, 10);
	}
	
	@Test
	public void queHayaMontoCeroEnLaCuenta(){
		Assert.fail();
	}
}
