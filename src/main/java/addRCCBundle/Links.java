package addRCCBundle;

import com.fasterxml.jackson.annotation.JsonProperty;
import provision.href;

public class Links {
	
	@JsonProperty("Base / Roaming bundle purchase")
	private href baseRoamingBundlePurchase;
	@JsonProperty("RCC bundle purchase")
	private href rccBundlePurchase;
	@JsonProperty("Top-up bundle purchase")
	private href topupBundlePurchase;
	
	public Links() {}

	public href getBaseRoamingBundlePurchase() {
		return baseRoamingBundlePurchase;
	}

	public href getRccBundlePurchase() {
		return rccBundlePurchase;
	}

	public href getTopupBundlePurchase() {
		return topupBundlePurchase;
	}

}
