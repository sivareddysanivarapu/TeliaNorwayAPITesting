Feature: Delete Primary Subscription

	@DeleteSubscription @PrimarySubscription @Drop1
	Scenario: TC156 Delete Subscription by providing valid attributes
		Given Input Delete Request
		When "DeleteSubscription" API is called with "Valid" attributes
		
	@DeleteSubscription @PrimarySubscription @Drop1
	Scenario: TC157 Delete Subscription without providing attributes
		Given Input Delete Request
		When "DeleteSubscription" API is called with "no" attributes
		Then Validate the status and error in output response
		
	@DeleteSubscription @CancelSubscription @Drop1
	Scenario Outline: <TC> Delete Subscription with providing <Identifier> attributes
		Given Input Delete Request
		When "DeleteSubscription" API is called with <Validity> attributes
		Then Validate the "ERR3023" code, status and message in "DeleteSubscription" output response
		
		@CancelSubscription
		Examples:
			|TC   |Identifier|Validity  |
			|TC158|Inactive  |"Inactive"|
			
		Examples:
			|TC   |Identifier  |Validity      |
			|TC159|Non-existing|"Non-Existant"|
