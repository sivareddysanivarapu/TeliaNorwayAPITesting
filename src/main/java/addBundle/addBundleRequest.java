package addBundle;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class addBundleRequest {
	
	private String bundleCode;
	private properties properties;
	
	public String getBundleCode() {
		return bundleCode;
	}
	public void setBundleCode(String bundleCode) {
		if (!String.valueOf(bundleCode).isEmpty())
			this.bundleCode = bundleCode;
	}
	public properties getProperties() {
		return properties;
	}
	public void setProperties(properties properties) {
		if (!String.valueOf(properties).isEmpty())
			this.properties = properties;
	}
	
}
