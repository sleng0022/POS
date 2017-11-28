package frame;


import java.time.LocalDateTime;

public class UserRegister {
	private String userRegisterId;
	private int userId;
	private int registerId;
	private LocalDateTime logonTime;
	private LocalDateTime logoffTime;
	
	public String getUserRegisterId() {
		return userRegisterId;
	}
	public void setUserRegisterId(String userRegisterId) {
		this.userRegisterId = userRegisterId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRegisterId() {
		return registerId;
	}
	public void setRegisterId(int registerId) {
		this.registerId = registerId;
	}
	public LocalDateTime getLogonTime() {
		return logonTime;
	}
	public void setLogonTime(LocalDateTime logonTime) {
		this.logonTime = logonTime;
	}
	public LocalDateTime getLogoffTime() {
		return logoffTime;
	}
	public void setLogoffTime(LocalDateTime logoffTime) {
		this.logoffTime = logoffTime;
	}	
}