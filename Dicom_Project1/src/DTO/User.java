package DTO;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")

public class User {
	
	@Id
	@Column
	private int UserID;
	
	@Column
	private String Name;
	
	@Column
	private int Mobile;
	
	@Column
	private int Phone;
	
	@Column
	private String Email;
	
	@Column
	private String Password;
	
	@ManyToMany(targetEntity = Role.class, cascade = CascadeType.ALL)
	@JoinTable(name="user_has_role", joinColumns = @JoinColumn(name="UserID", referencedColumnName = "UserID"),
	inverseJoinColumns = @JoinColumn(name="RoleID", referencedColumnName = "RoleID"))
	private Set user_role;

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getMobile() {
		return Mobile;
	}

	public void setMobile(int mobile) {
		Mobile = mobile;
	}

	public int getPhone() {
		return Phone;
	}

	public void setPhone(int phone) {
		Phone = phone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Set getUser_role() {
		return user_role;
	}

	public void setUser_role(Set user_role) {
		this.user_role = user_role;
	}
	
	
	

}
