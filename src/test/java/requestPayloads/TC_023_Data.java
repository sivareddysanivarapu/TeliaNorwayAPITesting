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

public class TC_023_Data extends TestData {
	
	public static provisionInput<Integer> inputRequestPayload(String psi) {

		accountInfo<Integer> inputAccount = accountInfoData.accountData();
		preferences inputPreferences = preferencesData.preferencesInput();
		notifications inputNotifications = notificationsData.notificationsInput();
		
		serviceInfo inputService = new serviceInfo();
		inputService.setPreferences(inputPreferences);
		inputService.setNotifications(inputNotifications);
		
		primarySubscription<Integer> inputSubscription = new primarySubscription<Integer>();
		inputSubscription.setServiceIdentifier(psi);
		inputSubscription.setImsi(ReUsableMethods.getCurrentDateTimeMS() + "2");
		inputSubscription.setSubscriptionMode(subscriptionMode);
		inputSubscription.setAccountInfo(inputAccount);
		inputSubscription.setServiceInfo(inputService);
		
		bundleGroup inputBundle = bundleGroupData.bundleData();
		
		provisionInput<Integer> input = new provisionInput<Integer>();
		input.setBundleGroup(inputBundle);
		input.setSubscription(inputSubscription);

		return input;
	}

}