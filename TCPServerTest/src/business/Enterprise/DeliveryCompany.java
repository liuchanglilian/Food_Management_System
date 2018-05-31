/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Enterprise;

import Role.DeliveryComponyManagerRole;
import Role.RestaurantManagerRole;
import business.Organization.DeliveryMenOrganization;
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
public class DeliveryCompany extends Enterprise implements Serializable {
   private static final long serialVersionUID = 1L;

  /*  public static long getSerialVersionUID() {
        return serialVersionUID;
    }*/
      
    public DeliveryCompany(String name, String personName,String userName,String password) {
      
        super(name, Enterprise.EnterpriseType.DeliveryCompany,personName,userName,password);
        super.userAccount.setRole(new DeliveryComponyManagerRole());
         
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
       ArrayList<Organization> list = new ArrayList<>();
       list.add(new DeliveryMenOrganization());
       return list;
    }
     public UserAccount authanticate(String name,String password)
    {
       return userAccount.checkAccount(name, password);
    }
}
