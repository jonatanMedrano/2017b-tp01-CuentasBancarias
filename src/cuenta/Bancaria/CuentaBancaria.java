package cuenta.Bancaria;

public class CuentaBancaria {
	private int numeroCuenta;
	private double saldo;
	
	/**
	 * Constructor de la clase cuenta bancaria
	 * @param numeroCuenta
	 * @param saldo
	 */
	public CuentaBancaria(int numeroCuenta, double saldo) {
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
	}
	
	/**
	 * Acredito el monto a la cuenta destino y debita de la cuenta de origen
	 * @param monto
	 * @param cuentaDestino
	 */
	
	public void transferenciaBancaria(double monto, CuentaBancaria cuentaDestino){
		if(this.saldo >= monto){
			cuentaDestino.saldo += monto;
			this.saldo -= monto;
		}
	}
	
	/**
	 * Muestra el saldo actual
	 * @return
	 */
	public double consultarSaldo(){
		return this.saldo;
	}
}
