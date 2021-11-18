package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import provision.provisionInput;
import provision.provisionOutput;
import requestPayloads.*;

public class stepDefinition extends ReUsableMethods{
	
	RequestSpecification req;
	Response output;
	ResponseBody<Response> response;
	static String primaryServiceIdentifier;
	static String imsi;
	static String alternateNumber;
	static String getIdentifier;
	static String supi;
	static String accessToken;
	
	@Given("Input Provision Request with mandatory attributes")
	public void input_provision_request_with_mandatory_attributes() throws IOException {
		provisionInput<Integer> inputRequest = TC_001_Data.inputRequestPayload();
		req = given().spec(givenHeader()).body(inputRequest);
		primaryServiceIdentifier = inputRequest.getSubscription().getServiceIdentifier();
		imsi = inputRequest.getSubscription().getImsi();
	}
	
	@Given("Input Provision Request without optional fields")
	public void input_provision_request_without_optional_fields() throws IOException {
		provisionInput<Integer> inputRequest = TC_002_Data.inputRequestPayload();
		req = given().spec(givenHeader()).body(inputRequest);
		primaryServiceIdentifier = inputRequest.getSubscription().getServiceIdentifier();
	}
	
	@Given("Input Provision Request with invalid dataType")
	public void input_provision_request_with_invalid_dataType() throws IOException {
		provisionInput<String> inputRequest = TC_003_Data.inputRequestPayload();
		req = given().spec(givenHeader()).body(inputRequest);
	}
	
	@Given("Input Request with missing serviceIdentifier")
	public void input_request_with_missing_service_identifier() throws IOException {
		provisionInput<Integer> inputRequest = TC_004_Data.inputRequestPayload();
		req = given().spec(givenHeader()).body(inputRequest);
	}

	@Given("Input Request with missingIMSI")
	public void input_request_with_missing_imsi() throws IOException {
		provisionInput<Integer> inputRequest = TC_005_Data.inputRequestPayload();
		req = given().spec(givenHeader()).body(inputRequest);
	}

	@Given("Input Request with missingSubscriptionMode")
	public void input_request_with_missing_subscription_mode() throws IOException {
		provisionInput<Integer> inputRequest = TC_006_Data.inputRequestPayload();
		req = given().spec(givenHeader()).body(inputRequest);
	}

	@Given("Input Request with Service Identifier Greater Length")
	public void input_request_with_service_identifier_greater_length() throws IOException {
		provisionInput<Integer> inputRequest = TC_007_Data.inputRequestPayload();
		req = given().spec(givenHeader()).body(inputRequest);
	}

	@Given("Input Request with IMSI Greater Length")
	public void input_request_with_imsi_greater_length() throws IOException {
		provisionInput<Integer> inputRequest = TC_008_Data.inputRequestPayload();
		req = given().spec(givenHeader()).body(inputRequest);
	}
	
	@Given("^Input Request with missing customerType attribute$")
	public void input_request_with_missing_customertype_attribute() throws IOException {
		provisionInput<Integer> inputRequest = TC_009_Data.inputRequestPayload();
		req = given().spec(givenHeader()).body(inputRequest);
	}
	
	@Given("^Input Request with M2M customerType$")
	public void input_request_with_m2m_customertype() throws IOException {
		provisionInput<Integer> inputRequest = TC_010_Data.inputRequestPayload();
		req = given().spec(givenHeader()).body(inputRequest);
	}
	
	@Given("^Input Request with missing bdom attribute$")
	public void input_request_with_missing_bdom_attribute() throws IOException {
		provisionInput<Integer> inputRequest = TC_011_Data.inputRequestPayload();
		req = given().spec(givenHeader()).body(inputRequest);
	}

	@Given("^Input Request with missing billingFrequency attribute$")
	public void input_request_with_missing_billingfrequency_attribute() throws IOException {
		provisionInput<Integer> inputRequest = TC_012_Data.inputRequestPayload();
		req = given().spec(givenHeader()).body(inputRequest);
	}
	
	@Given("Input Request with invalid bdom")
	public void input_request_with_invalid_bdom() throws IOException {
		provisionInput<Integer> inputRequest = TC_013_Data.inputRequestPayload();
		req = given().spec(givenHeader()).body(inputRequest);
	}

	@Given("Input Request with invalid emailAddress")
	public void input_request_with_invalid_email_address() throws IOException {
		provisionInput<Integer> inputRequest = TC_014_Data.inputRequestPayload();
		req = given().spec(givenHeader()).body(inputRequest);
	}

	@Given("Input Request with missing language attribute")
	public void input_request_with_missing_language_attribute() throws IOException {
		provisionInput<Integer> inputRequest = TC_015_Data.inputRequestPayload();;
		req = given().spec(givenHeader()).body(inputRequest);
	}

	@Given("Input Request with missing serviceProvideID attribute")
	public void input_request_with_missing_service_provide_id_attribute() throws IOException {
		provisionInput<Integer> inputRequest = TC_016_Data.inputRequestPayload();
		req = given().spec(givenHeader()).body(inputRequest);
	}

	@Given("Input Request with missing subscriptionType attribute")
	public void input_request_with_missing_subscription_type_attribute() throws IOException {
		provisionInput<Integer> inputRequest = TC_017_Data.inputRequestPayload();
		req = given().spec(givenHeader()).body(inputRequest);
	}

	@Given("^Input Request with missing domesticNotifyEnabled attribute$")
	public void input_request_with_missing_domesticnotifyenabled_attribute() throws IOException {
		provisionInput<Integer> inputRequest = TC_018_Data.inputRequestPayload();
		req = given().spec(givenHeader()).body(inputRequest);
	}

	@Given("^Input Request with missing roamingNotifyEnabled attribute$")
	public void input_request_with_missing_roamingnotifyenabled_attribute() throws IOException {
		provisionInput<Integer> inputRequest = TC_019_Data.inputRequestPayload();
		req = given().spec(givenHeader()).body(inputRequest);
	}
	
	@Given("^Input Request with missing RCCNotifyEnabled attribute$")
	public void input_request_with_missing_rccnotifyenabled_attribute() throws IOException {
		provisionInput<Integer> inputRequest = TC_020_Data.inputRequestPayload();
		req = given().spec(givenHeader()).body(inputRequest);
	}
	
	@Given("^Input Request with missing baringTopupPurchase attribute$")
	public void input_request_with_missing_baringTopupPurchase_attribute() throws IOException {
		provisionInput<Integer> inputRequest = TC_021_Data.inputRequestPayload();
		req = given().spec(givenHeader()).body(inputRequest);
	}

	@Given("Input Request with invalid customerType")
	public void input_request_with_invalid_customer_type() throws IOException {
		provisionInput<Integer> inputRequest = TC_022_Data.inputRequestPayload();
		req = given().spec(givenHeader()).body(inputRequest);
	}
	
	@Given("Input Request with existing serviceIdentifier")
	public void input_request_with_existing_service_identifier() throws IOException {
		provisionInput<Integer> inputRequest = TC_023_Data.inputRequestPayload(primaryServiceIdentifier);
		req = given().spec(givenHeader()).body(inputRequest);
	}

	@Given("Input Request with existing IMSI")
	public void input_request_with_existing_imsi() throws IOException {
		provisionInput<Integer> inputRequest = TC_024_Data.inputRequestPayload(imsi);
		req = given().spec(givenHeader()).body(inputRequest);
	}

	@Given("Input Request with invalid subscriptionMode")
	public void input_request_with_invalid_subscription_mode() throws IOException {
		provisionInput<Integer> inputRequest = TC_025_Data.inputRequestPayload();
		req = given().spec(givenHeader()).body(inputRequest);
	}
	
	@Given("Service Enrichment")
	public void service_enrichment() throws IOException {
		System.out.println("Validate Service Enrichment in the Server");
	}
	
	@When("{string} API is called")
	public void api_is_called(String resource) {

		switch (resource) {
		case "Provision":
			output = req.when().post(getAPI("Provision")).then().spec(postResponse()).extract().response();
			break;
		}
	}
	
	@When("{string} API is called with invalidDataType")
	public void api_is_called_with_invalidDataType(String resource) {

		switch (resource) {
		case "Provision":
			output = req.when().post(getAPI("Provision")).then().spec(failureResponse()).extract().response();
			break;
		}
	}
	
	@When("{string} API is called with missing attributes")
	public void api_is_called_with_missing_attributes(String resource) {
		switch (resource) {
		case "Provision":
			output = req.when().post(getAPI("Provision")).then().spec(failureResponse()).extract().response();
			break;
		}
	}

	@When("{string} API is called with invalid values")
	public void api_is_called_with_invalid_values(String resource) {
		switch (resource) {
		case "Provision":
			output = req.when().post(getAPI("Provision")).then().spec(failureResponse()).extract().response();
			break;
		}
	}
	
	@When("{string} API is called with existing values")
	public void api_is_called_with_existing_values(String resource) {
		switch (resource) {
		case "Provision":
			output = req.when().post(getAPI("Provision")).then().spec(existingResponse()).extract().response();
			break;
		}
	}

	
	@Then("Validate the {string} code and status in {string} output response")
	public void validate_the_code_and_status_in_output_response(String code, String api) {
		switch (api) {
		case "Provision":
			provisionOutput responseBody = output.getBody().as(provisionOutput.class);
			System.out.println(responseBody.getMessage());
			assertEquals(responseBody.getCode(), code);
			assertEquals(responseBody.getStatus(), getResponseStatus("post"));
			break;
		}
	}
	
	@Then("Validate the {string} code , invalid status and message in output response")
	public void validate_the_code_invalid_status_and_message_in_output_response(String code) {
		provisionOutput responseBody = output.getBody().as(provisionOutput.class);
		assertEquals(responseBody.getCode(), code);
		System.out.println(responseBody.getMessage());
		assertEquals(responseBody.getStatus(), getResponseStatus("failure"));
	}
	
	@Then("Validate the {string} code , status, message and error message in output response")
	public void validate_the_code_status_message_and_error_message_in_output_response(String code) {
		provisionOutput responseBody = output.getBody().as(provisionOutput.class);
		assertEquals(responseBody.getCode(), code);
		System.out.println(responseBody.getMessage());
		System.out.println(responseBody.getErrors().get(0).getMessage());
		assertEquals(responseBody.getStatus(), getResponseStatus("failure"));
	}
	
	@Then("Validate the {string} code , status and message in output response")
	public void validate_the_code_status_and_message_in_output_response(String code) {
		provisionOutput responseBody = output.getBody().as(provisionOutput.class);
		assertEquals(responseBody.getCode(), code);
		System.out.println(responseBody.getMessage());
		assertEquals(responseBody.getStatus(), getResponseStatus("existing"));
	}

	
}
