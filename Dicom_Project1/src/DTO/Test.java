package DTO;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void create_table() {
		
		Configuration cfg= new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session ses=sf.openSession();
	   
		// one to one insert and one to many
	/*	
		  Address ad= new Address(); 
		  ad.setAddressID(102); 
		  ad.setCountry("India");
		  ad.setDistrict("Indore"); 
		  ad.setLine1("Old Palasia");
		  ad.setLine2("Raffel Tower"); 
		  ad.setPinCode(123456);
		  ad.setState("MadhyPradesh");
		  
		  
		  Company com=new Company(); 
		  com.setCompanyID(2);
		  com.setName("Aatek solutions"); 
		  com.setContact(980567893);
		  com.setEmail("aartek@gmail.com"); 
		  com.setInitials("Software Development");
		  com.setParent(ad);
		 
		  
		  Region reg= new Region();
		  reg.setRegionID(3); 
		  reg.setName("MP ");
		  reg.setParent(ad);
		  reg.setCompany(com);
		  
		  
		  Circle cir= new Circle(); 
		  cir.setCircleID(4); 
		  cir.setName("Malwa");
		  cir.setParent(ad);
		  cir.setRegion(reg);
		  
		  
		  Division div= new Division(); 
		  div.setDivisionID(5);
		  div.setName("division");
		  div.setParent(ad);
		  div.setCircle(cir);
		 
		  
		  SubDivision subdiv= new SubDivision(); 
		  subdiv.setSubdivisionID(6);
		  subdiv.setName("Dewas"); 
		  subdiv.setParent(ad);
		  subdiv.setDivision(div);
		  
		  
		  Distcenter_Zone dczone=new Distcenter_Zone(); 
		  dczone.setName("NorthZone");
		  dczone.setZoneID(7); 
		  dczone.setParent(ad);
		  dczone.setSubdivision(subdiv);
		 
		  
		  
		  Transaction tx=ses.beginTransaction();
		  ses.saveOrUpdate(cir); 
		  ses.saveOrUpdate(com);
		  ses.saveOrUpdate(dczone);
		  ses.saveOrUpdate(div); 
		  ses.saveOrUpdate(reg); 
		  ses.saveOrUpdate(subdiv);
		  tx.commit();
		  System.out.println("saved"); 
		  ses.close();
		  sf.close();
		 
	*/	
		//many to many insert
		
		
		/* Role rol= new Role(); 
		 rol.setRoleID(7891); 
		 rol.setCreateRole(1);
		  rol.setReadRole(2);
		  rol.setUpdateRole(3); 
		  rol.setDeleteRole(4);
		  rol.setExecuteRole(5);
		  rol.setName("Developer"); 
		  rol.setShortName("ASD");
		  
		  User usr= new User();
		  usr.setUserID(3455);
		  usr.setName("raksha patel");
		  usr.setMobile(810950016); 
		  usr.setPhone(0734313256);
		  usr.setPassword("12345");
		  usr.setEmail("rakshapatel@gmail.com");
		 
	  
		
		  Transaction tx= ses.beginTransaction();
		   ses.saveOrUpdate(rol); 
		   ses.saveOrUpdate(usr);
		  tx.commit(); 
		  System.out.println("save"); 
		  ses.close(); sf.close();
		 
		*/
		
		Role rol=(Role)ses.get(Role.class, 7890);
		Role rol1=(Role)ses.get(Role.class, 7891);
		Set s= new HashSet();
		s.add(rol);
		s.add(rol1);
		
		Company com=(Company)ses.get(Company.class, 1);
		com.setCom_role(s);
		Company com1=(Company)ses.get(Company.class, 2);
		com1.setCom_role(s);
		
		User usr=(User)ses.get(User.class, 3455);
		usr.setUser_role(s);
		User usr1=(User)ses.get(User.class, 3456);
		usr1.setUser_role(s);
		
		Region reg=(Region)ses.get(Region.class, 1 );
		reg.setReg_role(s);
		Region reg1=(Region)ses.get(Region.class, 3 );
		reg1.setReg_role(s);
		
		Circle cir=(Circle)ses.get(Circle.class, 1);
		cir.setCircle_role(s);
		Circle cir1=(Circle)ses.get(Circle.class, 4);
		cir1.setCircle_role(s);
		
		Division div=(Division)ses.get(Division.class,1);
		div.setDiv_role(s);
		Division div1=(Division)ses.get(Division.class,5);
		div1.setDiv_role(s);
		
		SubDivision subdiv=(SubDivision)ses.get(SubDivision.class,1);
		subdiv.setSubdiv_role(s);
		SubDivision subdiv1=(SubDivision)ses.get(SubDivision.class,6);
		subdiv1.setSubdiv_role(s);
		
		Distcenter_Zone diszone=(Distcenter_Zone)ses.get(Distcenter_Zone.class,1);
		diszone.setZone_role(s);
		Distcenter_Zone diszone1=(Distcenter_Zone)ses.get(Distcenter_Zone.class,7);
		diszone1.setZone_role(s);
		
        Transaction tx= ses.beginTransaction();
		ses.saveOrUpdate(com);
		ses.saveOrUpdate(com1);
		ses.saveOrUpdate(usr);
		ses.saveOrUpdate(usr1);
		ses.saveOrUpdate(reg);
		ses.saveOrUpdate(reg1);
		ses.saveOrUpdate(cir);
		ses.saveOrUpdate(cir1);
		ses.saveOrUpdate(div);
		ses.saveOrUpdate(div1);
		ses.saveOrUpdate(subdiv);
		ses.saveOrUpdate(subdiv1);
		ses.saveOrUpdate(diszone);
		ses.saveOrUpdate(diszone1);
		
		tx.commit();
		System.out.println("save");
		ses.close();
		sf.close();
		

	}

	
	public  static void update()
	{
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory f=cfg.buildSessionFactory();
		Session s=f.openSession();
		Transaction t=s.beginTransaction();

		
		
		Company c=(Company)s.get(Company.class,11);
		
		c.setName("ranu");
		
		s.saveOrUpdate(c);
	    t.commit();
		s.close();
		
		
	}
	
	public static void delete()
	{
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory f=cfg.buildSessionFactory();
		Session s=f.openSession();
		Transaction t=s.beginTransaction();
		Circle c=(Circle)s.get(Circle.class,1);
		
		Distcenter_Zone d=(Distcenter_Zone)s.get(Distcenter_Zone.class,4);
	    
		s.delete(d);
		t.commit();
		
		
		
	}
	
		  
	public static void  get() {
		
		Configuration cfg=new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session ses=sf.openSession();
		// company address
		/*
		 Company com=(Company)ses.get(Company.class, 733);
		  System.out.println(com.getCompanyID()+" "+com.getName()+ " "+com.getContact()+" "+com.getInitials()+ ""+com.getEmail());
		  
		 
		  Address add=com.getParent(); 
		  System.out.println(add.getAddressID()+""+add.getCountry()+""+add.getLine1()+""+add.getDistrict()+" "+add.getLine2()+""+add.getPinCode()+""+add.getState());
		 
		*/ 
		// region address
		
		/*  Region reg=(Region)ses.get(Region.class, 2001);
		  System.out.println(reg.getName()+""+reg.getRegionID()); 
		  
		  
		  Address add=reg.getParent();
		  System.out.println(add.getCountry()+""+add.getDistrict()+""+add.getLine1()+""+add.getLine2()+""+
				  add.getPinCode()+""+add.getState());
		  
		 */
		 
		
		//circle address
		/*
		  Circle cir=(Circle)ses.get(Circle.class, 1111);
		  System.out.println(cir.getCircleID()+""+cir.getName());
		  
		  
		  Address add=cir.getParent();
		  System.out.println(add.getCountry()+""+add.getDistrict()+""+add.getLine1()+""+add.getLine2()
		                     +""+add.getPinCode()+""+add.getState());
		  
		 */
		//division address
		
	
		 /* Division div=(Division)ses.get(Division.class,3001);
		  System.out.println(div.getDivisionID()+""+div.getName()); 
		  
		  
		  Address add=div.getParent(); 
		  System.out.println(add.getCountry()+""+add.getDistrict()+""+add.getLine1()+""+add.getLine2()+""+
				  add.getPinCode()+""+add.getState());
		  
		 */
		// subdivision address
		
	/*	
		  SubDivision subdiv=(SubDivision)ses.get(SubDivision.class, 10001);
		  System.out.println(subdiv.getName());
		  System.out.println(subdiv.getSubdivisionID());
		  
		 Address add=subdiv.getParent(); 
		
		  System.out.println(add.getCountry()+""+add.getDistrict()+""+add.getLine1()+""+add.getLine2()+""+
				  add.getPinCode()+""+add.getState());
		*/
		
		// zone address
		
		
		/*  Distcenter_Zone diszone=(Distcenter_Zone)ses.get(Distcenter_Zone.class, 5001);
		  System.out.println(diszone.getName());
		 System.out.println(diszone.getZoneID());
		 
		  Address add=diszone.getParent(); 
		  
		  System.out.println(add.getCountry()+""+add.getDistrict()+""+add.getLine1()+""+add.getLine2()+""+
				  add.getPinCode()+""+add.getState());
		*/
		
		// get prnt
		
		Company com=(Company)ses.get(Company.class, 1);
		System.out.println(com.getCompanyID()); 
		System.out.println(com.getName());
		System.out.println(com.getContact()); 
		System.out.println(com.getInitials());
		System.out.println(com.getEmail());
		
		Set s=com.getRegion();
		Iterator it=s.iterator();
		while(it.hasNext()) {
			Region reg=(Region)it.next();
			System.out.println(reg.getName());
			System.out.println(reg.getRegionID());
			
			Set s1=reg.getCircle();
			Iterator it1=s1.iterator();
			while(it1.hasNext()) {
				Circle cir=(Circle)it1.next();
				System.out.println(cir.getCircleID());
				System.out.println(cir.getName());
				
				Set s2=cir.getDivision();
				Iterator it2=s2.iterator();
				while(it2.hasNext()) {
					Division div=(Division)it2.next();
					System.out.println(div.getDivisionID());
					System.out.println(div.getName());
					
					Set s3=div.getSubdiv();
					Iterator it3=s3.iterator();
					while(it3.hasNext()) {
						SubDivision subdiv=(SubDivision)it3.next();
						System.out.println(subdiv.getName());
						System.out.println(subdiv.getSubdivisionID());
						
						Set s4=subdiv.getZone();
						Iterator it4=s4.iterator();
						while(it4.hasNext()) {
							Distcenter_Zone disz=(Distcenter_Zone)it4.next();
							System.out.println(disz.getName());
							System.out.println(disz.getZoneID());
							
						}
						
					}
				}
			}
		}
		
		
		
		
       
		
/*	Query q=ses.createQuery("from  Address");
	List l=q.list();
	Iterator it1=l.iterator();
	while(it1.hasNext())
	{
		Address a=(Address)it1.next();
		System.out.println(a.getAddressID()+" "+a.getCountry()+""+a.getDistrict()+" "+a.getLine1()+" "
		+a.getLine2()+" "+a.getPinCode()+" "+a.getState());
		
	}*/
	
	/*Object o = ses.get(Region.class,1);
	Region  r=(Region)o;
	
    Address a =r.getParent();
    System.out.println(a.getAddressID());*/
    //child parent
    Object o1 = ses.get(Region.class,1);
	Region  r1=(Region)o1;
	
    Address a1 =r1.getParent();
    System.out.println(a1.getAddressID());

    
  Region s1=(Region)o1;
    System.out.println(s1.getName());
    
	
	
	//parent child
	
	
	/*Object o2 = ses.get(Company.class,1);
	Company  r2=(Company)o2;
	
    Set a2 =r2.getRegion();
    //System.out.println(a1);
    Iterator it2=a2.iterator();
    while(it2.hasNext())
    {
    	Region r3=(Region)it2.next();
    	System.out.println(r3.getRegionID()+ ""+r3.getName());
    	
    }
	*/
	//child parent
	
	 Object o3 = ses.get(Region.class,1);
		Region  r3=(Region)o3;
		
        Company a3 =r3.getCompany();
        System.out.println(a3.getCompanyID());

        
      Region s3=(Region)o3;
        System.out.println(s3.getName());

	
	
	
    
	}

	
	public static void main(String[] args)
	{
		//create_table();
		//update();
		//delete();
		//get();
	}
}

