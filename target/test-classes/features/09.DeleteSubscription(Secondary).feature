Feature: Delete Secondary Subscription

	@DeleteSubscription @SecondarySubscription @Drop1
	Scenario: TC165 Delete Secondary Subscription by providing valid attributes
		Given Input Delete Request
		When "DeleteSubscription" API is called with "Valid" attributes
		
	@DeleteSubscription @SecondarySubscription @Drop1
	Scenario Outline: <TC> Delete Secondary Subscription after deleting primary Subscription
		Given Input Delete Request
		When "DeletePrimarySubscription" API is called with "Valid" attributes
		And "DeleteSubscription" API is called with "Inactive" attributes
		Then Validate the "ERR3030" code, status and message in "DeleteSubscription" output response
		
		Examples:
			|TC   |
			|TC166|
			|TC168|
		
	@DeleteSubscription @CancelSecondarySubscription @Drop1
	Scenario: TC167 Delete Secondary Subscription with providing inactive attributes
		Given Input Delete Request
		When "DeleteSubscription" API is called with "Inactive" attributes
		Then Validate the "ERR3030" code, status and message in "DeleteSubscription" output response
		