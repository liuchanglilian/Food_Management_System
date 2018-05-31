/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Organization;

import Role.Role;
import business.Person.PersonDirectory;
import business.UserAccount.UserAccountDirectory;
import business.WorkQueue.WorkQueue;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author liuch
 */
public abstract class EnterpriseLevelOrganization extends Organization implements Serializable{
    private String name;
    private WorkQueue workQueue;
    private PersonDirectory personDirectory;
    private UserAccountDirectory userAccountDirectory;
   private static final long  serialVersionUID = 708293001458546410L;
     public EnterpriseLevelOrganization(String name) {
        super(name);
        personDirectory=new PersonDirectory();
        userAccountDirectory=new UserAccountDirectory();
        workQueue = new WorkQueue();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
     public boolean checkUserAccountDirectoryUserAccount(String userName)
     {
         
        boolean uniq= userAccountDirectory.checkIfUsernameIsUnique(userName);
        if(uniq)
            return false;
        else
            return true;
     }
      public enum Type implements Serializable{
        RestaurantWorkers("RestaurantWorkers"),DeliveryMen("DeliveryMen");
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    public void setPersonDirectory(PersonDirectory personDirectory) {
        this.personDirectory = personDirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public void setUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    
     public abstract ArrayList<Role> getSupportedRole();
}
