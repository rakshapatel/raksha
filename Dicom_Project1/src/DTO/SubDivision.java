package DTO;


import java.lang.annotation.Target;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="subdivision")
public class SubDivision {

	@Id
	@Column
	private int subdivisionID;
	
	
	@Column
	private String Name;
	
	@ManyToOne(targetEntity=Division.class)
	@JoinColumn(name="DivisionID", referencedColumnName = "DivisionID") 
     private Division division;
	
	@OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL)
	@JoinColumn(name="AddressID", referencedColumnName = "AddressID")
	private Address parent;
	
	
	@OneToMany(targetEntity = Distcenter_Zone.class, cascade = CascadeType.ALL,mappedBy="subdivision")
	private Set zone;
	
	@ManyToMany(targetEntity = Role.class, cascade = CascadeType.ALL)
	@JoinTable(name="subdiv_has_role", joinColumns = @JoinColumn(name="subdivisionID", referencedColumnName = "subdivisionID"),
	inverseJoinColumns = @JoinColumn(name="RoleID", referencedColumnName = "RoleID"))
	private Set subdiv_role;


	public int getSubdivisionID() {
		return subdivisionID;
	}


	public void setSubdivisionID(int subdivisionID) {
		this.subdivisionID = subdivisionID;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public Address getParent() {
		return parent;
	}


	public void setParent(Address parent) {
		this.parent = parent;
	}


	public Set getZone() {
		return zone;
	}


	public void setZone(Set zone) {
		this.zone = zone;
	}


	public Set getSubdiv_role() {
		return subdiv_role;
	}


	public void setSubdiv_role(Set subdiv_role) {
		this.subdiv_role = subdiv_role;
	}


	public Division getDivision() {
		return division;
	}


	public void setDivision(Division division) {
		this.division = division;
	}
	
	
	
	


	
	
}
