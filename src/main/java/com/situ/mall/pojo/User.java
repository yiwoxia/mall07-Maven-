package com.situ.mall.pojo;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	/**用户表id*/
	private Integer id;
	/**用户名*/
	private String username;
	/**用户密码，MD5加密*/
	private String password;
	
	private String email;
	
	private String phone;
	/**找回密码问题*/
	private String question;
	/**找回密码答案*/
	private String answer;
	/**角色0-管理员,1-普通用户*/
	private Integer role;
	/**状态*/
	private Integer status;
	/**激活码*/
	private String activeCode;
	/**创建时间*/
	private Date createTime;
	/**最后一次更新时间*/
	private Date updateTime;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	public User(Integer id, String username, String password, String email, String phone, String question,
			String answer, Integer role, Integer status, String activeCode, Date createTime, Date updateTime) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.question = question;
		this.answer = answer;
		this.role = role;
		this.status = status;
		this.activeCode = activeCode;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}





	public User(Integer id, String username, String password, String email, String phone, String question,
			String answer, Integer role, Date createTime, Date updateTime) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.question = question;
		this.answer = answer;
		this.role = role;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}


	
	

	public Integer getStatus() {
		return status;
	}



	public void setStatus(Integer status) {
		this.status = status;
	}



	public String getActiveCode() {
		return activeCode;
	}



	public void setActiveCode(String activeCode) {
		this.activeCode = activeCode;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", phone="
				+ phone + ", question=" + question + ", answer=" + answer + ", role=" + role + ", status=" + status
				+ ", activeCode=" + activeCode + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}
	
}
