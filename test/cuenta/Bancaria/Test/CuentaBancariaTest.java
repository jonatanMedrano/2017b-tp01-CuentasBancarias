package cuenta.Bancaria.Test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cuenta.Bancaria.CuentaBancaria;

public class CuentaBancariaTest {
	
	CuentaBancaria cuentaOrigen;
	CuentaBancaria cuentaDestino;
	
	@Before
	public void setUp(){
		 cuentaOrigen = new CuentaBancaria(12345678, 100);
		 cuentaDestino = new CuentaBancaria(12345678, 10);
	}

	/**
	 * Compruebo que la cuenta de origen quedo en cero
	 */
	@Test
	public void queHayaMontoCeroEnLaCuentaOrigen(){
		//Tranfiero todo el saldo a la cuenta destino
		cuentaOrigen.transferenciaBancaria(100, cuentaDestino);
		
		//Compruebo que el saldo quede en 0 en la cuenta de origen
		Assert.assertEquals(0,cuentaOrigen.consultarSaldo(),0);
	}

	/**
	 * Compruebo que el saldo se ha acreditado
	 */
	@Test
	public void queSeAcreditoElSaldo(){
		//Tranfiero todo el saldo a la cuenta destino
		cuentaOrigen.transferenciaBancaria(90, cuentaDestino);
		
		//Compruebo que el saldo quede en 0 en la cuenta de origen
		Assert.assertEquals(100,cuentaDestino.consultarSaldo(),0);
	}
	
	/**
	 * Compruebo que el no se realiza transferencia si el saldo no es suficiente
	 */
	@Test
	public void queElSaldoSeaInsuficiente(){
		//Tranfiero todo el saldo a la cuenta destino
		cuentaOrigen.transferenciaBancaria(150, cuentaDestino);
		
		//Compruebo que el saldo quede en 0 en la cuenta de origen
		Assert.assertEquals(10,cuentaDestino.consultarSaldo(),0);
	}

	
}
