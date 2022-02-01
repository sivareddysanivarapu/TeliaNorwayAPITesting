package requestPayloads;

import provision.accountInfo;
import provision.bundleGroup;
import provision.notifications;
import provision.preferences;
import provision.primarySubscription;
import provision.provisionRequest;
import provision.serviceInfo;
import stepDefinitions.ReUsableMethods;
import testData.TestData;
import testData.accountInfoData;
import testData.bundleGroupData;
import testData.notificationsData;
import testData.preferencesData;

public class Provision_Data extends TestData {

	public static provisionRequest<Integer> inputRequestPayload(String testCase, String... predata) {

		// AccountInfo Payload

		accountInfo<Integer> inputAccount;

		if (testCase == "TC002") {
			inputAccount = accountInfoData.accountDataMandatory();
		} else if (testCase == "TC009") {
			inputAccount = accountInfoData.missingCustomerType();
		} else if (testCase == "TC010") {
			inputAccount = accountInfoData.M2MCustomerType();
		} else if (testCase == "TC011") {
			inputAccount = accountInfoData.missingBDOM();
		} else if (testCase == "TC012") {
			inputAccount = accountInfoData.missingBillingFrequency();
		} else if (testCase == "TC013") {
			inputAccount = accountInfoData.BDOM("invalidBDOM");
		} else if (testCase == "TC022") {
			inputAccount = accountInfoData.invalidCustomerType();
		} else if (testCase == "TC032") {
			inputAccount = accountInfoData.prepaidData();
		} else if (testCase == "TC036") {
			inputAccount = accountInfoData.BDOM("validBDOM");
		} else if (testCase == "TC037") {
			inputAccount = accountInfoData.BDOM("invalidBDOM");
		} else if (testCase == "TC043") {
			inputAccount = accountInfoData.BDOM("invalidBDOM");
		} else if (testCase == "TC045") {
			inputAccount = accountInfoData.quarterlyFrequency();
		} else if (testCase == "TC048") {
			inputAccount = accountInfoData.withoutBDOM();
		} else if (testCase == "TC049") {
			inputAccount = accountInfoData.withoutBillingFrequency();
		} else {
			inputAccount = accountInfoData.accountData();
		}

		// Preferences Payload

		preferences inputPreferences;

		if (testCase == "TC002" || testCase == "TC046") {
			inputPreferences = preferencesData.preferencesInputMandatory(" ");
		} else if (testCase == "TC014") {
			inputPreferences = preferencesData.invalidEmail();
		} else if (testCase == "TC015") {
			inputPreferences = preferencesData.missingLanguage();
		} else if (testCase == "TC016") {
			inputPreferences = preferencesData.missingServiceProvider();
		} else if (testCase == "TC017") {
			inputPreferences = preferencesData.missingSubscriptionType();
		} else if (testCase == "TC035" || testCase == "TC039" || testCase == "TC042" 
				|| testCase == "TC043" || testCase == "TC044" || testCase == "TC045") {
			inputPreferences = preferencesData.preferencesInputMandatory("phonero");
		} else if (testCase == "TC038") {
			inputPreferences = preferencesData.phoneroNotificationPrice();
		} else if (testCase == "TC040") {
			inputPreferences = preferencesData.preferencesSMS();
		} else if (testCase == "TC041") {
			inputPreferences = preferencesData.preferencesEmail();
		} else if (testCase == "TC047") {
			inputPreferences = preferencesData.missingPreferences();
		} else if (testCase == "TC050") {
			inputPreferences = preferencesData.withoutLanguage();
		} else {
			inputPreferences = preferencesData.preferencesInput();
		}

		// Notification Payload

		notifications inputNotifications;

		if (testCase == "TC002") {
			inputNotifications = notificationsData.defaultNotifications();
		} else if (testCase == "TC018") {
			inputNotifications = notificationsData.missingDomestic();
		} else if (testCase == "TC019") {
			inputNotifications = notificationsData.missingRCC();
		} else if (testCase == "TC020") {
			inputNotifications = notificationsData.missingRoaming();
		} else if (testCase == "TC021") {
			inputNotifications = notificationsData.missingBarring();
		} else {
			inputNotifications = notificationsData.notificationsInput();
		}

		// ServiceInfo Payload

		serviceInfo inputService = new serviceInfo();
		inputService.setPreferences(inputPreferences);
		inputService.setNotifications(inputNotifications);

		// Subscription Payload

		primarySubscription<Integer> inputSubscription = new primarySubscription<Integer>();

		if (testCase == "TC004") {
			inputSubscription.setServiceIdentifier(null);
		} else if (testCase == "TC007") {
			inputSubscription.setServiceIdentifier(ReUsableMethods.getCurrentDateTimeMS() + "123");
		} else if (testCase == "TC023" || testCase == "TC034") {
			inputSubscription.setServiceIdentifier(predata[0]);
		} else {
			inputSubscription.setServiceIdentifier(ReUsableMethods.getCurrentDateTimeMS() + "1");
		}
		
		if (testCase == "TC005" || testCase == "TC048" || testCase == "TC049"
				|| testCase == "TC050" || testCase == "TC032") {
			inputSubscription.setImsi(null);
		} else if (testCase == "TC008") {
			inputSubscription.setImsi(ReUsableMethods.getCurrentDateTimeMS() + "123");
		} else if (testCase == "TC024") {
			inputSubscription.setImsi(predata[0]);
		} else {
			inputSubscription.setImsi(ReUsableMethods.getCurrentDateTimeMS() + "2");
		}
		
		if (testCase == "TC006") {
			inputSubscription.setSubscriptionMode(null);
		} else if (testCase == "TC025") {
			inputSubscription.setSubscriptionMode(invalidSubscriptionMode);
		} else if (testCase == "TC032" || testCase == "TC048" || testCase == "TC049"
				|| testCase == "TC050") {
			inputSubscription.setSubscriptionMode(prepaidSubscriptionMode);
		} else {
			inputSubscription.setSubscriptionMode(subscriptionMode);
		}

		inputSubscription.setAccountInfo(inputAccount);
		inputSubscription.setServiceInfo(inputService);

		// Bundle Payload

		bundleGroup inputBundle;

		if (testCase == "TC001" || testCase == "TC027") {
			inputBundle = bundleGroupData.onlyBase();
		} else if (testCase == "TC028") {
			inputBundle = bundleGroupData.onlyRoaming();
		} else if (testCase == "TC029") {
			inputBundle = bundleGroupData.onlyRCC();
		} else if (testCase == "TC239") {
			inputBundle = bundleGroupData.baseRoaming();
		} else if (testCase == "TC240") {
			inputBundle = bundleGroupData.baseRCC();
		} else if (testCase == "TC031") {
			inputBundle = null;
		} else if (testCase == "TC033") {
			inputBundle = bundleGroupData.invalidData();
		} else {
			inputBundle = bundleGroupData.bundleData();
		}

		// Provision Payload

		provisionRequest<Integer> input = new provisionRequest<Integer>();
		input.setBundleGroup(inputBundle);
		input.setSubscription(inputSubscription);

		return input;
	}

	public static provisionRequest<String> inputRequestPayload() {

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

		provisionRequest<String> input = new provisionRequest<String>();
		input.setBundleGroup(inputBundle);
		input.setSubscription(inputSubscription);

		return input;
	}

}
