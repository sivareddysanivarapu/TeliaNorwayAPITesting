Feature: Purchase RCC Bundle

	@AddRCCBundle @onlyBase
	Scenario Outline: <TC> Purchase RCC Bundle with <validBundle> bundleCode
		Given Input AddRCCBundle Request with <validBundle> bundleCode
		When "AddRCCBundle" API is called with <Validity> attributes
    Then Validate the <errorCode> code, status and message in "AddRCCBundle" output response
    
    Examples:
    	|TC   |Validity |validBundle|errorCode|
    	|TC066|"Valid"  |"RCC"      |"000"    |
    	|TC069|"Invalid"|"Invalid"  |"ERR1001"|
    	|TC070|"Invalid"|"Roaming"  |"ERR1001"|
    	|TC076|"Invalid"|"no"       |"ERR1001"|
    	
  @AddRCCBundle
  Scenario: TC068 Purchase RCC Bundle without providing serviceIdentifier in path parameter
  	Given Input AddRCCBundle Request with "RCC" bundleCode
		When "AddRCCBundle" API is called with "Missing" attributes
    Then Validate the status and error in output response
    
  @AddRCCBundle
  Scenario Outline: <TC> Purchase RCC Bundle with providing <Validity> serviceIdentifier in path parameter
  	Given Input AddRCCBundle Request with "RCC" bundleCode
		When "AddRCCBundle" API is called with <Valid> attributes
    Then Validate the <errorCode> code, status and message in "AddRCCBundle" output response
    
    @CancelSubscription
    Examples:
    	|TC   |Validity|Valid     |errorCode|
    	|TC071|Inactive|"Inactive"|"ERR3030"|
    	
    @SecondarySubscription
    Examples:
    	|TC   |Validity |Valid      |errorCode|
    	|TC072|Secondary|"Secondary"|"ERR3031"|
    	
    Examples:
    	|TC   |Validity    |Valid         |errorCode|
    	|TC073|Non-existant|"Non-existant"|"ERR3030"|
    	
    @PrimarySubscription
    Examples:
    	|TC   |Validity|Valid     |errorCode|
    	|TC077|Existing|"Existant"|"ERR3029"|
   