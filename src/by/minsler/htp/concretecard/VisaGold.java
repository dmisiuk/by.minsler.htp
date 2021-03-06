package by.minsler.htp.concretecard;

import by.minsler.htp.categories.Visa;

public class VisaGold extends Visa {

	public VisaGold(int startSum, String endDate, String type, int pin) {
		super(startSum, endDate, type, pin);
		this.internetBank = true;
	}

	@Override
	public boolean takeSum(int sum) {
		boolean result = super.takeSum(sum);
		System.out.print("Снято " + sum + " c  карточки ВизаГолд:");
		if (result) {
			System.out.println(" успешно");
		} else {
			System.out.println(" ошибка");
		}
		return result;
	}

	@Override
	public String getDescription() {
		return "Super-Puper card from Visa with all";
	}
}
