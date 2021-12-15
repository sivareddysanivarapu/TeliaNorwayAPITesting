package changeServiceIdentifier;

import java.util.List;

import provision.errors;

public class changeServiceIdentifierResponse {
	
	private String code;
	private String status;
	private String accountNumber;
	private String message;
	private List<errors> errors;
	private Links _links;

	public changeServiceIdentifierResponse() {

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

	public Links get_links() {
		return _links;
	}
	
}
