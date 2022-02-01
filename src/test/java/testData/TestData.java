package testData;

public class TestData {
	
	// Optional accountInfo Data
	public static String lastName = "Surasani";
	public static String address = "Hyd";
	public static String city = "Norway";
	public static String country = "Norway";

	//// Optional preferences Data
	public static String brandInfo = "teliano";
	public static String phoneroBrandInfo = "phonero";
	public static String channel = "SMS";
	public static String emailChannel = "Email";
	public static String notificationPrice = "10.20";

	// Optional notifications Data
	public static int on = 1;
	public static int off = 0;

	// Mandatory accountInfo Data
	public static String customerType = "Consumer";
	public static String M2MCustomerType = "M2M";
	public static int bdom = 1;
	public static String billingFrequency = "Monthly";
	public static String invalidBillingFrequency = "Quarterly";
	public static int validBdom = 7;
	public static int invalidBdom = 12;
	protected static String invalidCustomerType = "Invalid";
	protected static String invalidData = "One";

	// Mandatory preferences Data
	public static String serviceProviderId = "TS";
	public static String subscriptionType = "1";
	public static String language = "ENG";
	public static String emailAddress = "asurasan@outlook.com";
	public static String invalidEmailAddress = "asurasan";
	public static String tcId = "iol406";

	// Mandatory Subscription Data
	public static String subscriptionMode = "postpaid";
	protected static String prepaidSubscriptionMode = "prepaid";
	protected static String existingServiceIdentifier = "1000";
	protected static String existingImsi = "1001";
	protected static String invalidSubscriptionMode = "Invalid";
	
	//Mandatory Bundle Data
	public static String bundleCode = "B0001";
	public static String roamingBundleCode = "Roam0001";
	public static String RCCBundleCode = "RCC0001";
	public static String topupBundleCode = "TopUp0008";
	public static String roamTopupBundleCode = "TopUp0008";
	public static String addOnBundleCode = "AddOn0005";
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
