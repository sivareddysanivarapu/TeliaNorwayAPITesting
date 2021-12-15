package getBundles;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class roamingBundle {
	
	@JsonProperty("bundleCode")
	private String bundleCode;
	@JsonProperty("notifications")
	private int notifications;
	@JsonProperty("creationDate")
	private String creationDate;
	@JsonProperty("modificationDate")
	private String modificationDate;
	@JsonProperty("bundleType")
	private String bundleType;
	@JsonProperty("status")
	private String status;
	
	public String getBundleCode() {
		return bundleCode;
	}
	public int getNotifications() {
		return notifications;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public String getModificationDate() {
		return modificationDate;
	}
	public String getBundleType() {
		return bundleType;
	}
	public String getStatus() {
		return status;
	}
	
}
