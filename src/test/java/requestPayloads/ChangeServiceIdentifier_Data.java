package requestPayloads;

import changeServiceIdentifier.changeServiceIdentifierRequest;
import stepDefinitions.ReUsableMethods;

public class ChangeServiceIdentifier_Data {
	
	public static changeServiceIdentifierRequest inputRequestPayload(String testCase, String... predata) {
		
		changeServiceIdentifierRequest input = new changeServiceIdentifierRequest();
		
		if(testCase == " ") {
			input.setNewServiceIdentifier(ReUsableMethods.getCurrentDateTimeMS() + "7");
		} else if(testCase == "TC202")
			input.setNewServiceIdentifier(ReUsableMethods.getCurrentDateTimeMS() + "756");
		else if(testCase == "TC203")
			input.setNewServiceIdentifier(predata[0]);
		else if(testCase == "TC208")
			input.setNewServiceIdentifier(" ");
		else
			input.setNewServiceIdentifier(null);
		
		
		return input;
	}
	
}
