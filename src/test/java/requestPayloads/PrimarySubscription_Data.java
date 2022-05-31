package requestPayloads;

import provision.accountInfo;
import provision.notifications;
import provision.preferences;
import provision.primarySubscription;
import provision.serviceInfo;
import stepDefinitions.ReUsableMethods;
import testData.TestData;
import testData.accountInfoData;
import testData.notificationsData;
import testData.preferencesData;

public class PrimarySubscription_Data extends TestData {

	public static primarySubscription<Integer> inputRequestPayload() {

		accountInfo<Integer> inputAccount = accountInfoData.accountData();
		preferences inputPreferences = preferencesData.preferencesInput();
		notifications inputNotifications = notificationsData.notificationsInput();

		serviceInfo inputService = new serviceInfo();
		inputService.setPreferences(inputPreferences);
		inputService.setNotifications(inputNotifications);

		primarySubscription<Integer> inputSubscription = new primarySubscription<Integer>();
		inputSubscription.setServiceIdentifier(ReUsableMethods.getCurrentDateTimeMS() + "1");
		inputSubscription.setImsi(ReUsableMethods.getCurrentDateTimeMS() + "2");
		inputSubscription.setSubscriptionMode(subscriptionMode);
		inputSubscription.setAccountInfo(inputAccount);
		inputSubscription.setServiceInfo(inputService);

		return inputSubscription;
	}

}
