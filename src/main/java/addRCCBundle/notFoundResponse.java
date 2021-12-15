package addRCCBundle;

public class notFoundResponse {
	
	private String timestamp;
	private String status;
	private String error;
	private String message;
	private String path;
	private String requestId;

	public notFoundResponse() {}

	public String getTimestamp() {
		return timestamp;
	}

	public String getStatus() {
		return status;
	}

	public String getError() {
		return error;
	}

	public String getMessage() {
		return message;
	}

	public String getPath() {
		return path;
	}
	
	public String getRequestId() {
		return requestId;
	}

}
