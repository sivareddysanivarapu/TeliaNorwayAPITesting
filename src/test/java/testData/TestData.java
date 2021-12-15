package testData;

public class TestData {
	
	// Optional accountInfo Data
	protected static String lastName = "Surasani";
	protected static String address = "Hyd";
	protected static String city = "Norway";
	protected static String country = "Norway";

	//// Optional preferences Data
	protected static String brandInfo = "teliano";
	protected static String phoneroBrandInfo = "phonero";
	protected static String channel = "SMS";
	protected static String emailChannel = "Email";
	protected static String notificationPrice = "10.20";

	// Optional notifications Data
	public static int on = 1;
	public static int off = 0;

	// Mandatory accountInfo Data
	protected static String customerType = "Consumer";
	protected static String M2MCustomerType = "M2M";
	protected static int bdom = 1;
	protected static String billingFrequency = "Monthly";
	protected static String invalidBillingFrequency = "Quarterly";
	protected static int validBdom = 7;
	protected static int invalidBdom = 12;
	protected static String invalidCustomerType = "Invalid";
	protected static String invalidData = "One";

	// Mandatory preferences Data
	protected static String serviceProviderId = "TS";
	protected static String subscriptionType = "1";
	protected static String language = "ENG";
	protected static String emailAddress = "asurasan@outlook.com";
	protected static String invalidEmailAddress = "asurasan";
	protected static String tcId = "iol406";

	// Mandatory Subscription Data
	protected static String subscriptionMode = "postpaid";
	protected static String prepaidSubscriptionMode = "prepaid";
	protected static String existingServiceIdentifier = "1000";
	protected static String existingImsi = "1001";
	protected static String invalidSubscriptionMode = "Invalid";
	
	//Mandatory Bundle Data
	public static String bundleCode = "B0001";
	public static String roamingBundleCode = "Roam0001";
	public static String RCCBundleCode = "RCC0001";
	public static String topupBundleCode = "TopUp0008";
	public static String addOnBundleCode = "Addon0005";
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
