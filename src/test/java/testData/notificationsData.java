package testData;

import provision.notifications;

public class notificationsData extends TestData{

	public static notifications notificationsInput() {

		notifications input = new notifications();
		input.setBarringTopupPurchase(on);
		input.setDomesticNotifyEnabled(on);
		input.setRccNotifyEnabled(off);
		input.setRoamingNotifyEnabled(off);
		
		return input;
	}
	
	public static notifications missingDomestic() {

		notifications input = new notifications();
		input.setBarringTopupPurchase(on);
		input.setRccNotifyEnabled(off);
		input.setRoamingNotifyEnabled(off);
		
		return input;
	}
	
	public static notifications missingRoaming() {

		notifications input = new notifications();
		input.setBarringTopupPurchase(on);
		input.setDomesticNotifyEnabled(on);
		input.setRccNotifyEnabled(off);
		
		return input;
	}
	
	public static notifications missingRCC() {

		notifications input = new notifications();
		input.setBarringTopupPurchase(on);
		input.setDomesticNotifyEnabled(on);
		input.setRoamingNotifyEnabled(off);
		
		return input;
	}
	
	public static notifications missingBaring() {

		notifications input = new notifications();
		input.setDomesticNotifyEnabled(on);
		input.setRccNotifyEnabled(off);
		input.setRoamingNotifyEnabled(off);
		
		return input;
	}

}
