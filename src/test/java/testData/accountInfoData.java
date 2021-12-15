package testData;

import provision.accountInfo;

public class accountInfoData extends TestData{
	
	public static accountInfo<Integer> accountData() {
		accountInfo<Integer> input = new accountInfo<Integer>();
		input.setAddress(address);
		input.setBdom(bdom);
		input.setBillingFrequency(billingFrequency);
		input.setCity(city);
		input.setCountry(country);
		input.setCustomerType(customerType);
		input.setLastName(lastName);
		return input;
	}
	
	public static accountInfo<Integer> accountDataMandatory() {
		accountInfo<Integer> input = new accountInfo<Integer>();
		input.setBdom(bdom);
		input.setBillingFrequency(billingFrequency);		
		input.setCustomerType(customerType);
		return input;
	}
	
	public static accountInfo<String> accountInvalidDataType() {
		accountInfo<String> input = new accountInfo<String>();
		input.setAddress(address);
		input.setBdom(invalidData);
		input.setBillingFrequency(billingFrequency);
		input.setCity(city);
		input.setCountry(country);
		input.setCustomerType(customerType);
		input.setLastName(lastName);
		return input;
	}
	
	public static accountInfo<Integer> missingCustomerType() {
		accountInfo<Integer> input = new accountInfo<Integer>();
		input.setAddress(address);
		input.setBdom(bdom);
		input.setBillingFrequency(billingFrequency);
		input.setCity(city);
		input.setCountry(country);
		input.setLastName(lastName);
		return input;
	}
	
	public static accountInfo<Integer> M2MCustomerType() {
		accountInfo<Integer> input = new accountInfo<Integer>();
		input.setAddress(address);
		input.setBdom(bdom);
		input.setBillingFrequency(billingFrequency);
		input.setCity(city);
		input.setCountry(country);
		input.setCustomerType(M2MCustomerType);
		input.setLastName(lastName);
		return input;
	}
	
	public static accountInfo<Integer> missingBDOM() {
		accountInfo<Integer> input = new accountInfo<Integer>();
		input.setAddress(address);
		input.setBillingFrequency(billingFrequency);
		input.setCity(city);
		input.setCountry(country);
		input.setCustomerType(customerType);
		input.setLastName(lastName);
		return input;
	}
	
	public static accountInfo<Integer> missingBillingFrequency() {
		accountInfo<Integer> input = new accountInfo<Integer>();
		input.setAddress(address);
		input.setBdom(bdom);
		input.setCity(city);
		input.setCountry(country);
		input.setCustomerType(customerType);
		input.setLastName(lastName);
		return input;
	}
	
	public static accountInfo<Integer> invalidCustomerType() {
		accountInfo<Integer> input = new accountInfo<Integer>();
		input.setAddress(address);
		input.setBdom(bdom);
		input.setBillingFrequency(billingFrequency);
		input.setCity(city);
		input.setCountry(country);
		input.setCustomerType(invalidCustomerType);
		input.setLastName(lastName);
		return input;
	}
	
	public static accountInfo<Integer> prepaidData() {
		accountInfo<Integer> input = new accountInfo<Integer>();
		input.setAddress(address);
		input.setCity(city);
		input.setCountry(country);
		input.setCustomerType(customerType);
		input.setLastName(lastName);
		return input;
	}
	
	public static accountInfo<Integer> BDOM(String bdomType) {
		accountInfo<Integer> input = new accountInfo<Integer>();
		input.setAddress(address);
		input.setBdom(validBdom);
		input.setBillingFrequency(billingFrequency);
		input.setCity(city);
		input.setCountry(country);
		input.setCustomerType(customerType);
		input.setLastName(lastName);
		if(bdomType == "validBDOM") {
			input.setBdom(validBdom);
		} else if(bdomType == "invalidBDOM") {
			input.setBdom(invalidBdom);
		}
		return input;
	}
	
	public static accountInfo<Integer> quarterlyFrequency() {
		accountInfo<Integer> input = new accountInfo<Integer>();
		input.setAddress(address);
		input.setBdom(bdom);
		input.setBillingFrequency(invalidBillingFrequency);
		input.setCity(city);
		input.setCountry(country);
		input.setCustomerType(customerType);
		input.setLastName(lastName);
		return input;
	}
	
	public static accountInfo<Integer> withoutBDOM() {
		accountInfo<Integer> input = new accountInfo<Integer>();
		input.setBillingFrequency(billingFrequency);
		input.setCustomerType(customerType);
		return input;
	}
	
	public static accountInfo<Integer> withoutBillingFrequency() {
		accountInfo<Integer> input = new accountInfo<Integer>();
		input.setBdom(bdom);
		input.setCustomerType(customerType);
		return input;
	}
	
}
