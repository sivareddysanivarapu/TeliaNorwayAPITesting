package getSubscription;

import com.fasterxml.jackson.annotation.JsonProperty;

public class getSubscriptionResponse {
	
	private String creationDate;
	private String modificationDate;
	private String msisdn;
	private String imsi;
	private String supi;
	private String status;
	private String subscriptionMode;
	private provision.accountInfo<Integer> accountInfo;
	@JsonProperty("serviceInfo")
	private provision.serviceInfo serviceInfo;
	
	public getSubscriptionResponse() {
		
	}

	public String getCreationDate() {
		return creationDate;
	}

	public String getModificationDate() {
		return modificationDate;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public String getImsi() {
		return imsi;
	}
	
	public String getSupi() {
		return supi;
	}

	public String getStatus() {
		return status;
	}

	public String getSubscriptionMode() {
		return subscriptionMode;
	}

	public provision.accountInfo<Integer> getAccountInfo() {
		return accountInfo;
	}

	public provision.serviceInfo getServiceinfo() {
		return serviceInfo;
	}

}
