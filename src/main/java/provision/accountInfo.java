package provision;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class accountInfo<T> {
	
	private String customerType;
	private String lastName;
	private String address;
	private String city;
	private String country;
	private T bdom;
	private String billingFrequency;
	
	public void setCustomerType(String customerType) {
		if(!customerType.isEmpty()) {
			this.customerType = customerType;
		}
	}

	public void setLastName(String lastName) {
		if(!lastName.isEmpty()) {
			this.lastName = lastName;
		}
	}

	public void setAddress(String address) {
		if(!address.isEmpty()) {
			this.address = address;
		}
	}

	public void setCity(String city) {
		if(!city.isEmpty()) {
			this.city = city;
		}
	}

	public void setCountry(String country) {
		if(!country.isEmpty()) {
			this.country = country;
		}
	}

	public void setBdom(T bdom) {
		if(!String.valueOf(bdom).isEmpty()) {
			this.bdom = bdom;
		}
	}

	public void setBillingFrequency(String billingFrequency) {
		if(!billingFrequency.isEmpty()) {
			this.billingFrequency = billingFrequency;
		}
	}

	public String getCustomerType() {
		return customerType;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public T getBdom() {
		return bdom;
	}

	public String getBillingFrequency() {
		return billingFrequency;
	}
	
}
