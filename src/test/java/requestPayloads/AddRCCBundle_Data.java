package requestPayloads;

import addRCCBundle.*;
import testData.TestData;

public class AddRCCBundle_Data extends TestData {
	
	public static addRCCBundleRequest inputRequestPayload(String testCase, String ...preData ) {
		
		//Input Request
		addRCCBundleRequest input = new addRCCBundleRequest();
		
		if(preData[0].contentEquals("RCC")) {
			input.setBundleCode(RCCBundleCode);
		} else if(preData[0].contentEquals("Invalid")) {
			input.setBundleCode(invalidCode);
		} else if(preData[0].contentEquals("Roaming")) {
			input.setBundleCode(roamingBundleCode);
		}
		
		return input;
		
	}
	
}
