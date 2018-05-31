/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Organization;

import Role.DeliveryManRole;
import Role.Role;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author liuch
 */
public class DeliveryMenOrganization extends EnterpriseLevelOrganization implements Serializable {
     private static final long serialVersionUID = 1L;

   
      
    public DeliveryMenOrganization() {
        super(EnterpriseLevelOrganization.Type.DeliveryMen.getValue());
    }

  

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new DeliveryManRole());
        return roles;
    }
}
