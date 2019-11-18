package DTO;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="company")
public class Company {

	@Id
	@Column
	private int CompanyID;
	
	@Column
	private String Name;
	
	@Column
	private String Initials;
	
	
	@Column
	private String email;
	
	@Column
	private int Contact;
	
	@OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL)
	@JoinColumn(name="AddressID", referencedColumnName = "AddressID")
	private Address parent;
	
	
	@OneToMany(targetEntity = Region.class, cascade = CascadeType.ALL,mappedBy="company")
	private Set region;
	
	
	@ManyToMany(targetEntity = Role.class, cascade = CascadeType.ALL)
	@JoinTable(name="company_has_role", joinColumns = @JoinColumn(name="CompanyID", referencedColumnName = "CompanyID"),
	inverseJoinColumns = @JoinColumn(name="RoleID", referencedColumnName = "RoleID"))
	private Set  com_role;
	
	
	public int getCompanyID() {
		return CompanyID;
	}

	public void setCompanyID(int companyID) {
		CompanyID = companyID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getInitials() {
		return Initials;
	}

	public void setInitials(String initials) {
		Initials = initials;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getContact() {
		return Contact;
	}

	public void setContact(int contact) {
		Contact = contact;
	}

	public Address getParent() {
		return parent;
	}

	public void setParent(Address parent) {
		this.parent = parent;
	}

	public Set getRegion() {
		return region;
	}

	public void setRegion(Set region) {
		this.region = region;
	}

	public Set getCom_role() {
		return com_role;
	}

	public void setCom_role(Set com_role) {
		this.com_role = com_role;
	}

	
	}

	