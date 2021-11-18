package requestPayloads;

import provision.accountInfo;
import provision.bundleGroup;
import provision.notifications;
import provision.preferences;
import provision.primarySubscription;
import provision.provisionInput;
import provision.serviceInfo;
import stepDefinitions.ReUsableMethods;
import testData.TestData;
import testData.accountInfoData;
import testData.bundleGroupData;
import testData.notificationsData;
import testData.preferencesData;

public class TC_003_Data extends TestData{
	
	public static provisionInput<String> inputRequestPayload() {

		accountInfo<String> inputAccount = accountInfoData.accountInvalidDataType();
		preferences inputPreferences = preferencesData.preferencesInput();
		notifications inputNotifications = notificationsData.notificationsInput();
		
		serviceInfo inputService = new serviceInfo();
		inputService.setPreferences(inputPreferences);
		inputService.setNotifications(inputNotifications);
		
		primarySubscription<String> inputSubscription = new primarySubscription<String>();
		inputSubscription.setServiceIdentifier(ReUsableMethods.getCurrentDateTimeMS() + "1");
		inputSubscription.setImsi(ReUsableMethods.getCurrentDateTimeMS() + "2");
		inputSubscription.setSubscriptionMode(subscriptionMode);
		inputSubscription.setAccountInfo(inputAccount);
		inputSubscription.setServiceInfo(inputService);
		
		bundleGroup inputBundle = bundleGroupData.bundleData();
		
		provisionInput<String> input = new provisionInput<String>();
		input.setBundleGroup(inputBundle);
		input.setSubscription(inputSubscription);

		return input;
	}


}
