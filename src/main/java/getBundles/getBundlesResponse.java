package getBundles;

import java.util.ArrayList;

public class getBundlesResponse {
	
	private ArrayList<baseBundle> baseBundles;
	private ArrayList<rccBundle> rccBundles;
	private ArrayList<roamingBundle> roamingBundles;
	
	public ArrayList<baseBundle> getBaseBundles() {
		return baseBundles;
	}
	public ArrayList<rccBundle> getRccBundles() {
		return rccBundles;
	}
	public ArrayList<roamingBundle> getRoamingBundles() {
		return roamingBundles;
	}
	
}
