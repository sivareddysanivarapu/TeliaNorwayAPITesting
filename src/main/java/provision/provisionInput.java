package provision;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class provisionInput<T> {
	
	private bundleGroup bundleGroup;
	private primarySubscription<T> subscription;

	
	public void setBundleGroup(bundleGroup bundleGroup) {
		if(!(bundleGroup==null)) {
			this.bundleGroup = bundleGroup;
		}
	}
	
	public void setSubscription(primarySubscription<T> subscription) {
		if(!(subscription==null)) {
			this.subscription = subscription;
		}
	}

	public provision.bundleGroup getBundleGroup() {
		return bundleGroup;
	}

	public primarySubscription<T> getSubscription() {
		return subscription;
	}

}
