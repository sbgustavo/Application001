package br.com.appCar.control;

public class RelacaoCombustivel extends Calculo {

	public double calcular(double precoAlcool, double precoGasolina) {
		return precoAlcool / precoGasolina;
	}
}
