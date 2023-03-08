package com.ticketbooking.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USER_DTLS")
public class UserDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private Integer userId;
	
	@Column(name="USER_NAME")
	private String userName;
	
	
	@Column (name="NAME")
	private String name;
	
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="PROOF_TYPE")
	private String proofType;
	
	@Column(name="PROOF_NUMBER")
	private String proofNumber;
	
	@Column(name="AGE")
	private Integer age;
	
	@Column(name="EMAIL")
	private String emailId;
	
	@Column(name="PHONE_NUMBER")
	private Integer phoneNumber;
	
	@Column(name="PASSWORD")
	private String password;
	
	 @OneToMany(mappedBy="userDetails")
	 private List<TicketDetails> ticketDetails;
	 

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getProofType() {
		return proofType;
	}

	public void setProofType(String proofType) {
		this.proofType = proofType;
	}

	public String getProofNumber() {
		return proofNumber;
	}

	public void setProofNumber(String proofNumber) {
		this.proofNumber = proofNumber;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

	
	
}
