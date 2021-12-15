package testData;

import provision.bundleGroup;

public class bundleGroupData extends TestData {
	
	public static bundleGroup bundleData() {
		bundleGroup input = new bundleGroup();
		input.setBaseBundle(bundleCode);
		input.setRoamingBundle(roamingBundleCode);
		input.setRccBundle(RCCBundleCode);
		return input;
	}
	
	public static bundleGroup onlyBase() {
		bundleGroup input = new bundleGroup();
		input.setBaseBundle(bundleCode);
		return input;
	}
	
	public static bundleGroup onlyRoaming() {
		bundleGroup input = new bundleGroup();
		input.setRoamingBundle(roamingBundleCode);
		return input;
	}
	
	public static bundleGroup onlyRCC() {
		bundleGroup input = new bundleGroup();
		input.setRccBundle(RCCBundleCode);
		return input;
	}
	
	public static bundleGroup invalidData() {
		bundleGroup input = new bundleGroup();
		input.setBaseBundle(bundleCode);
		input.setRoamingBundle(roamingBundleCode);
		input.setRccBundle(invalidCode);
		return input;
	}
	
	public static bundleGroup baseRoaming() {
		bundleGroup input = new bundleGroup();
		input.setBaseBundle(bundleCode);
		input.setRoamingBundle(roamingBundleCode);
		return input;
	}
	
	public static bundleGroup baseRCC() {
		bundleGroup input = new bundleGroup();
		input.setBaseBundle(bundleCode);
		input.setRccBundle(RCCBundleCode);
		return input;
	}

}
