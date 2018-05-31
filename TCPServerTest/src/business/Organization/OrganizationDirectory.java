/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Organization;

import business.Organization.EnterpriseLevelOrganization.Type;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author liuch
 */
public class OrganizationDirectory implements Serializable{
    
    private ArrayList<Organization> organizationList;
    private static final long serialVersionUID = 1L;

  /*  public static long getSerialVersionUID() {
        return serialVersionUID;
    }*/

    public void setOrganizationList(ArrayList<Organization> organizationList) {
        this.organizationList = organizationList;
    }
      
    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.RestaurantWorkers.getValue())){
            organization = new RestaurantWorkersOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.DeliveryMen.getValue())){
            organization = new DeliveryMenOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
}