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
		
		properties p = new properties();
		if(testCase.contentEquals("TC066")) {
			p.setLimit(60.4567);
			input.setProperties(p);
		} else if(testCase.contentEquals("TC074")) {
			input.setProperties(p);
		} else if(testCase.contentEquals("TC075")) {
			p.setLimit(-60.4567);
			input.setProperties(p);
		}
		
		
		return input;
		
	}
	
}
