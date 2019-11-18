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
@Table(name="region")

public class Region {
	
	    @Id
	    @Column
		private int RegionID;
	    
	    @Column
	    private String Name;
	    
	    @OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL)
	    @JoinColumn(name="AddressID", referencedColumnName = "AddressID")
	    private Address parent;
	    
	    
	    @OneToMany(targetEntity = Circle.class, cascade = CascadeType.ALL,mappedBy="region")
	     private Set circle;
	    
	    
	    @ManyToMany(targetEntity = Role.class, cascade = CascadeType.ALL)
	    @JoinTable(name="region_has_role", joinColumns = @JoinColumn(name="RegionID", referencedColumnName = "RegionID"),
	    inverseJoinColumns = @JoinColumn(name="RoleID", referencedColumnName = "RoleID"))
	    private Set reg_role;

		
	    @ManyToOne(targetEntity=Company.class)
	    @JoinColumn(name = "company_CompanyID",referencedColumnName="CompanyID")
	     private Company company; 

		public int getRegionID() {
			return RegionID;
		}

		public void setRegionID(int regionID) {
			RegionID = regionID;
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
	    
		public Set getCircle() {
			return circle;
		}

		public void setCircle(Set circle) {
			this.circle = circle;
		}

		public Set getReg_role() {
			return reg_role;
		}

		public void setReg_role(Set reg_role) {
			this.reg_role = reg_role;
		}

		public Company getCompany() {
			return company;
		}

		public void setCompany(Company company) {
			this.company = company;
		}

	 
	

}