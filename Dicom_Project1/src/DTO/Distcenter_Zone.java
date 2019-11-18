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
import javax.persistence.OneToOne;
	import javax.persistence.Table;

	@Entity
	@Table(name="zone")
	public class Distcenter_Zone {


		@Id
		@Column
		private int ZoneID;
		
		@Column
		private String Name;
	
		@ManyToOne(targetEntity=SubDivision.class)
		@JoinColumn(name="sub_subdivisionID", referencedColumnName = "subdivisionID")
	     private SubDivision subdivision;
		
		@OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL)
		@JoinColumn(name="AddressID", referencedColumnName = "AddressID")
		private Address parent;
		
		
		@ManyToMany(targetEntity = Role.class, cascade = CascadeType.ALL)
		@JoinTable(name="zone_has_role", joinColumns = @JoinColumn(name="ZoneID", referencedColumnName = "ZoneID"),
		inverseJoinColumns = @JoinColumn(name="RoleID", referencedColumnName = "RoleID"))
		private Set zone_role;

		public int getZoneID() {
			return ZoneID;
		}

		public void setZoneID(int zoneID) {
			ZoneID = zoneID;
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

		public Set getZone_role() {
			return zone_role;
		}

		public void setZone_role(Set zone_role) {
			this.zone_role = zone_role;
		}

		public SubDivision getSubdivision() {
			return subdivision;
		}

		public void setSubdivision(SubDivision subdivision) {
			this.subdivision = subdivision;
		}
		
		
		
	}

