package addBundle;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class properties {
	
	private String validTo;

	public String getValidTo() {
		return validTo;
	}

	public void setValidTo(String validTo) {
		if (!String.valueOf(validTo).isEmpty())
			this.validTo = validTo;
	}
	
}
