/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.UserAccount;

import Address.Address;
import Role.Role;
import business.Person.Person;
import business.WorkQueue.WorkQueue;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author liuch
 */
public class UserAccount implements Serializable{
     private String username;
    private String password;
    private Person person;
    private Role role;
    private WorkQueue workQueue;
    private WorkQueue theOrderIsentoutQueue;
    ArrayList<Address> addressList;
   private static final long serialVersionUID = 1L;

   /* public static long getSerialVersionUID() {
        return serialVersionUID;
    }*/

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }
      
    public ArrayList<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(ArrayList<Address> addressList) {
        this.addressList = addressList;
    }
    
    public UserAccount() {
        workQueue = new WorkQueue();
         theOrderIsentoutQueue = new WorkQueue();
        addressList = new ArrayList<>();
    }

    public WorkQueue getTheOrderIsentoutQueue() {
        return theOrderIsentoutQueue;
    }

    public void setTheOrderIsentoutQueue(WorkQueue theOrderIsentoutQueue) {
        this.theOrderIsentoutQueue = theOrderIsentoutQueue;
    }
    
   

    public ArrayList<Address> getAddress() {
        return addressList;
    }

    public void AddAddress(String address, long zipcode, String telephoneNumber) {
        Address a = new Address();
       a.setAddressLine(address);
       a.setZipCode(zipcode);
      a.setTelephoneNumber(telephoneNumber);
        addressList.add(a);
    }
    
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Person getPerson() {
        return person;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }
  public UserAccount checkAccount(String name,String password)
  {
      if((this.username.equals(name))&&(this.password.equals(password)))
          return this;
      else
          return null;
  }
    
    
    @Override
    public String toString() {
        return username;
    }
    
    
    
}
