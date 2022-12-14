Feature: Delete Base/Roaming/AddOn bundles

	@DeleteBundle @Drop1
	Scenario Outline: <TC> DeleteBundle by providing valid service identifier and <bundleType> Bundle code
		Given Input Delete Request
		When "DeleteBundle" API is called with <bundleType> attributes
		
		@BundleGroup
		Examples:
			|TC   |bundleType     |
			|TC255|"Valid Roaming"|
			|TC268|"Valid AddOn"  |
			
	@DeleteBundle @Drop1
	Scenario Outline: <TC> DeleteBundle by providing <Validity> service identifier and <bundleType> Bundle code
		Given Input Delete Request
		When "DeleteBundle" API is called with <valid> attributes
		Then Validate the <errorCode> code, status and message in "DeleteBundle" output response
		
		@PrimarySubscription
		Examples:
			|TC   |bundleType|Validity|valid    |errorCode|
			|TC257|Base      |Valid   |"Base"   |"ERR1026"|
			|TC264|RCC       |Valid   |"RCC"    |"ERR1027"|
			|TC265|Invalid   |Valid   |"Invalid"|"ERR1001"|
			
		@CancelBundle
		Examples:
			|TC   |bundleType|Validity|valid     |errorCode|
			|TC263|Inactive  |Valid   |"Inactive"|"ERR3024"|
			
		@noBundlesPrimary
		Examples:
			|TC   |bundleType|Validity|valid     |errorCode|
			|TC266|No        |Valid   |"Inactive"|"ERR3024"|	
			
	@DeleteBundle @Drop1
	Scenario Outline: <TC> DeleteBundle by providing <Validity> service identifier and <bundleType> Bundle code
		Given Input Delete Request
		When "DeleteBundle" API is called with <valid> attributes
		Then Validate the status and error in output response
		
		@PrimarySubscription
		Examples:
			|TC   |Validity|bundleType|valid                      |
			|TC258|Missing |valid     |"Missing serviceIdentifier"|
			|TC259|Valid   |Missing   |"Missing Bundle"           |
		
	@DeleteBundle @Drop1
	Scenario Outline: <TC> DeleteBundle by providing <Validity> service identifier and <bundleType> Bundle code
		Given Input Delete Request
		When "DeleteBundle" API is called with <valid> attributes
		Then Validate the <errorCode> code, status and message in "DeleteBundle" output response
		
		@CancelSubscription
		Examples:
			|TC   |bundleType|Validity|valid     |errorCode|
			|TC260|Inactive  |Valid   |"Inactive"|"ERR3030"|	
			
		Examples:
			|TC   |bundleType|Validity       |valid         |errorCode|
			|TC261|Valid     |Non-Existant   |"Non-existant"|"ERR3030"|
			
		@SecondarySubscription
		Examples:
			|TC   |bundleType|Validity |valid     |errorCode|
			|TC262|Valid     |Secondary|"Conflict"|"ERR3031"|