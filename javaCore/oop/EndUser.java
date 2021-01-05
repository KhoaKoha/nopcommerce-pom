package oop;

public class EndUser {
	static Honda honda;

	public static void main(String[] args) {
		honda = new Honda();
		honda.setByName("SH 110");
		System.out.println(honda.bikeName);

	}

}
