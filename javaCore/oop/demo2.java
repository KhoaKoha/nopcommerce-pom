package oop;

public class demo2 {

	public static void main(String[] args) {
		String a = "ORDER NUMBER : 1031"; 
		String b = "ORDER NUMBER : 1031"; 
		String c = b.substring(b.length()-4);
		System.out.println(c);
		if (a.substring(a.length()-4).equals(b.substring(b.length()-4))) {
			System.out.println(true);
		}
		else {
			System.out.println(false);
		}
		

	}
	
	public String getNumberOrder(String texta) {
		return texta.substring(texta.length()-4);
	}

}
