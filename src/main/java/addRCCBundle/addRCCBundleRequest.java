package addRCCBundle;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class addRCCBundleRequest {

	private String bundleCode;

	public void setBundleCode(String bundleCode) {
		this.bundleCode = bundleCode;
	}

	public String getBundleCode() {
		return bundleCode;
	}

}
