Feature: Change Service Identifier of a Subscription

	@ChangeServiceIdentifier @Drop1
  Scenario Outline: <TC> Change Service Identifier with <Validity> <Identifier> serviceidentifier
    Given Input Request with <newValidity> Service Identifiers
    When "ChangeServiceIdentifier" API is called with <Validity> attributes
    Then Validate the <errorCode> code, status and message in "ChangeServiceIdentifier" output response
    
    @PrimarySubscription
    Examples:
    	|TC   |Validity      |errorCode|newValidity|Identifier|
    	|TC199|"Valid"       |"000"    |"Valid"    |Primary   |
    	|TC201|"Non-existant"|"ERR3030"|"Valid"    |Primary   |
    	|TC202|"Invalid"     |"ERR1001"|"Invalid"  |Primary   |
    	|TC203|"Existing"    |"ERR3021"|"Existing" |Primary   |
    	|TC205|"Invalid"     |"ERR1001"|"Missing"  |Primary   |
    	|TC208|"Invalid"     |"ERR1001"|"Blank"    |Blank     |
    	
    @SecondarySubscription
    Examples:
    	|TC   |Validity      |errorCode|newValidity|Identifier|
    	|TC200|"Valid"       |"000"    |"Valid"    |Secondary |
    	
    @CancelSubscription
    Examples:
    	|TC   |Validity      |errorCode|newValidity|Identifier|
    	|TC207|"Inactive"    |"ERR3030"|"Valid"    |Inactive  |
    	
    @ModifyServiceIdentifier
    Examples:
    	|TC   |Validity      |errorCode|newValidity|Identifier|
    	|TC209|"Inactive"    |"ERR3030"|"New"      |Old       |
  
  @ChangeServiceIdentifier @Drop1
  Scenario: TC204 Change Service Identifier of Subscription with missing Old Service Identifier
    Given Input Request with "Valid" Service Identifiers
    When "ChangeServiceIdentifier" API is called with "Missing" attributes
    Then Validate the status and error in output response
    