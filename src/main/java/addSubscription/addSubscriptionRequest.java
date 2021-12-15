package addSubscription;

import com.fasterxml.jackson.annotation.JsonInclude;
import provision.serviceInfo;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class addSubscriptionRequest {
	
	private String serviceIdentifier;
	private String primaryServiceIdentifier;
	private String imsi;
	private serviceInfo serviceInfo;

	public void setServiceIdentifier(String serviceIdentifier) {
			this.serviceIdentifier = serviceIdentifier;
	}
	
	public void setPrimaryServiceIdentifier(String primaryServiceIdentifier) {
		this.primaryServiceIdentifier = primaryServiceIdentifier;
	}

	public void setImsi(String imsi) {
			this.imsi = imsi;
	}

	public void setServiceInfo(serviceInfo serviceInfo) {
		this.serviceInfo = serviceInfo;
	}

	public String getServiceIdentifier() {
		return serviceIdentifier;
	}
	
	public String getPrimaryServiceIdentifier() {
		return primaryServiceIdentifier;
	}

	public String getImsi() {
		return imsi;
	}

	public serviceInfo getServiceInfo() {
		return serviceInfo;
	}


}
