package testData;

import provision.bundleGroup;

public class bundleGroupData extends TestData {
	
	public static bundleGroup bundleData() {
		bundleGroup input = new bundleGroup();
		input.setBaseBundle(bundleCode);
		//input.setRoamingBundle(roamingBundleCode);
		//input.setRccBundle(RCCBundleCode);
		return input;
	}

}
