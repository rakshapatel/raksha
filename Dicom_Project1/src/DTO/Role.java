package DTO;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")

public class Role {

	@Id
	@Column
	private int RoleID;
	
	@Column
	private int CreateRole;
	
	@Column
	private int ReadRole;
	
	@Column
	private int UpdateRole;
	
	@Column
	private int DeleteRole;
	
	@Column
	private int ExecuteRole;
	
	@Column
	private String Name;
	
	@Column
	private String ShortName;

	
	@ManyToMany(targetEntity = Company.class, mappedBy = "com_role")
	private Set company;
	
	@ManyToMany(targetEntity = User.class, mappedBy = "user_role")
    private Set user;
	
	@ManyToMany(targetEntity = Region.class, mappedBy = "reg_role")
	private Set region;
	
	@ManyToMany(targetEntity = Circle.class, mappedBy = "circle_role")
	private Set circle;
	
	@ManyToMany(targetEntity = Division.class, mappedBy = "div_role")
	private Set division;
	
	@ManyToMany(targetEntity = SubDivision.class, mappedBy = "subdiv_role")
	private Set subdivision;
	
	@ManyToMany(targetEntity = Distcenter_Zone.class, mappedBy = "zone_role")
	private Set zone;
	
	public int getRoleID() {
		return RoleID;
	}

	public void setRoleID(int roleID) {
		RoleID = roleID;
	}

	public int getCreateRole() {
		return CreateRole;
	}

	public void setCreateRole(int createRole) {
		CreateRole = createRole;
	}

	public int getReadRole() {
		return ReadRole;
	}

	public void setReadRole(int readRole) {
		ReadRole = readRole;
	}

	public int getUpdateRole() {
		return UpdateRole;
	}

	public void setUpdateRole(int updateRole) {
		UpdateRole = updateRole;
	}

	public int getDeleteRole() {
		return DeleteRole;
	}

	public void setDeleteRole(int deleteRole) {
		DeleteRole = deleteRole;
	}

	public int getExecuteRole() {
		return ExecuteRole;
	}

	public void setExecuteRole(int executeRole) {
		ExecuteRole = executeRole;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getShortName() {
		return ShortName;
	}

	public void setShortName(String shortName) {
		ShortName = shortName;
	}

	public Set getCompany() {
		return company;
	}

	public void setCompany(Set company) {
		this.company = company;
	}

	public Set getUser() {
		return user;
	}

	public void setUser(Set user) {
		this.user = user;
	}

	public Set getRegion() {
		return region;
	}

	public void setRegion(Set region) {
		this.region = region;
	}

	public Set getCircle() {
		return circle;
	}

	public void setCircle(Set circle) {
		this.circle = circle;
	}

	public Set getDivision() {
		return division;
	}

	public void setDivision(Set division) {
		this.division = division;
	}

	public Set getSubdivision() {
		return subdivision;
	}

	public void setSubdivision(Set subdivision) {
		this.subdivision = subdivision;
	}

	public Set getZone() {
		return zone;
	}

	public void setZone(Set zone) {
		this.zone = zone;
	}
	
	
	
}
