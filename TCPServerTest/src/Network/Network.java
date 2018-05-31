/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

import Role.CustomerRolse;
import Role.NetworkAdminRole;
import Role.Role;
import business.Enterprise.EnterpriseDirectory;
import business.Person.Person;
import business.Person.PersonDirectory;
import business.UserAccount.UserAccount;
import business.UserAccount.UserAccountDirectory;
import business.WorkQueue.WorkQueue;
import business.business.EcoSystem;
import java.io.Serializable;

/**
 *
 * @author liuch
 */
public class Network implements Serializable{
    
    private String name;
    private EnterpriseDirectory enterpriseDirectory;
    private PersonDirectory customerList;
    private UserAccountDirectory userList;
    private Person person;
    private UserAccount userAccount;
    private WorkQueue queueOphan;

  /* public static long getSerialVersionUID() {
        return serialVersionUID;
    }*/
    
 private static final long serialVersionUID = 1L;
      
    public void setEnterpriseDirectory(EnterpriseDirectory enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
    }
    public Network(String name,String personName,String userName,String password) {
        this.name = name;
        enterpriseDirectory = new EnterpriseDirectory();
        customerList = new PersonDirectory();
        userList = new UserAccountDirectory();
        person = new Person();
        person.setName(personName);
        userAccount = new UserAccount();
        queueOphan = new WorkQueue();
        userAccount.setPerson(person);
        userAccount.setUsername(userName);
        userAccount.setPassword(password);
        userAccount.setRole(new NetworkAdminRole());
    }

    public WorkQueue getQueueOphan() {
        return queueOphan;
    }

    public void setQueueOphan(WorkQueue queueOphan) {
        this.queueOphan = queueOphan;
    }
    
  public void setUser(String personName,String userName, String password)
  {
      person.setName(personName);
      userAccount.setPerson(person);
      userAccount.setUsername(userName);
      userAccount.setPassword(password);
      
  }

    public UserAccountDirectory getUserList() {
        return userList;
    }

    public void setUserList(UserAccountDirectory userList) {
        this.userList = userList;
    }
  

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
  public boolean checkNetworkUserNameExist(String userName)
  {
      if(userAccount.getUsername().equals(userName))
          return true;
      else
          return false;
  }
  public boolean checkNetworkUserlistExist(String userName)
  {
      for(UserAccount ua:userList.getUserAccountList())
      {
          if(ua.getUsername().equals(userName))
          {
              return true;
          }
      }
      return false;
  }
 public UserAccount authanticate(String name,String password)
    {
       return userAccount.checkAccount(name, password);
    }
    public PersonDirectory getCustomerList() {
        return customerList;
    }

    public void setCustomerList(PersonDirectory customerList) {
        this.customerList = customerList;
    }
    
    public boolean addCustomer(EcoSystem system,String personName,String userName,String password)
    {
        if(system.checkUsernameExist(userName))
            return false;
        Person person=customerList.createPerson(personName);
        userList.createUserAccount(userName, password,person,new CustomerRolse());
        return true;
    }
   
    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }


   
}
