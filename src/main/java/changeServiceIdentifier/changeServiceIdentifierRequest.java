package changeServiceIdentifier;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class changeServiceIdentifierRequest {
	
	private String newServiceIdentifier;

	public String getNewServiceIdentifier() {
		return newServiceIdentifier;
	}

	public void setNewServiceIdentifier(String newServiceIdentifier) {
		if (!String.valueOf(newServiceIdentifier).isEmpty()) {
			this.newServiceIdentifier = newServiceIdentifier;
		}
	}
	
}
