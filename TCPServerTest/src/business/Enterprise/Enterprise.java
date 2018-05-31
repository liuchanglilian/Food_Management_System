/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Enterprise;

import Role.Role;
import business.Organization.EnterpriseLevelOrganizationDirectory;
import business.Organization.Organization;
import business.Person.Person;
import business.Person.PersonDirectory;
import business.UserAccount.UserAccount;
import business.UserAccount.UserAccountDirectory;
import business.WorkQueue.WorkQueue;
import java.util.ArrayList;
import business.Organization.OrganizationDirectory;
import Address.Address;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author liuch
 */
public abstract class Enterprise extends Organization implements Serializable{
     //private String name;
    private  EnterpriseLevelOrganizationDirectory  organizationDirectory;
    private EnterpriseType enterpriseType;
    protected UserAccount userAccount;
    private Person person;
    private Address EnterpriseAddress;
    private static final long serialVersionUID = 1L;

  /*  public static long getSerialVersionUID() {
        return serialVersionUID;
    }*/

    public void setOrganizationDirectory(EnterpriseLevelOrganizationDirectory organizationDirectory) {
        this.organizationDirectory = organizationDirectory;
    }
      
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
  
    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public Address getEnterpriseAddress() {
        return EnterpriseAddress;
    }

    public void setEnterpriseAddress(Address EnterpriseAddress) {
        this.EnterpriseAddress = EnterpriseAddress;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(EnterpriseType enterpriseType) {
        this.enterpriseType = enterpriseType;
    }
   
    public enum EnterpriseType implements Serializable{
        Restaurant("Restaurant"), SuperMarket("SuperMarket"),Orphane("Orphane"),DeliveryCompany("DeliveryCompany"),Biofactory("Biofactory");
        private String value;
        private static final long serialVersionUID = 1L;
        private EnterpriseType(String value) {
            this.value = value;
        }

        public static long getSerialVersionUID() {
            return serialVersionUID;
        }
        public String getValue() {
            return value;
            
        
        }
        @Override
        public String toString() {
            return value;
        }       
   }
    public boolean checkEnterPriseUserName(String userName)
    {
      if(userAccount.getUsername().equals(userName))
          return true;
      else 
          return false;
    }
   public boolean checkEnterpriseOrganizationList(String userName)
   {
       if(organizationDirectory.checkEnterpriseLevelOrganizationDirectory(userName))
           return true;
       else
           return false;
   }
 public EnterpriseLevelOrganizationDirectory  getOrganizationDirectory() {
        return organizationDirectory;
    }
 
     public Enterprise(String name, EnterpriseType type,String personName,String userName,String password) {
        super(name);
        this.enterpriseType = type;
        organizationDirectory = new  EnterpriseLevelOrganizationDirectory() ;
        Person person= new Person();
        Address EnterpriseAddress = new Address();
        person.setName(personName);
        userAccount = new UserAccount();
        userAccount.setPerson(person);
        userAccount.setUsername(userName);
        userAccount.setPassword(password);
        
    }
    
    public abstract ArrayList<Organization> getSupportedOrganization();
    public abstract UserAccount authanticate(String name,String password);
 
}
