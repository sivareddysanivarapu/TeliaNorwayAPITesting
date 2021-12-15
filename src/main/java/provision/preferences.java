package provision;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class preferences {
	
	private String serviceProviderId;
	private String subscriptionType;
	private String language;
	private String emailAddress;
	private String notificationPrice;
	private String brandInfo;
	private String tcId;
	private String channel;
	private String alternateNumber;
	
	public void setServiceProviderId(String serviceProviderId) {
		if(!serviceProviderId.isEmpty()) {
			this.serviceProviderId = serviceProviderId;
		}
	}
	public void setSubscriptionType(String subscriptionType) {
		if(!subscriptionType.isEmpty()) {
			this.subscriptionType = subscriptionType;
		}
	}
	public void setLanguage(String language) {
		if(!language.isEmpty()) {
			this.language = language;
		}
	}
	public void setEmailAddress(String emailAddress) {
		if(!emailAddress.isEmpty()) {
			this.emailAddress = emailAddress;
		}
	}
	public void setNotificationPrice(String notificationPrice) {
		if(!notificationPrice.isEmpty()) {
			this.notificationPrice = notificationPrice;
		}
	}
	public void setBrandInfo(String brandInfo) {
		if(!brandInfo.isEmpty()) {
			this.brandInfo = brandInfo;
		}
	}
	public void setTcId(String tcId) {
		if(!tcId.isEmpty()) {
			this.tcId = tcId;
		}
	}
	public void setChannel(String channel) {
		if(!channel.isEmpty()) {
			this.channel = channel;
		}
	}
	public void setAlternateNumber(String alternateNumber) {
		if(!alternateNumber.isEmpty()) {
			this.alternateNumber = alternateNumber;
		}
	}
	public String getServiceProviderId() {
		return serviceProviderId;
	}
	public String getSubscriptionType() {
		return subscriptionType;
	}
	public String getLanguage() {
		return language;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public String getNotificationPrice() {
		return notificationPrice;
	}
	public String getBrandInfo() {
		return brandInfo;
	}
	public String getTcId() {
		return tcId;
	}
	public String getChannel() {
		return channel;
	}
	public String getAlternateNumber() {
		return alternateNumber;
	}
	
}
