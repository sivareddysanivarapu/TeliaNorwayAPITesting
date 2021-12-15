Feature: Purchase RCC Bundle

	@AddRCCBundle @PrimarySubscription
	Scenario Outline: <TC> Purchase RCC Bundle with <validBundle> bundleCode and <with/without> <optionalFields>
		Given Input AddRCCBundle Request with <validBundle> bundleCode and <with/without> <optionalFields>
		When "AddRCCBundle" API is called with <Validity> attributes
    Then Validate the <errorCode> code, status and message in "AddRCCBundle" output response
    
    Examples:
    	|TC   |Validity |validBundle|with/without|optionalFields|errorCode|
    	|TC066|"Valid"  |"RCC"      |"with"      |"properties"  |"000"    |
    	|TC067|"Valid"  |"RCC"      |"without"   |"properties"  |"000"    |
    	|TC069|"Invalid"|"Invalid"  |"without"   |"properties"  |"ERR1001"|
    	|TC070|"Invalid"|"Roaming"  |"without"   |"properties"  |"ERR1001"|
    	|TC074|"Valid"  |"RCC"      |"without"   |"limit"       |"000"    |
    	|TC075|"Invalid"|"RCC"      |"Invalid"   |"limit"       |"ERR1001"|
    	|TC076|"Invalid"|"no"       |"without"   |"properties"  |"ERR1001"|
    	
  @AddRCCBundle
  Scenario: TC068 Purchase RCC Bundle without providing serviceIdentifier in path parameter
  	Given Input AddRCCBundle Request with "RCC" bundleCode and "without" "properties"
		When "AddRCCBundle" API is called with "Missing" attributes
    Then Validate the status and error in output response
    
  @AddRCCBundle @InactiveSubscription
  Scenario Outline: <TC> Purchase RCC Bundle with providing <Validity> serviceIdentifier in path parameter
  	Given Input AddRCCBundle Request with "RCC" bundleCode and "without" "properties"
		When "AddRCCBundle" API is called with <Valid> attributes
    Then Validate the "ERR3023" code, status and message in "AddRCCBundle" output response
    
    @InactiveSubscription
    Examples:
    	|TC   |Validity|Valid     |
    	|TC071|Inactive|"Inactive"|
    	
    @SecondarySubscription
    Examples:
    	|TC   |Validity |Valid    |
    	|TC072|Secondary|"Invalid"|
    	
    Examples:
    	|TC   |Validity    |Valid         |
    	|TC073|Non-existant|"Non-existant"|
    	
    @PurchaseRCCBundle
    Examples:
    	|TC   |Validity|Valid     |
    	|TC077|Existing|"Existant"|
   