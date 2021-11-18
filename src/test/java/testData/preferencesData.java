package testData;

import provision.preferences;
import stepDefinitions.ReUsableMethods;

public class preferencesData extends TestData{

	public static preferences preferencesInput() {

		preferences input = new preferences();
		input.setAlternateNumber(ReUsableMethods.getCurrentDateTimeMS() + "9");
		input.setBrandInfo(brandInfo);
		input.setChannel(channel);
		input.setEmailAddress(emailAddress);
		input.setLanguage(language);
		input.setServiceProviderId(serviceProviderId);
		input.setSubscriptionType(subscriptionType);
		input.setTcId(tcId);
		
		return input;
	}
	
	public static preferences preferencesInputMandatory() {

		preferences input = new preferences();
		input.setLanguage(language);
		input.setServiceProviderId(serviceProviderId);
		input.setSubscriptionType(subscriptionType);
		
		return input;
	}
	
	public static preferences invalidEmail() {

		preferences input = new preferences();
		input.setAlternateNumber(ReUsableMethods.getCurrentDateTimeMS() + "9");
		input.setBrandInfo(brandInfo);
		input.setChannel(channel);
		input.setEmailAddress(invalidEmailAddress);
		input.setLanguage(language);
		input.setServiceProviderId(serviceProviderId);
		input.setSubscriptionType(subscriptionType);
		input.setTcId(tcId);
		
		return input;
	}
	
	public static preferences missingLanguage() {

		preferences input = new preferences();
		input.setAlternateNumber(ReUsableMethods.getCurrentDateTimeMS() + "9");
		input.setBrandInfo(brandInfo);
		input.setChannel(channel);
		input.setEmailAddress(emailAddress);
		input.setServiceProviderId(serviceProviderId);
		input.setSubscriptionType(subscriptionType);
		input.setTcId(tcId);
		
		return input;
	}
	
	public static preferences missingServiceProvider() {

		preferences input = new preferences();
		input.setAlternateNumber(ReUsableMethods.getCurrentDateTimeMS() + "9");
		input.setBrandInfo(brandInfo);
		input.setChannel(channel);
		input.setEmailAddress(emailAddress);
		input.setLanguage(language);
		input.setSubscriptionType(subscriptionType);
		input.setTcId(tcId);
		
		return input;
	}
	
	public static preferences missingSubscriptionType() {

		preferences input = new preferences();
		input.setAlternateNumber(ReUsableMethods.getCurrentDateTimeMS() + "9");
		input.setBrandInfo(brandInfo);
		input.setChannel(channel);
		input.setEmailAddress(emailAddress);
		input.setLanguage(language);
		input.setServiceProviderId(serviceProviderId);
		input.setTcId(tcId);
		
		return input;
	}

}
