Feature: Add secondary subscription

	@AddSubscription @Drop1
	Scenario Outline: <TC> Create <Identifier> Secondary Subscription with <attribute> attributes
		Given Input AddSubscription Request with <attribute> attributes
		When "AddSubscription" API is called with <Validity> attributes
    Then Validate the <errorCode> code, status and message in "AddSubscription" output response
    
    @PrimarySubscription
    Examples:
    	|TC   |attribute      |Validity      |errorCode|Identifier|
    	|TC055|"all"          |"Valid"       |"000"    |One       |
    	|TC056|"Invalid"      |"Non-existant"|"ERR3023"|One       |
    	|TC057|"onlyMandatory"|"Valid"       |"000"    |One       |
    	
    @SecondarySubscription
    Examples:
    	|TC   |attribute  |Validity  |errorCode|Identifier|
    	|TC058|"Duplicate"|"Existing"|"ERR3022"|Multiple  |
    	|TC061|"Unique"   |"Valid"   |"000"    |Multiple  |
    	
    @CancelSubscription
    Examples:
    	|TC   |attribute |Validity  |errorCode|Identifier|
    	|TC059|"Inacitve"|"Inacitve"|"ERR3023"|Single    |
 