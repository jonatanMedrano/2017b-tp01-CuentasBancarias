package cuenta.Bancaria.Test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cuenta.Bancaria.CuentaBancaria;

public class CuentaBancariaTest {

	CuentaBancaria cuentaOrigen;
	CuentaBancaria cuentaDestino;

	@Before
	public void setUp() {
		cuentaOrigen = new CuentaBancaria(12345678, 100);//Cuenta de origen con un cierto numero y 100 pesos de saldo
		cuentaDestino = new CuentaBancaria(87654321, 10);//Cuenta de destino con un cierto numero y 10 pesos de saldo
	}

	/**
	 * Compruebo que la cuenta de origen quedo en cero
	 */
	@Test
	public void queHayaMontoCeroEnLaCuentaOrigen() {
		// Tranfiero todo el saldo a la cuenta destino
		cuentaOrigen.transferenciaBancaria(100, cuentaDestino);

		// Compruebo que el saldo quede en 0 en la cuenta de origen
		Assert.assertEquals(0, cuentaOrigen.consultarSaldo(), 0);
	}

	/**
	 * Compruebo que el saldo se ha acreditado
	 */
	@Test
	public void queSeAcreditoElSaldo() {
		cuentaOrigen.transferenciaBancaria(90, cuentaDestino);

		Assert.assertEquals(100, cuentaDestino.consultarSaldo(), 0);
	}

	/**
	 * Compruebo que no se realiza transferencia si el saldo no es suficiente
	 */
	@Test
	public void queElSaldoSeaInsuficiente() {
		cuentaOrigen.transferenciaBancaria(150, cuentaDestino);

		Assert.assertEquals(10, cuentaDestino.consultarSaldo(), 0);
	}

	/**
	 * Comprobacion de acreditacion y debito
	 */
	@Test
	public void mismaDiferenciaEntreOrigenYDestino() {
		cuentaOrigen.transferenciaBancaria(50, cuentaDestino);

		Assert.assertEquals(60, cuentaDestino.consultarSaldo(), 0);
		Assert.assertEquals(50, cuentaOrigen.consultarSaldo(), 0);

	}

	/**
	 * Comprobacion que por dia no se hagan transferencias de mas de 100000 pesos
	 * Segun Banco Nacion Argentino
	 */
	@Test
	public void verificoQueNoSeTransfieraMasDe100000PesosPorDia() {		
		
		CuentaBancaria cuentaTres = new CuentaBancaria(99999999, 100_500);
		cuentaTres.transferenciaBancaria(100_500, cuentaDestino);

		Assert.assertEquals(10,cuentaDestino.consultarSaldo(),0);
		Assert.assertEquals(100_500,cuentaTres.consultarSaldo(),0);
	}

}

