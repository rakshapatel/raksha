package DTO;

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
@Table(name="division")
public class Division {
	
	
	@Id
	@Column
	private int DivisionID;

	@Column
	private String Name;
	
	@OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL)
	@JoinColumn(name="AddressID", referencedColumnName = "AddressID")
	private Address parent;
	
	@ManyToOne(targetEntity=Circle.class)
	@JoinColumn(name="CircleID", referencedColumnName = "CircleID")
     private Circle circle; 
	
	@OneToMany(targetEntity = SubDivision.class, cascade = CascadeType.ALL,mappedBy="division")
	private Set subdiv;
	
	@ManyToMany(targetEntity = Role.class, cascade = CascadeType.ALL)
	@JoinTable(name="div_has_role", joinColumns = @JoinColumn(name="DivisionID", referencedColumnName = "DivisionID"),
	inverseJoinColumns = @JoinColumn(name="RoleID", referencedColumnName = "RoleID"))
	private Set div_role;
	
	
	

	public int getDivisionID() {
		return DivisionID;
	}

	public void setDivisionID(int divisionID) {
		DivisionID = divisionID;
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

	public Set getSubdiv() {
		return subdiv;
	}

	public void setSubdiv(Set subdiv) {
		this.subdiv = subdiv;
	}

	public Set getDiv_role() {
		return div_role;
	}

	public void setDiv_role(Set div_role) {
		this.div_role = div_role;
	}

	public Circle getCircle() {
		return circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	
	
	
}

