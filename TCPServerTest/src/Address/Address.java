/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Address;

import java.io.Serializable;

/**
 *
 * @author liuch
 */

    public class Address implements Serializable{
       private String addressLine;
       private long zipCode;
       private String telephoneNumber;
       private static final long serialVersionUID = 1L;
       @Override
       
       public String toString()
       {
           return addressLine;
       }

   /*public static long getSerialVersionUID() {
        return serialVersionUID;
    }*/
    
    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public long getZipCode() {
        return zipCode;
    }

    public void setZipCode(long zipCode) {
        this.zipCode = zipCode;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
       
    }

