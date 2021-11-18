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
		m.input_provision_request_with_mandatory_attributes();
		m.api_is_called("Provision");
		m.validate_the_code_and_status_in_output_response("000", "Provision");
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
