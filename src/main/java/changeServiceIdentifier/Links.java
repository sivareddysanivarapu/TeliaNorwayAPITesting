package changeServiceIdentifier;

import com.fasterxml.jackson.annotation.JsonProperty;

import provision.href;

public class Links {
	
	@JsonProperty
	private href ChangeServiceIdentifier;

	public Links() {}

	public href getChangeServiceIdentifier() {
		return ChangeServiceIdentifier;
	}

}
