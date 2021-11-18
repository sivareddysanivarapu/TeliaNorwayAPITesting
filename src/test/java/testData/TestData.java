package testData;

public class TestData {
	
	// Optional accountInfo Data
	protected static String lastName = "Surasani";
	protected static String address = "Hyd";
	protected static String city = "Norway";
	protected static String country = "Norway";

	//// Optional preferences Data
	protected static String brandInfo = "Sonera";
	protected static String channel = "sms";
	protected static String tcId = "121313";

	// Optional notifications Data
	protected static int on = 1;
	protected static int off = 0;

	// Mandatory accountInfo Data
	protected static String customerType = "Consumer";
	protected static String M2MCustomerType = "M2M";
	protected static int bdom = 28;
	protected static String billingFrequency = "Monthly";
	protected static int invalidBdom = 29;
	protected static String invalidCustomerType = "Invalid";
	protected static String invalidData = "One";

	// Mandatory preferences Data
	protected static String serviceProviderId = "TS";
	protected static String subscriptionType = "1";
	protected static String language = "ENG";
	protected static String emailAddress = "asurasan@outlook.com";
	protected static String invalidEmailAddress = "asurasan";

	// Mandatory Subscription Data
	protected static String subscriptionMode = "postpaid";
	protected static String existingServiceIdentifier = "1000";
	protected static String existingImsi = "1001";
	protected static String invalidSubscriptionMode = "Invalid";
	
	//Mandatory Bundle Data
	protected static String bundleCode = "NOMT-B-N124_NC300_N1014_NoRLH-2127";
	protected static String roamingBundleCode = "FGM";
	protected static String RCCBundleCode = "RCC";
	protected static String topupBundleCode = "GED";
	protected static String invalidCode = "000";
	
	//Mandatory Bundle Properties Data
	protected static int limit = 10;
	
	//ModifySubscription Data
	protected static String modifiedCustomerType = "Business";
	protected static int modifiedBDOM = 25;
	protected static String modifiedBillingFrequency = "Quarterly";
	
	//CR23 Test Data
	protected static String newSubscriptionMode = "prepaid";
	
	
}
