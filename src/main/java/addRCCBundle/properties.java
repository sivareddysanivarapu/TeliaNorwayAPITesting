package addRCCBundle;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class properties {
	
	private double limit;

	public double getLimit() {
		return limit;
	}

	public void setLimit(double limit) {
		if(!String.valueOf(limit).isEmpty()) {
			this.limit = limit;
		}
	}

}
