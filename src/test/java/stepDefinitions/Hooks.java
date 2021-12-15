package stepDefinitions;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	public static String accessToken;

	@Before
	public void start(Scenario scenario) throws FileNotFoundException {
		@SuppressWarnings("resource")
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt", true));
		log.println("##################Test Case Start####################");
		log.println("Test Case: " + scenario.getName());
		log.println();
	}

	@Before("@PrimarySubscription")
	public static void primarySubscription() throws IOException {
		Decorators.prerequisiteStart();
		stepDefinition m = new stepDefinition();
		//m.input_provision_request_bundle_group("with");
		m.input_provision_request_for_with_attributes("teliano", "Mandatory");
		m.api_is_called_with_attributes("Provision", "Valid");
		m.validate_the_code_status_and_message_in_output_response("000", "Provision");
		Decorators.prerequisiteEnd();
	}

	@Before("@SecondarySubscription")
	public static void secondarySubscription() throws IOException {
		Hooks.primarySubscription();
		Decorators.prerequisiteStart();
		stepDefinition m = new stepDefinition();
		m.input_addsubscription_request_with_attributes(" ");
		m.api_is_called_with_attributes("AddSubscription", "Valid");
		m.validate_the_code_status_and_message_in_output_response("000", "AddSubscription");
		Decorators.prerequisiteEnd();
	}

	@Before("@PurchaseRCCBundle")
	public static void purchaseRCCBundle() throws IOException {
		Decorators.prerequisiteStart();
		stepDefinition m = new stepDefinition();
		m.input_provision_request_bundle_group("with");
		m.api_is_called_with_attributes("Provision", "Valid");
		m.validate_the_code_status_and_message_in_output_response("000", "Provision");
		Decorators.prerequisiteEnd();
	}

	@Before("@CancelSubscription")
	public static void cancelSubscription() throws IOException {
		Hooks.primarySubscription();
		Decorators.prerequisiteStart();
		stepDefinition m = new stepDefinition();
		m.input_delete_request();
		m.api_is_called_with_attributes("DeleteSubscription", "Valid");
		Decorators.prerequisiteEnd();
	}

	@Before("@CancelSecondarySubscription")
	public static void cancelSecondarySubscription() throws IOException {
		Hooks.secondarySubscription();
		Decorators.prerequisiteStart();
		stepDefinition m = new stepDefinition();
		m.input_delete_request();
		m.api_is_called_with_attributes("DeleteSubscription", "Valid");
		Decorators.prerequisiteEnd();
	}

	@Before("@ModifyServiceIdentifier")
	public static void modifyServiceIdentifier() throws IOException {
		Hooks.primarySubscription();
		Decorators.prerequisiteStart();
		stepDefinition m = new stepDefinition();
		m.input_request_with_service_identifiers("Valid");
		m.api_is_called_with_attributes("ChangeServiceIdentifier", "Valid");
		m.validate_the_code_status_and_message_in_output_response("000", "ChangeServiceIdentifier");
		Decorators.prerequisiteEnd();
	}

	@Before("@BaseRoaming")
	public static void baseRoaming() throws IOException {
		Decorators.prerequisiteStart();
		stepDefinition m = new stepDefinition();
		m.input_provision_request_with_only_bundle("baseRoaming");
		m.api_is_called_with_attributes("Provision", "Valid");
		m.validate_the_code_status_and_message_in_output_response("000", "Provision");
		Decorators.prerequisiteEnd();
	}

	@Before("@BaseRCC")
	public static void baseRCC() throws IOException {
		Decorators.prerequisiteStart();
		stepDefinition m = new stepDefinition();
		m.input_provision_request_with_only_bundle("baseRcc");
		m.api_is_called_with_attributes("Provision", "Valid");
		m.validate_the_code_status_and_message_in_output_response("000", "Provision");
		Decorators.prerequisiteEnd();
	}

	@Before("@BaseAddOn")
	public static void baseAddon() throws IOException {
		Hooks.primarySubscription();
		Decorators.prerequisiteStart();
		stepDefinition m = new stepDefinition();
		m.input_request_with_bundle("AddOn", "with");
		m.api_is_called_with_attributes("AddBundle", "Valid");
		m.validate_the_code_status_and_message_in_output_response("000", "AddBundle");
		Decorators.prerequisiteEnd();
	}
	
	@Before("@CancelBundle")
	public static void cancelBundle() throws IOException {
		Hooks.primarySubscription();
		Decorators.prerequisiteStart();
		stepDefinition m = new stepDefinition();
		m.input_delete_request();
		m.api_is_called_with_attributes("DeleteBundle", "Valid Roaming");
		Decorators.prerequisiteEnd();
	}
	
	@Before("@BundleGroup")
	public static void bundleGroup() throws IOException {
		Decorators.prerequisiteStart();
		stepDefinition m = new stepDefinition();
		m.input_provision_request_bundle_group("with");
		m.api_is_called_with_attributes("Provision", "Valid");
		m.validate_the_code_status_and_message_in_output_response("000", "Provision");
		m.input_request_with_bundle("AddOn", "with");
		m.api_is_called_with_attributes("AddBundle", "Valid");
		m.validate_the_code_status_and_message_in_output_response("000", "AddBundle");
		Decorators.prerequisiteEnd();
	}

	@After
	public void stop() throws FileNotFoundException {
		@SuppressWarnings("resource")
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt", true));
		log.println();
		log.println("###################Test Case End#####################");
		log.println();
	}

}
