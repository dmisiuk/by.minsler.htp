package by.minsler.htp.concretecard;

import by.minsler.htp.categories.Visa;

public class VisaElectron extends Visa {

	public VisaElectron(int startSum, String endDate, String type) {
		super(startSum, endDate, type);
		this.internetBank = false;
	}

	@Override
	public boolean takeSum(int sum) {
		boolean result = super.takeSum(sum);
		System.out.print("Снято " + sum + " c  карточки ВизаЕлектрон:");
		if (result) {
			System.out.println(" успешно");
		} else {
			System.out.println(" ошибка");
		}
		return result;
	}
}
