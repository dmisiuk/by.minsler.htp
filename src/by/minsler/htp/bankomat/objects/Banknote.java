package by.minsler.htp.bankomat.objects;

public class Banknote {

	private String name;
	private int nominal;

	public Banknote(String name, int nominal) {
		this.name = name;
		this.nominal = nominal;
	}

	public String getName() {
		return name;
	}

	public int getNominal() {
		return nominal;
	}
}
