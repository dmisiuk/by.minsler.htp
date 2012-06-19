package by.minsler.htp.concretecard;

import by.minsler.htp.card.ChangePinInterface;
import by.minsler.htp.categories.Maestro;

public class MaestroClassic extends Maestro implements ChangePinInterface {

	public MaestroClassic(int startSum, String endDate, String type, int pin) {
		super(startSum, endDate, type, pin);
	}

	@Override
	public boolean takeSum(int sum) {
		boolean result = super.takeSum(sum);
		System.out.print("Снято " + sum + " c  карточки МаестроКлассик:");
		if (result) {
			System.out.println(" успешно");
		} else {
			System.out.println(" ошибка");
		}
		return result;
	}

	@Override
	public String getDescription() {
		return "Classic card from Maestro company";
	}

	@Override
	public void changePin(int newPin) {
		this.pin = newPin;
		System.out.println("MaestroClassic. Pin: changed successfully");
	}
}
