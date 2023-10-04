package com.jhart.dto;

public class TodoBackBean {
	
	private Long id;
	private String taskName;
	private UserBackBean user;
	private String createDate;
	private String complete;
	private String completeDate;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public UserBackBean getUser() {
		return user;
	}

	public void setUser(UserBackBean user) {
		this.user = user;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getComplete() {
		return complete;
	}

	public void setComplete(String complete) {
		this.complete = complete;
	}

	public String getCompleteDate() {
		return completeDate;
	}

	public void setCompleteDate(String completeDate) {
		this.completeDate = completeDate;
	}

	@Override
	public String toString() {
		return "TodoBackBean [id=" + id + ", taskName=" + taskName + ", user=" + user + ", createDate=" + createDate
				+ ", complete=" + complete + ", completeDate=" + completeDate + "]";
	}
	
}
