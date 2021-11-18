package provision;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class primarySubscription<T> {
	
	private String serviceIdentifier;
	private String imsi;
	private String subscriptionMode;
	private accountInfo<T> accountInfo;
	private serviceInfo serviceInfo;

	public void setServiceIdentifier(String serviceIdentifier) {
		if(!serviceIdentifier.isEmpty()) {
			this.serviceIdentifier = serviceIdentifier;
		}
	}

	public void setImsi(String imsi) {
		if(!imsi.isEmpty()) {
			this.imsi = imsi;
		}
	}

	public void setSubscriptionMode(String subscriptionMode) {
		if(!subscriptionMode.isEmpty()) {
			this.subscriptionMode = subscriptionMode;
		}
	}

	public void setAccountInfo(accountInfo<T> accountInfo) {
		this.accountInfo = accountInfo;
	}

	public void setServiceInfo(serviceInfo serviceInfo) {
		this.serviceInfo = serviceInfo;
	}

	public String getServiceIdentifier() {
		return serviceIdentifier;
	}

	public String getImsi() {
		return imsi;
	}

	public String getSubscriptionMode() {
		return subscriptionMode;
	}
	
	public accountInfo<T> getAccountInfo() {
		return accountInfo;
	}

	public serviceInfo getServiceInfo() {
		return serviceInfo;
	}


}
