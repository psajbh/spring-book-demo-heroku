package com.jhart.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name="Todo")
public class Todo {
	
	public Todo() {}
    
	public Todo(String taskName, User user) {
		this.taskName = taskName;
		this.user = user;
		this.complete = false;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	private String taskName;
	
	@ManyToOne
	//@JoinColumn(name="id")
	private User user;
	
    private boolean complete;
    private Date completeDate;
    private Date createDate;
    
    @PrePersist
    void createDate() {
        this.createDate = new Date();
    }

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public Date getCompleteDate() {
		return completeDate;
	}

	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", taskName=" + taskName + ", user=" + user + ", complete=" + complete
				+ ", completeDate=" + completeDate + ", createDate=" + createDate + "]";
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(complete, completeDate, createDate, id, taskName, user);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Todo other = (Todo) obj;
//		return complete == other.complete && Objects.equals(completeDate, other.completeDate)
//				&& Objects.equals(createDate, other.createDate) && Objects.equals(id, other.id)
//				&& Objects.equals(taskName, other.taskName) && Objects.equals(user, other.user);
//	}
//    
    
}


