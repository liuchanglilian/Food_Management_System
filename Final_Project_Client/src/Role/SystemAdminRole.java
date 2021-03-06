/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Role;

import Interface.SystemAdmin.SystemAdminWorkArea;
import Network.Network;
import business.Enterprise.Enterprise;
import business.Organization.Organization;
import business.UserAccount.UserAccount;
import business.business.EcoSystem;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.JPanel;

/**
 *
 * @author liuch
 */
public class SystemAdminRole extends Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @Override

    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Network network, Enterprise enterprise, Organization organization, EcoSystem system, ObjectOutputStream streamOut) {
        return new SystemAdminWorkArea(userProcessContainer, system, streamOut);
    }
}
