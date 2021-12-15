package addRCCBundle;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class addRCCBundleRequest {

	private String bundleCode;
	private properties properties;

	public void setBundleCode(String bundleCode) {
		this.bundleCode = bundleCode;
	}

	public void setProperties(properties properties) {
		if (!String.valueOf(properties).isEmpty()) {
			this.properties = properties;
		}
	}

	public String getBundleCode() {
		return bundleCode;
	}

	public properties getProperties() {
		return properties;
	}

}
