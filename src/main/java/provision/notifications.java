package provision;

public class notifications {
	
	private int barringTopupPurchase;
	private int domesticNotifyEnabled;
	private int roamingNotifyEnabled;
	private int rccNotifyEnabled;

	public void setBarringTopupPurchase(int barringTopupPurchase) {
		if(!String.valueOf(barringTopupPurchase).isEmpty()) {
			this.barringTopupPurchase = barringTopupPurchase;
		}
	}

	public void setDomesticNotifyEnabled(int domesticNotifyEnabled) {
		if(!String.valueOf(domesticNotifyEnabled).isEmpty()) {
			this.domesticNotifyEnabled = domesticNotifyEnabled;
		}
	}

	public void setRoamingNotifyEnabled(int roamingNotifyEnabled) {
		if(!String.valueOf(roamingNotifyEnabled).isEmpty()) {
			this.roamingNotifyEnabled = roamingNotifyEnabled;
		}
	}

	public void setRccNotifyEnabled(int rccNotifyEnabled) {
		if(!String.valueOf(rccNotifyEnabled).isEmpty()) {
			this.rccNotifyEnabled = rccNotifyEnabled;
		}
	}

	public int getDomesticNotifyEnabled() {
		return domesticNotifyEnabled;
	}

	public int getRoamingNotifyEnabled() {
		return roamingNotifyEnabled;
	}

	public int getRccNotifyEnabled() {
		return rccNotifyEnabled;
	}

	public int getBarringTopupPurchase() {
		return barringTopupPurchase;
	}

}
