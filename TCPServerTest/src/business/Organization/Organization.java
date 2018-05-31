/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Organization;

import Role.Role;
import business.Person.Person;
import business.UserAccount.UserAccount;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author liuch
 */
public abstract class Organization  implements Serializable{
    protected String name;
    private int organizationID;
    private static int counter;
private static final long serialVersionUID = 1L;

    public void setName(String name) {
        this.name = name;
    }

 /*   public static long getSerialVersionUID() {
        return serialVersionUID;
    }
      */
    public int getOrganizationID() {
        return organizationID;
    }

    public void setOrganizationID(int organizationID) {
        this.organizationID = organizationID;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Organization.counter = counter;
    }
    
     public Organization(String name) {
        this.name = name;
        organizationID = counter;
        ++counter;
    }
     public String getName()
     {
         return name;
     }
     @Override
 public String toString()
 {
     return name;
 }

    
}
