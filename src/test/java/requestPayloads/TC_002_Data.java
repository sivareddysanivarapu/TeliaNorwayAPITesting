package requestPayloads;

import provision.accountInfo;
import provision.bundleGroup;
import provision.preferences;
import provision.primarySubscription;
import provision.provisionInput;
import provision.serviceInfo;
import stepDefinitions.ReUsableMethods;
import testData.TestData;
import testData.accountInfoData;
import testData.bundleGroupData;
import testData.preferencesData;

public class TC_002_Data extends TestData {
	
	public static provisionInput<Integer> inputRequestPayload() {

		accountInfo<Integer> inputAccount = accountInfoData.accountDataMandatory();
		preferences inputPreferences = preferencesData.preferencesInputMandatory();
		
		serviceInfo inputService = new serviceInfo();
		inputService.setPreferences(inputPreferences);
		
		primarySubscription<Integer> inputSubscription = new primarySubscription<Integer>();
		inputSubscription.setServiceIdentifier(ReUsableMethods.getCurrentDateTimeMS() + "1");
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
