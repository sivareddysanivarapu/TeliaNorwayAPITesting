package requestPayloads;

import addSubscription.addSubscriptionRequest;
import provision.notifications;
import provision.preferences;
import provision.serviceInfo;
import stepDefinitions.ReUsableMethods;
import testData.notificationsData;
import testData.preferencesData;

public class AddSubscription_Data {
	
	public static addSubscriptionRequest inputRequestPayload(String testCase, String ...preData ) {

		// Preferences Payload

		preferences inputPreferences = null;

		if (testCase == "TC055") {
			inputPreferences = preferencesData.preferencesInputMandatory(" ");
		} 

		// Notification Payload

		notifications inputNotifications = null;

		if (testCase == "TC055") {
			inputNotifications = notificationsData.notificationsInput();
		}
		
		// ServiceInfo Payload
		
		serviceInfo inputService = null;

		if (testCase == "TC055") {
			inputService = new serviceInfo();
			inputService.setPreferences(inputPreferences);
			inputService.setNotifications(inputNotifications);
		}

		// Subscription Payload

		addSubscriptionRequest input = new addSubscriptionRequest();

		if (testCase == "TC055") {
			input.setServiceIdentifier(ReUsableMethods.getCurrentDateTimeMS() + "1");
		}
		
		
		if (testCase == "TC058") {
			input.setImsi(preData[1]);
		} else {
			input.setImsi(ReUsableMethods.getCurrentDateTimeMS() + "2");
		}
		
		input.setPrimaryServiceIdentifier(preData[0]);

		input.setServiceInfo(inputService);
		
		return input;
	}

}
