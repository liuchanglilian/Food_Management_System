/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Person;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author liuch
 */
public class PersonDirectory implements Serializable{
     private ArrayList<Person> personList;
    private static final long serialVersionUID = 1L;
      
    public void setPersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }

  /*  public static long getSerialVersionUID() {
        return serialVersionUID;
    }*/

    public PersonDirectory() {
       personList = new ArrayList<>();
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }
    
    public Person createPerson(String name){
        Person p = new Person();
        p.setName(name);
        personList.add(p);
        return p;
    }
}
