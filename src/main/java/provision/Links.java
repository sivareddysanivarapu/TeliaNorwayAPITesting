package provision;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Links {
	
	@JsonProperty
	private href AddProvision;
	@JsonProperty
	private href AddSubscription;
	
	public Links() {}

	public href getAddProvision() {
		return AddProvision;
	}

	public href getAddSubscription() {
		return AddSubscription;
	}

}
