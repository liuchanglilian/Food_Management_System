/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Enterprise;

import Role.BiofactoryManagerRole;
import Role.RestaurantManagerRole;
import business.Organization.Organization;
import business.Organization.RestaurantWorkersOrganization;
import business.Person.Person;
import business.UserAccount.UserAccount;
import business.WorkQueue.WorkQueue;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author liuch
 */
public class BioFactory extends Enterprise implements Serializable{
   
   private WorkQueue requestQueue;
private static final long serialVersionUID = 1L;

    /*public static long getSerialVersionUID() {
        return serialVersionUID;
    }*/
      
    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public BioFactory(String name,String personName,String userName,String password) {
      
        super(name, EnterpriseType.Biofactory,personName,userName,password);
        super.userAccount.setRole(new BiofactoryManagerRole());
        requestQueue = new WorkQueue();
    }

    public WorkQueue getRequestQueue() {
        return requestQueue;
    }

    public void setRequestQueue(WorkQueue requestQueue) {
        this.requestQueue = requestQueue;
    }
    

    @Override
    public ArrayList<Organization> getSupportedOrganization()
    {
       return null;
        
    }
    public String toString()
    {
        return this.getName();
    }
    
    
    public UserAccount authanticate(String name,String password)
    {
       return userAccount.checkAccount(name, password);
    }
        
    
}
