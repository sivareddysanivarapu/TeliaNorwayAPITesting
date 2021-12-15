package getBundles;

import java.util.List;

import provision.errors;

public class getResponse {
	
	private String code;
	private String status;
	private String accountNumber;
	private String message;
	private List<errors> errors;
	
	public getResponse() {

	}

	public String getStatus() {
		return status;
	}

	public String getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public List<errors> getErrors() {
		return errors;
	}

}
