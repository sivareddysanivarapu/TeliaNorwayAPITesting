package provision;

public class bundleGroup {
	
	private String baseBundle;
	private String roamingBundle;
	private String rccBundle;
	
	public void setBaseBundle(String baseBundle) {
		if(!baseBundle.isEmpty()) {
			this.baseBundle = baseBundle;
		}
	}

	public void setRoamingBundle(String roamingBundle) {
		if(!roamingBundle.isEmpty()) {
			this.roamingBundle = roamingBundle;
		}
	}

	public void setRccBundle(String rccBundle) {
		if(!rccBundle.isEmpty()) {
			this.rccBundle = rccBundle;
		}
	}

	public String getBaseBundle() {
		return baseBundle;
	}

	public String getRoamingBundle() {
		return roamingBundle;
	}

	public String getRccBundle() {
		return rccBundle;
	}

}
