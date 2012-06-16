package by.minsler.htp.concretecard;

import by.minsler.htp.categories.Maestro;

public class MaestroClassic extends Maestro {

	public MaestroClassic(int startSum, String endDate, String type) {
		super(startSum, endDate, type);
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
}
