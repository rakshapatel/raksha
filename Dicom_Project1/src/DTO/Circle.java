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
@Table(name="circle")

public class Circle {

	@Id
	@Column
	private int CircleID;
	
	@Column
	private String Name;
	
	@OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL)
	@JoinColumn(name="AddressID", referencedColumnName = "AddressID")
	private Address parent;
	
	
	@OneToMany(targetEntity = Division.class, cascade = CascadeType.ALL,mappedBy="circle")
	private Set division;
	
	@ManyToOne(targetEntity=Region.class)
    @JoinColumn(name = "region_RegionID",referencedColumnName="RegionID")
     private Region region; 
	
	@ManyToMany(targetEntity = Role.class, cascade = CascadeType.ALL)
	@JoinTable(name="circle_has_role", joinColumns = @JoinColumn(name="CircleID", referencedColumnName = "CircleID"),
	inverseJoinColumns = @JoinColumn(name="RoleID", referencedColumnName = "RoleID"))
	private Set circle_role;

	public int getCircleID() {
		return CircleID;
	}

	public void setCircleID(int circleID) {
		CircleID = circleID;
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

	public Set getDivision() {
		return division;
	}

	public void setDivision(Set division) {
		this.division = division;
	}

	public Set getCircle_role() {
		return circle_role;
	}

	public void setCircle_role(Set circle_role) {
		this.circle_role = circle_role;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}
	
	
	
}
