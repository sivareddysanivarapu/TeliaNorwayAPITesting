package provision;

import com.fasterxml.jackson.annotation.JsonInclude;

public class serviceInfo {
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private preferences preferences;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private notifications notifications;
	
	public void setPreferences(preferences preferences) {
		if(!(preferences==null)) {
			this.preferences = preferences;
		}
	}
	public void setNotifications(notifications notifications) {
		if(!(notifications==null)) {
			this.notifications = notifications;
		}
	}
	public preferences getPreferences() {
		return preferences;
	}
	public notifications getNotifications() {
		return notifications;
	}
	
}
