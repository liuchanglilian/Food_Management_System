/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Organization;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author liuch
 */
public class EnterpriseLevelOrganizationDirectory implements Serializable {
    private ArrayList<EnterpriseLevelOrganization> enterpriseLevelOrganizationList;
 private static final long serialVersionUID = 708293001458546410L;

    public ArrayList<EnterpriseLevelOrganization> getEnterpriseLevelOrganizationList() {
        return enterpriseLevelOrganizationList;
    }

    public void setEnterpriseLevelOrganizationList(ArrayList<EnterpriseLevelOrganization> enterpriseLevelOrganizationList) {
        this.enterpriseLevelOrganizationList = enterpriseLevelOrganizationList;
    }
    public EnterpriseLevelOrganizationDirectory() {
        enterpriseLevelOrganizationList = new ArrayList<>();
    }
    public boolean checkEnterpriseLevelOrganizationDirectory(String userName)
    {
        for(EnterpriseLevelOrganization o:enterpriseLevelOrganizationList)
        {
            if(o.checkUserAccountDirectoryUserAccount(userName))
                return true;
            
        }
        return false;
    }

    public ArrayList<EnterpriseLevelOrganization> getOrganizationList() {
        return enterpriseLevelOrganizationList;
    }
    
    public EnterpriseLevelOrganization createOrganization(EnterpriseLevelOrganization.Type type){
        EnterpriseLevelOrganization organization = null;
        if (type.getValue().equals(EnterpriseLevelOrganization.Type.RestaurantWorkers.getValue())){
            organization = new RestaurantWorkersOrganization();
           enterpriseLevelOrganizationList.add(organization);
        }
        else if (type.getValue().equals(EnterpriseLevelOrganization.Type.DeliveryMen.getValue())){
            organization = new DeliveryMenOrganization();
          enterpriseLevelOrganizationList.add(organization);
        }
        return organization;
    }
}
