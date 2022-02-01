package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import addBundle.addBundleRequest;
import addRCCBundle.addRCCBundleRequest;
import addRCCBundle.addRCCBundleResponse;
import addSubscription.addSubscriptionRequest;
import changeServiceIdentifier.changeServiceIdentifierRequest;
import changeServiceIdentifier.changeServiceIdentifierResponse;
import getBundles.getBundlesResponse;
import getBundles.getResponse;
import addRCCBundle.notFoundResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import provision.provisionRequest;
import provision.provisionResponse;
import requestPayloads.*;

public class stepDefinition extends ReUsableMethods {

	RequestSpecification req;
	Response output;
	ResponseBody<Response> response;
	static String primaryServiceIdentifier;
	static String secondaryServiceIdentifier;
	static String imsi;
	static String alternateNumber;
	static String getIdentifier;
	static String supi;
	static String accessToken;

	@Given("Input Provision Request for {string} with {string} attributes")
	public void input_provision_request_for_with_attributes(String CRM, String string) throws IOException {
		provisionRequest<Integer> inputRequest = null;
		if (CRM.contentEquals("teliano")) {
			inputRequest = Provision_Data.inputRequestPayload("TC001");
			if (string.contentEquals("noOptional")) {
				inputRequest = Provision_Data.inputRequestPayload("TC002");
			}
		} else {
			inputRequest = Provision_Data.inputRequestPayload("TC035");
		}
		req = given().spec(givenHeader()).body(inputRequest);
		primaryServiceIdentifier = inputRequest.getSubscription().getServiceIdentifier();
		imsi = inputRequest.getSubscription().getImsi();
		alternateNumber = inputRequest.getSubscription().getServiceInfo().getPreferences().getAlternateNumber();
	}

	@Given("Input Provision Request with invalid {string}")
	public void input_provision_request_with_invalid_dataType(String string) throws IOException {
		if (string.contentEquals("dataType")) {
			provisionRequest<String> inputRequest = Provision_Data.inputRequestPayload();
			req = given().spec(givenHeader()).body(inputRequest);
		} else if (string.contentEquals("bundle")) {
			provisionRequest<Integer> inputRequest = Provision_Data.inputRequestPayload("TC033");
			req = given().spec(givenHeader()).body(inputRequest);
		}
	}

	@Given("Input Request with missing mandatory {string}")
	public void input_request_with_missing_mandatory(String string) throws IOException {
		provisionRequest<Integer> inputRequest = null;
		if (string.contentEquals("serviceIdentifier")) {
			inputRequest = Provision_Data.inputRequestPayload("TC004");
		} else if (string.contentEquals("IMSI")) {
			inputRequest = Provision_Data.inputRequestPayload("TC005");
		} else if (string.contentEquals("subscriptionMode")) {
			inputRequest = Provision_Data.inputRequestPayload("TC006");
		} else if (string.contentEquals("customerType")) {
			inputRequest = Provision_Data.inputRequestPayload("TC009");
		} else if (string.contentEquals("bdom")) {
			inputRequest = Provision_Data.inputRequestPayload("TC011");
		} else if (string.contentEquals("billingFrequency")) {
			inputRequest = Provision_Data.inputRequestPayload("TC012");
		} else if (string.contentEquals("language")) {
			inputRequest = Provision_Data.inputRequestPayload("TC015");
		} else if (string.contentEquals("serviceProviderID")) {
			inputRequest = Provision_Data.inputRequestPayload("TC016");
		} else if (string.contentEquals("subscriptionType")) {
			inputRequest = Provision_Data.inputRequestPayload("TC017");
		}
		req = given().spec(givenHeader()).body(inputRequest);
	}

	@Given("Input Request with {string} Greater Length")
	public void input_request_with_greater_length(String string) throws IOException {
		provisionRequest<Integer> inputRequest = null;
		if (string.contentEquals("serviceIdentifier")) {
			inputRequest = Provision_Data.inputRequestPayload("TC007");
		} else if (string.contentEquals("IMSI")) {
			inputRequest = Provision_Data.inputRequestPayload("TC008");
		}
		req = given().spec(givenHeader()).body(inputRequest);
	}

	@Given("Input Request with invalid {string}")
	public void input_request_with_invalid(String string) throws IOException {
		provisionRequest<Integer> inputRequest = null;
		if (string.contentEquals("M2MCustomerType")) {
			inputRequest = Provision_Data.inputRequestPayload("TC010");
		} else if (string.contentEquals("bdom")) {
			inputRequest = Provision_Data.inputRequestPayload("TC013");
		} else if (string.contentEquals("emailAddress")) {
			inputRequest = Provision_Data.inputRequestPayload("TC014");
		} else if (string.contentEquals("customerType")) {
			inputRequest = Provision_Data.inputRequestPayload("TC022");
		} else if (string.contentEquals("subscriptionMode")) {
			inputRequest = Provision_Data.inputRequestPayload("TC025");
		}
		req = given().spec(givenHeader()).body(inputRequest);
	}

	@Given("Input Request with missing optional {string}")
	public void input_request_with_missing_optional(String string) throws IOException {
		provisionRequest<Integer> inputRequest = null;
		if (string.contentEquals("domesticNotifyEnabled")) {
			inputRequest = Provision_Data.inputRequestPayload("TC018");
		} else if (string.contentEquals("rccNotifyEnabled")) {
			inputRequest = Provision_Data.inputRequestPayload("TC019");
		} else if (string.contentEquals("roamingNotifyEnabled")) {
			inputRequest = Provision_Data.inputRequestPayload("TC020");
		} else if (string.contentEquals("barringTopupPurchase")) {
			inputRequest = Provision_Data.inputRequestPayload("TC021");
		}

		req = given().spec(givenHeader()).body(inputRequest);
	}

	@Given("Input Request with existing {string}")
	public void input_request_with_existing(String string) throws IOException {
		provisionRequest<Integer> inputRequest = null;
		if (string.contentEquals("serviceIdentifier")) {
			inputRequest = Provision_Data.inputRequestPayload("TC023", primaryServiceIdentifier);
		} else if (string.contentEquals("IMSI")) {
			inputRequest = Provision_Data.inputRequestPayload("TC024", primaryServiceIdentifier);
		}
		req = given().spec(givenHeader()).body(inputRequest);
	}

	@Given("Input Provision Request with only {string} bundle")
	public void input_provision_request_with_only_bundle(String string) throws IOException {
		provisionRequest<Integer> inputRequest = null;
		if (string.contentEquals("Base"))
			inputRequest = Provision_Data.inputRequestPayload("TC027");
		else if (string.contentEquals("Roaming"))
			inputRequest = Provision_Data.inputRequestPayload("TC028");
		else if (string.contentEquals("RCC"))
			inputRequest = Provision_Data.inputRequestPayload("TC029");
		else if (string.contentEquals("baseRoaming"))
			inputRequest = Provision_Data.inputRequestPayload("TC239");
		else if (string.contentEquals("baseRcc"))
			inputRequest = Provision_Data.inputRequestPayload("TC240");
		req = given().spec(givenHeader()).body(inputRequest);
		primaryServiceIdentifier = inputRequest.getSubscription().getServiceIdentifier();
		imsi = inputRequest.getSubscription().getImsi();
	}

	@Given("Input Provision Request {string} bundle group")
	public void input_provision_request_bundle_group(String string) throws IOException {
		provisionRequest<Integer> inputRequest = null;
		if (string.contentEquals("with")) {
			inputRequest = Provision_Data.inputRequestPayload("TC030");
		} else if (string.contentEquals("without")) {
			inputRequest = Provision_Data.inputRequestPayload("TC031");
		}
		req = given().spec(givenHeader()).body(inputRequest);
		primaryServiceIdentifier = inputRequest.getSubscription().getServiceIdentifier();
		imsi = inputRequest.getSubscription().getImsi();
	}

	@Given("Input Provision Request for {string} with {string} BDOM")
	public void input_provision_request_with_valid_bdom(String string1, String string2) throws IOException {
		provisionRequest<Integer> inputRequest = null;
		if (string1.contentEquals("teliano")) {
			inputRequest = Provision_Data.inputRequestPayload("TC036");
			if (string2.contentEquals("Invalid")) {
				inputRequest = Provision_Data.inputRequestPayload("TC037");
			}
		} else {
			inputRequest = Provision_Data.inputRequestPayload("TC042");
			if (string2.contentEquals("Invalid")) {
				inputRequest = Provision_Data.inputRequestPayload("TC043");
			}
		}
		req = given().spec(givenHeader()).body(inputRequest);
		primaryServiceIdentifier = inputRequest.getSubscription().getServiceIdentifier();
		imsi = inputRequest.getSubscription().getImsi();
	}

	@Given("Input Provision Request {string} notificationPrice for Phonero")
	public void input_provision_request_notificationprice_for_phonero(String string) throws IOException {
		provisionRequest<Integer> inputRequest = null;
		if (string.contentEquals("with")) {
			inputRequest = Provision_Data.inputRequestPayload("TC038");
		} else if (string.contentEquals("without")) {
			inputRequest = Provision_Data.inputRequestPayload("TC039");
		}
		req = given().spec(givenHeader()).body(inputRequest);
		primaryServiceIdentifier = inputRequest.getSubscription().getServiceIdentifier();
		imsi = inputRequest.getSubscription().getImsi();
	}

	@Given("Input Provision Request with channel as {string}")
	public void input_provision_request_with_channel_as(String string) throws IOException {
		provisionRequest<Integer> inputRequest = null;
		if (string.contentEquals("SMS")) {
			inputRequest = Provision_Data.inputRequestPayload("TC040");
		} else if (string.contentEquals("Email")) {
			inputRequest = Provision_Data.inputRequestPayload("TC041");
		}
		req = given().spec(givenHeader()).body(inputRequest);
		primaryServiceIdentifier = inputRequest.getSubscription().getServiceIdentifier();
		imsi = inputRequest.getSubscription().getImsi();
	}

	@Given("Input Provision Request with billingFrequency as {string}")
	public void input_provision_request_with_billing_frequency_as(String string) throws IOException {
		provisionRequest<Integer> inputRequest = null;
		if (string.contentEquals("Monthly")) {
			inputRequest = Provision_Data.inputRequestPayload("TC044");
		} else if (string.contentEquals("Quarterly")) {
			inputRequest = Provision_Data.inputRequestPayload("TC045");
		}
		req = given().spec(givenHeader()).body(inputRequest);
		primaryServiceIdentifier = inputRequest.getSubscription().getServiceIdentifier();
		imsi = inputRequest.getSubscription().getImsi();
	}

	@Given("Input Provision Request without channel and {string}")
	public void input_provision_request_without_channel_and(String string) throws IOException {
		provisionRequest<Integer> inputRequest = null;
		if (string.contentEquals("emailAddress")) {
			inputRequest = Provision_Data.inputRequestPayload("TC046");
		} else if (string.contentEquals("alternateNumber")) {
			inputRequest = Provision_Data.inputRequestPayload("TC047");
		}
		req = given().spec(givenHeader()).body(inputRequest);
		primaryServiceIdentifier = inputRequest.getSubscription().getServiceIdentifier();
		imsi = inputRequest.getSubscription().getImsi();
	}

	@Given("Input Provision Request without IMSI and {string}")
	public void input_provision_request_without_imsi_and(String string) throws IOException {
		provisionRequest<Integer> inputRequest = null;
		if (string.contentEquals("optional fields")) {
			inputRequest = Provision_Data.inputRequestPayload("TC032");
		} else if (string.contentEquals("bdom")) {
			inputRequest = Provision_Data.inputRequestPayload("TC048");
		} else if (string.contentEquals("billingFrequency")) {
			inputRequest = Provision_Data.inputRequestPayload("TC049");
		} else if (string.contentEquals("language")) {
			inputRequest = Provision_Data.inputRequestPayload("TC050");
		}
		req = given().spec(givenHeader()).body(inputRequest);
		primaryServiceIdentifier = inputRequest.getSubscription().getServiceIdentifier();
		imsi = inputRequest.getSubscription().getImsi();
	}

	@Given("Input AddSubscription Request with {string} attributes")
	public void input_addsubscription_request_with_attributes(String string) throws IOException {
		addSubscriptionRequest inputRequest = AddSubscription_Data.inputRequestPayload("TC055",
				primaryServiceIdentifier);
		if (string.contentEquals("Invalid"))
			inputRequest = AddSubscription_Data.inputRequestPayload("TC056", "000000000");
		else if (string.contentEquals("onlyMandatory"))
			inputRequest = AddSubscription_Data.inputRequestPayload("TC057", primaryServiceIdentifier);
		else if (string.contentEquals("Duplicate"))
			inputRequest = AddSubscription_Data.inputRequestPayload("TC058", secondaryServiceIdentifier, imsi);
		else if (string.contentEquals("Inactive"))
			inputRequest = AddSubscription_Data.inputRequestPayload("TC059", primaryServiceIdentifier);
		else if (string.contentEquals("Unique"))
			inputRequest = AddSubscription_Data.inputRequestPayload("TC061", secondaryServiceIdentifier);
		req = given().spec(givenHeader()).body(inputRequest);
		primaryServiceIdentifier = inputRequest.getServiceIdentifier();
		secondaryServiceIdentifier = inputRequest.getPrimaryServiceIdentifier();
		imsi = inputRequest.getImsi();
	}

	@Given("Input AddRCCBundle Request with {string} bundleCode")
	public void input_addrccbundle_request_with_bundlecode(String validBundle) throws IOException {
		addRCCBundleRequest inputRequest = null;
		switch (validBundle) {
		case "RCC":
			inputRequest = AddRCCBundle_Data.inputRequestPayload("TC066", validBundle);
			break;
		case "Invalid":
			inputRequest = AddRCCBundle_Data.inputRequestPayload("TC069", validBundle);
			break;
		case "Roaming":
			inputRequest = AddRCCBundle_Data.inputRequestPayload("TC070", validBundle);
			break;
		case "no":
			inputRequest = AddRCCBundle_Data.inputRequestPayload("TC076", validBundle);
			break;
		}
		req = given().spec(givenHeader()).body(inputRequest);
	}

	@Given("Input Delete Request")
	public void input_delete_request() throws IOException {
		req = given().spec(onlyHeader());
	}

	@Given("Input Get Request")
	public void input_get_request() throws IOException {
		req = given().spec(getHeader());
	}

	@Given("Input Request with {string} Service Identifiers")
	public void input_request_with_service_identifiers(String validity) throws IOException {
		changeServiceIdentifierRequest inputRequest = null;
		if (validity.contentEquals("Valid"))
			inputRequest = ChangeServiceIdentifier_Data.inputRequestPayload(" ");
		else if (validity.contentEquals("Blank"))
			inputRequest = ChangeServiceIdentifier_Data.inputRequestPayload("TC208");
		else if (validity.contentEquals("Invalid"))
			inputRequest = ChangeServiceIdentifier_Data.inputRequestPayload("TC202");
		else if (validity.contentEquals("Existing"))
			inputRequest = ChangeServiceIdentifier_Data.inputRequestPayload("TC203", primaryServiceIdentifier);
		else if (validity.contentEquals("Missing"))
			inputRequest = ChangeServiceIdentifier_Data.inputRequestPayload("TC205");
		req = given().spec(givenHeader()).body(inputRequest);
		getIdentifier = inputRequest.getNewServiceIdentifier();
	}

	@Given("Input Request with {string} bundle {string} properties")
	public void input_request_with_bundle(String bundleType, String rule) throws IOException {
		addBundleRequest inputRequest = null;
		if (bundleType.contentEquals("Base"))
			inputRequest = AddBundle_Data.inputRequestPayload("TC214", rule);
		else if (bundleType.contentEquals("Roaming"))
			inputRequest = AddBundle_Data.inputRequestPayload("TC216", rule);
		else if (bundleType.contentEquals("AddOn"))
			inputRequest = AddBundle_Data.inputRequestPayload("TC217", rule);
		else if (bundleType.contentEquals("RCC"))
			inputRequest = AddBundle_Data.inputRequestPayload("TC226", rule);
		else if (bundleType.contentEquals("TopUp"))
			inputRequest = AddBundle_Data.inputRequestPayload("TC227", rule);
		else if (bundleType.contentEquals("Invalid"))
			inputRequest = AddBundle_Data.inputRequestPayload("TC228", rule);
		else
			inputRequest = AddBundle_Data.inputRequestPayload("TC229", rule);
		req = given().spec(givenHeader()).body(inputRequest);
	}

	@When("{string} API is called with {string} attributes")
	public void api_is_called_with_attributes(String resource, String Validity) {
		switch (resource) {
		case "Provision":
			if (Validity.contentEquals("Valid"))
				output = req.when().post(getAPI("Provision")).then().spec(postResponse()).extract().response();
			else if (Validity.contentEquals("Invalid") || Validity.contentEquals("Missing"))
				output = req.when().post(getAPI("Provision")).then().spec(failureResponse()).extract().response();
			else if (Validity.contentEquals("Existing"))
				output = req.when().post(getAPI("Provision")).then().spec(existingResponse()).extract().response();
			else
				output = req.when().post(getAPI("Provision")).then().spec(serverResponse()).extract().response();
			break;
		case "AddSubscription":
			if (Validity.contentEquals("Valid"))
				output = req.when().post(getAPI("Subscription")).then().spec(postResponse()).extract().response();
			else if (Validity.contentEquals("Invalid"))
				output = req.when().post(getAPI("Subscription")).then().spec(failureResponse()).extract().response();
			else if (Validity.contentEquals("Non-existant") || Validity.contentEquals("Existing")
					|| Validity.contentEquals("Inactive"))
				output = req.when().post(getAPI("Subscription")).then().spec(existingResponse()).extract().response();
			break;
		case "AddRCCBundle":
			if (Validity.contentEquals("Valid"))
				output = req.when().post(getAPI("Subscription") + primaryServiceIdentifier + getAPI("RCCBundle")).then()
						.spec(postResponse()).extract().response();
			else if (Validity.contentEquals("Invalid"))
				output = req.when().post(getAPI("Subscription") + primaryServiceIdentifier + getAPI("RCCBundle")).then()
						.spec(failureResponse()).extract().response();
			else if (Validity.contentEquals("Missing"))
				output = req.when().post(getAPI("Subscription") + getAPI("RCCBundle")).then().spec(notFoundResponse())
						.extract().response();
			else if (Validity.contentEquals("Inactive") || Validity.contentEquals("Existant"))
				output = req.when().post(getAPI("Subscription") + primaryServiceIdentifier + getAPI("RCCBundle")).then()
						.spec(existingResponse()).extract().response();
			else if (Validity.contentEquals("Non-existant"))
				output = req.when().post(getAPI("Subscription") + "000" + getAPI("RCCBundle")).then()
						.spec(existingResponse()).extract().response();
			break;
		case "DeleteSubscription":
			if (Validity.contentEquals("Valid"))
				output = req.when().delete(getAPI("Subscription") + primaryServiceIdentifier).then()
						.spec(deleteResponse()).extract().response();
			else if (Validity.contentEquals("no"))
				output = req.when().delete(getAPI("Subscription")).then().spec(notFoundResponse()).extract().response();
			else if (Validity.contentEquals("Inactive") || Validity.contentEquals("Non-Existant"))
				output = req.when().delete(getAPI("Subscription") + primaryServiceIdentifier).then()
						.spec(existingResponse()).extract().response();
			break;
		case "DeletePrimarySubscription":
			if (Validity.contentEquals("Valid"))
				output = req.when().delete(getAPI("Subscription") + secondaryServiceIdentifier).then()
						.spec(deleteResponse()).extract().response();
			break;
		case "ChangeServiceIdentifier":
			if (Validity.contentEquals("Valid"))
				output = req.when()
						.post(getAPI("Subscription") + primaryServiceIdentifier + getAPI("ServiceIdentifier")).then()
						.spec(postResponse()).extract().response();
			else if (Validity.contentEquals("Invalid"))
				output = req.when()
						.post(getAPI("Subscription") + primaryServiceIdentifier + getAPI("ServiceIdentifier")).then()
						.spec(failureResponse()).extract().response();
			else if (Validity.contentEquals("Non-existant"))
				output = req.when().post(getAPI("Subscription") + "000" + getAPI("ServiceIdentifier")).then()
						.spec(existingResponse()).extract().response();
			else if (Validity.contentEquals("Missing"))
				output = req.when().post(getAPI("Subscription") + getAPI("ServiceIdentifier")).then()
						.spec(notFoundResponse()).extract().response();
			else if (Validity.contentEquals("Existing") || Validity.contentEquals("Inactive"))
				output = req.when()
						.post(getAPI("Subscription") + primaryServiceIdentifier + getAPI("ServiceIdentifier")).then()
						.spec(existingResponse()).extract().response();
			break;
		case "AddBundle":
			if (Validity.contentEquals("Valid"))
				output = req.when().post(getAPI("Subscription") + primaryServiceIdentifier + getAPI("Bundle")).then()
						.spec(postResponse()).extract().response();
			else if (Validity.contentEquals("Invalid"))
				output = req.when().post(getAPI("Subscription") + primaryServiceIdentifier + getAPI("Bundle")).then()
						.spec(failureResponse()).extract().response();
			else if (Validity.contentEquals("Server"))
				output = req.when().post(getAPI("Subscription") + primaryServiceIdentifier + getAPI("Bundle")).then()
						.spec(serverResponse()).extract().response();
			else if (Validity.contentEquals("Missing"))
				output = req.when().post(getAPI("Subscription") + getAPI("Bundle")).then().spec(notFoundResponse())
						.extract().response();
			else if (Validity.contentEquals("Inactive") || Validity.contentEquals("Existing"))
				output = req.when().post(getAPI("Subscription") + primaryServiceIdentifier + getAPI("Bundle")).then()
						.spec(existingResponse()).extract().response();
			else if (Validity.contentEquals("Non-existant"))
				output = req.when().post(getAPI("Subscription") + "000" + getAPI("Bundle")).then()
						.spec(existingResponse()).extract().response();

			break;
		case "GetBundles":
			if (Validity.contentEquals("Valid"))
				output = req.when().get(getAPI("Subscription") + primaryServiceIdentifier + getAPI("Bundle")).then()
						.spec(successResponse()).extract().response();
			else if (Validity.contentEquals("Server"))
				output = req.when().get(getAPI("Subscription") + primaryServiceIdentifier + getAPI("Bundle")).then()
						.spec(serverResponse()).extract().response();
			else if (Validity.contentEquals("Inactive"))
				output = req.when().get(getAPI("Subscription") + primaryServiceIdentifier + getAPI("Bundle")).then()
						.spec(existingResponse()).extract().response();
			else if (Validity.contentEquals("Invalid"))
				output = req.when().get(getAPI("Subscription") + "0000" + getAPI("Bundle")).then()
						.spec(existingResponse()).extract().response();
			else if (Validity.contentEquals("Missing"))
				output = req.when().get(getAPI("Subscription") + getAPI("Bundle")).then().spec(notFoundResponse())
						.extract().response();
			break;
		case "DeleteBundle":
			if (Validity.contentEquals("Valid Roaming"))
				output = req.when()
						.delete(getAPI("Subscription") + primaryServiceIdentifier + getAPI("Bundle")
								+ testData.TestData.roamingBundleCode)
						.then().spec(deleteResponse()).extract().response();
			else if (Validity.contentEquals("AddOn"))
				output = req.when().delete(getAPI("Subscription") + primaryServiceIdentifier + getAPI("Bundle")
						+ testData.TestData.addOnBundleCode).then().spec(bundleResponse()).extract().response();
			else if (Validity.contentEquals("Base"))
				output = req.when().delete(getAPI("Subscription") + primaryServiceIdentifier + getAPI("Bundle")
						+ testData.TestData.bundleCode).then().spec(bundleResponse()).extract().response();
			else if (Validity.contentEquals("RCC"))
				output = req.when().delete(getAPI("Subscription") + primaryServiceIdentifier + getAPI("Bundle")
						+ testData.TestData.RCCBundleCode).then().spec(bundleResponse()).extract().response();
			else if (Validity.contentEquals("Conflict"))
				output = req.when().delete(getAPI("Subscription") + primaryServiceIdentifier + getAPI("Bundle")
						+ testData.TestData.RCCBundleCode).then().spec(existingResponse()).extract().response();
			else if (Validity.contentEquals("Invalid"))
				output = req.when().delete(getAPI("Subscription") + primaryServiceIdentifier + getAPI("Bundle") + "ABC")
						.then().spec(failureResponse()).extract().response();
			else if (Validity.contentEquals("Inactive"))
				output = req.when()
						.delete(getAPI("Subscription") + primaryServiceIdentifier + getAPI("Bundle")
								+ testData.TestData.roamingBundleCode)
						.then().spec(existingResponse()).extract().response();
			else if (Validity.contentEquals("Missing Bundle"))
				output = req.when().delete(getAPI("Subscription") + primaryServiceIdentifier + getAPI("Bundle")).then()
						.spec(notFoundResponse()).extract().response();
			else if (Validity.contentEquals("Missing serviceIdentifier"))
				output = req.when().delete(getAPI("Subscription") + "bundles/" + testData.TestData.roamingBundleCode)
						.then().spec(notFoundResponse()).extract().response();
			else if (Validity.contentEquals("Non-existant"))
				output = req.when()
						.delete(getAPI("Subscription") + "000" + getAPI("Bundle") + testData.TestData.roamingBundleCode)
						.then().spec(existingResponse()).extract().response();
			break;
		case "GetSubscription":
			if (Validity.contentEquals("Valid"))
				output = req.when().get(getAPI("Subscription") + primaryServiceIdentifier).then()
						.spec(successResponse()).extract().response();
			break;
		}
	}

	@Then("Validate the {string} code, status and message in {string} output response")
	public void validate_the_code_status_and_message_in_output_response(String code, String api) {
		switch (api) {
		case "Provision":
		case "AddSubscription":
		case "DeleteSubscription":
		case "DeleteBundle":
			provisionResponse responseBody = output.getBody().as(provisionResponse.class);
			System.out.println(responseBody.getMessage());
			assertEquals(responseBody.getCode(), code);
			if (code.contentEquals("000"))
				assertEquals(responseBody.getStatus(), getResponseStatus("post"));
			else if (code.contentEquals("ERR1001"))
				assertEquals(responseBody.getStatus(), getResponseStatus("failure"));
			else if (code.contains("ERR3"))
				assertEquals(responseBody.getStatus(), getResponseStatus("existing"));
			else if (code.contains("ERR2"))
				assertEquals(responseBody.getStatus(), getResponseStatus("server"));
			if (responseBody.getErrors() != null) {
				if (!responseBody.getErrors().isEmpty()) {
					System.out.println(responseBody.getErrors().get(0).getMessage());
				}
			}
			break;
		case "AddRCCBundle":
		case "AddBundle":
			addRCCBundleResponse responseBody1 = output.getBody().as(addRCCBundleResponse.class);
			System.out.println(responseBody1.getMessage());
			assertEquals(responseBody1.getCode(), code);
			if (code.contentEquals("000"))
				assertEquals(responseBody1.getStatus(), getResponseStatus("post"));
			else if (code.contentEquals("ERR1001"))
				assertEquals(responseBody1.getStatus(), getResponseStatus("failure"));
			else if (code.contains("ERR3"))
				assertEquals(responseBody1.getStatus(), getResponseStatus("existing"));
			else if (code.contains("ERR2"))
				assertEquals(responseBody1.getStatus(), getResponseStatus("server"));
			if (responseBody1.getErrors() != null) {
				if (!responseBody1.getErrors().isEmpty()) {
					System.out.println(responseBody1.getErrors().get(0).getMessage());
				}
			}
			break;
		case "ChangeServiceIdentifier":
			changeServiceIdentifierResponse responseBody2 = output.getBody().as(changeServiceIdentifierResponse.class);
			System.out.println(responseBody2.getMessage());
			assertEquals(responseBody2.getCode(), code);
			if (code.contentEquals("000"))
				assertEquals(responseBody2.getStatus(), getResponseStatus("post"));
			else if (code.contentEquals("ERR1001"))
				assertEquals(responseBody2.getStatus(), getResponseStatus("failure"));
			else if (code.contains("ERR3"))
				assertEquals(responseBody2.getStatus(), getResponseStatus("existing"));
			if (responseBody2.getErrors() != null) {
				if (!responseBody2.getErrors().isEmpty()) {
					System.out.println(responseBody2.getErrors().get(0).getMessage());
				}
			}
			break;
		case "GetBundles":
			getResponse responseBody3 = output.getBody().as(getResponse.class);
			System.out.println(responseBody3.getMessage());
			assertEquals(responseBody3.getCode(), code);
			if (code.contentEquals("ERR1001"))
				assertEquals(responseBody3.getStatus(), getResponseStatus("failure"));
			else if (code.contains("ERR3"))
				assertEquals(responseBody3.getStatus(), getResponseStatus("existing"));
			else if (code.contains("ERR2"))
				assertEquals(responseBody3.getStatus(), getResponseStatus("server"));
			if (responseBody3.getErrors() != null) {
				if (!responseBody3.getErrors().isEmpty()) {
					System.out.println(responseBody3.getErrors().get(0).getMessage());
				}
			}
			break;
		}
	}

	@Then("Validate the {string} output response")
	public void validate_the_output_response(String api) {
		switch (api) {
		case "GetBundles":
			getBundlesResponse responseBody1 = output.getBody().as(getBundlesResponse.class);
			if (!responseBody1.getBaseBundle().isEmpty()) {
				int length = responseBody1.getBaseBundle().size();
				for (int i = 0; i < length; i++) {
					assertEquals("Active", responseBody1.getBaseBundle().get(i).getStatus());
					assertEquals(testData.TestData.on, responseBody1.getBaseBundle().get(i).getNotifications());
					if (responseBody1.getBaseBundle().get(i).getBundleType().contentEquals("Base")) {
						assertEquals(testData.TestData.bundleCode,
								responseBody1.getBaseBundle().get(i).getBundleCode());
					} else {
						assertEquals("Addon", responseBody1.getBaseBundle().get(i).getBundleType());
						assertEquals(testData.TestData.addOnBundleCode,
								responseBody1.getBaseBundle().get(i).getBundleCode());
					}
				}
			}
			if (!responseBody1.getRoamingBundle().isEmpty()) {
				assertEquals("Active", responseBody1.getRoamingBundle().get(0).getStatus());
				assertEquals(testData.TestData.off, responseBody1.getRoamingBundle().get(0).getNotifications());
				assertEquals("Roaming", responseBody1.getRoamingBundle().get(0).getBundleType());
				assertEquals(testData.TestData.roamingBundleCode,
						responseBody1.getRoamingBundle().get(0).getBundleCode());
			}
			if (!responseBody1.getRccBundle().isEmpty()) {
				assertEquals("Active", responseBody1.getRccBundle().get(0).getStatus());
				assertEquals(testData.TestData.off, responseBody1.getRccBundle().get(0).getNotifications());
				assertEquals("RCC", responseBody1.getRccBundle().get(0).getBundleType());
				assertEquals(testData.TestData.RCCBundleCode, responseBody1.getRccBundle().get(0).getBundleCode());
			}
			break;
		}
	}

	@Then("Validate the status and error in output response")
	public void validate_the_status_and_error_in_output_response() {
		notFoundResponse responseBody = output.getBody().as(notFoundResponse.class);
		System.out.println(responseBody.getError());
		assertEquals(responseBody.getStatus(), getResponseStatus("notFound"));

	}

}
