Feature: Get Bundles for Active Subscription

	@GetBundles @Drop1
	Scenario Outline: <TC> GetBundles by providing valid serviceIdentifier and <bundleType> bundle
		Given Input Get Request 
		When "GetBundles" API is called with "Valid" attributes
    Then Validate the "GetBundles" output response
    
    @onlyBase
    Examples:
    	|TC   |bundleType|
   		|TC238|only Base |
   		
   	@BaseRoaming
    Examples:
    	|TC   |bundleType      |
   		|TC239|Base and Roaming|
   		
   	@BaseRCC
    Examples:
    	|TC   |bundleType  |
   		|TC240|Base and RCC|
   		
   @BaseAddOn
    Examples:
    	|TC   |bundleType    |
   		|TC241|Base and AddOn|
   		
   @BundleGroup
    Examples:
    	|TC   |bundleType|
   		|TC242|Group     |
   		
  @GetBundles @Drop1
	Scenario Outline: <TC> GetBundles by providing <Identifier> serviceIdentifier and <bundleType> bundle
		Given Input Get Request 
		When "GetBundles" API is called with <Validity> attributes
    Then Validate the <errorCode> code, status and message in "GetBundles" output response
    
    @SecondarySubscription
    Examples:
    	|TC   |bundleType|Validity|errorCode|Identifier|
    	|TC243|without   |"Server"|"ERR2024"|Valid     |
    	
    @CancelSubscription
    	Examples:
    	|TC   |bundleType|Validity  |errorCode|Identifier|
    	|TC244|base      |"Inactive"|"ERR3023"|Inactive  |
    	
    	Examples:
    	|TC   |bundleType|Validity |errorCode|Identifier    |
    	|TC245|base      |"Invalid"|"ERR3023"|Non-existant  |
    	
  @GetBundles @Drop1
	Scenario: TC246 GetBundles without providing serviceIdentifier
		Given Input Get Request
		When "GetBundles" API is called with "Missing" attributes
		Then Validate the status and error in output response