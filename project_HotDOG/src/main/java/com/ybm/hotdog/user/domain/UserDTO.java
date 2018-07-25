package com.ybm.hotdog.user.domain;

/**
 * 회원 관련 객체 선언 및 getter(), setter() 메소드 정의
 * 
 * @Package : com.ybm.hotdog.user.domain
 * @FileName : UserDTO.java
 * @Author : YI JONGYUN
 * @date : 2018. 7. 25.
 *
 */
public class UserDTO {

	private int userNo;
	private String id;
	private String password;
	private String name;
	private String phone;
	private int grade;

	public UserDTO() {}

	public UserDTO(int userNo, String id, String password, String name, String phone, int grade) {
		this.userNo = userNo;
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.grade = grade;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "UserDTO [userNo=" + userNo + ", id=" + id + ", password=" + password + ", name=" + name + ", phone=" + phone + ", grade=" + grade + "]";
	}

}
