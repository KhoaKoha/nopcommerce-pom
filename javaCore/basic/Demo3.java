package basic;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class Demo3 {

	public static void main(String[] args) {
		System.out.println(check());
	}
	
	public static String getFormatPrice(String value) {
		value = value.substring(1);
		value = value.replace(",","");
		value = value.substring(0,value.lastIndexOf("."));
		return value;
	}
	
	public static boolean check() {
		int check2 = 0;
		String valueExpected[] = {"Samsung", "Apple", "Lenovo"};
		String valueActual[] = {"HP", "Apple", "Samsung"};
		
	
		for (int i = 0; i < valueActual.length; i++) {
			for (int j = 0; j < valueExpected.length; j++) {
				System.out.println("Actual ==> " + valueActual[i]);
				System.out.println("Expected ==> " + valueExpected[j]);
				if (valueActual[i].equals(valueExpected[j])) {
					check2 ++;
				}
			}
		}
		boolean check1 = false;
		if (check2==3) {
			 check1 = true;
		}
		else {
			 check1 = false;
		}
	return check1;	
	}

}
