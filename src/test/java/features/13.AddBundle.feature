Feature: Purchase Base/Roaming/Addon Bundles

	@AddBundle @Drop1
	Scenario Outline: <TC> AddBundle by providing <Identifier> serviceIdentifier and <bundleType> bundle
		Given Input Request with <bundleType> bundle <with/without> properties
		When "AddBundle" API is called with <valid> attributes
		Then Validate the <errorCode> code, status and message in "AddBundle" output response
		
		@noBundlesPrimary
		Examples:
			|TC   |bundleType|errorCode|with/without|valid    |Identifier|
			|TC214|"Base"    |"000"    |"without"   |"Valid"  |Valid     |
			
		@onlyBase
		Examples:
			|TC   |bundleType|errorCode|with/without|valid    |Identifier|
			|TC216|"Roaming" |"000"    |"without"   |"Valid"  |Valid     |
			
		@PrimarySubscription
		Examples:
			|TC   |bundleType|errorCode|with/without|valid     |Identifier|
			|TC217|"AddOn"   |"000"    |"without"   |"Valid"   |Valid     |
			|TC218|"Base"    |"ERR3027"|"with"      |"Existing"|Valid     |
			|TC220|"Roaming" |"ERR3028"|"with"      |"Existing"|Valid     |
			|TC221|"AddOn"   |"000"    |"with"      |"Valid"   |Valid     |
			|TC226|"RCC"     |"ERR1001"|"without"   |"Invalid" |Valid     |
			|TC227|"TopUp"   |"ERR1001"|"without"   |"Invalid" |Valid     |
			|TC228|"Invalid" |"ERR1001"|"without"   |"Invalid" |Valid     |
			|TC229|"No"      |"ERR1001"|"without"   |"Invalid" |Valid     |
			
		@CancelSubscription
		Examples:
			|TC   |bundleType|errorCode|with/without|valid     |Identifier|
			|TC231|"Roaming" |"ERR3030"|"without"   |"Inactive"|Inacitve  |
			
		Examples:
			|TC   |bundleType|errorCode|with/without|valid         |Identifier  |
			|TC232|"Roaming" |"ERR3030"|"without"   |"Non-existant"|Non-existant|
			
	@AddBundle @PrimarySubscription @Drop1
	Scenario Outline: <TC> AddBundle by providing valid serviceIdentifier and multiple <bundleType> bundle
		Given Input Request with <bundleType> bundle <with/without> properties
		When "AddBundle" API is called with <newValid> attributes
		Then Validate the <errorCode> code, status and message in "AddBundle" output response
		
		Examples:
			|TC   |bundleType|errorCode|with/without|newValid  |
			|TC222|"Base"    |"ERR3027"|"without"   |"Existing"|
			|TC224|"Roaming" |"ERR3028"|"without"   |"Existing"|
			
	@AddBundle @PrimarySubscription @Drop1
	Scenario Outline: <TC> AddBundle by providing valid serviceIdentifier and multiple <bundleType> bundle
		Given Input Request with <bundleType> bundle <with/without> properties
		When "AddBundle" API is called with <valid> attributes
		And "AddBundle" API is called with <newValid> attributes
		Then Validate the <errorCode> code, status and message in "AddBundle" output response
		
		Examples:
			|TC   |bundleType|errorCode|with/without|valid    |newValid   |
			|TC225|"AddOn"   |"ERR3026"|"with"      |"Valid"  |"Existing" |
			
	@AddBundle @Drop1
	Scenario: TC230 AddBundle without providing valid serviceIdentifier
		Given Input Request with "Roaming" bundle "without" properties
		When "AddBundle" API is called with "Missing" attributes
		Then Validate the status and error in output response
		