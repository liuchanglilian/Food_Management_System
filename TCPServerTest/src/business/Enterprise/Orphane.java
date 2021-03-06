/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Enterprise;

import Role.OrphaneManagerRole;
import Role.RestaurantManagerRole;
import business.Organization.Organization;
import business.Organization.RestaurantWorkersOrganization;
import business.Person.Person;
import business.UserAccount.UserAccount;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author liuch
 */
public class Orphane extends Enterprise implements Serializable {
    private static final long serialVersionUID = 1L;

   /* public static long getSerialVersionUID() {
        return serialVersionUID;
    }*/
      
    public Orphane(String name, String personName,String userName,String password) {
      
        super(name, Enterprise.EnterpriseType.Orphane,personName,userName,password);
        super.userAccount.setRole(new OrphaneManagerRole());
         
    }

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

    @Override
    public ArrayList<Organization> getSupportedOrganization()
    {
        return null;
    }
     public UserAccount authanticate(String name,String password)
    {
       return userAccount.checkAccount(name, password);
    }
}
