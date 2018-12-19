package next.model;

public class Result {
	private boolean status;
	private String message;
	
	public Result(boolean status) {
		this(status,"");
	}
	public Result(boolean status,String message) {
		this.status =status;
		this.message =message;
	}
	
	public static Result ok() {
		return new Result(true);
	}
	public static Result fail(String message) {
		return new Result(false,message);
	}
	
	public boolean isStatus() {
		return this.status;
	}
	public String getMessage() {
		return this.message;
	}
	public String toString() {
		return "Result [status=" +status+
				",message="+message+"]";
	}
}
