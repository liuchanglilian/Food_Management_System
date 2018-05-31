/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Role;

import Network.Network;
import business.Enterprise.Enterprise;
import business.Organization.Organization;
import business.UserAccount.UserAccount;
import business.business.EcoSystem;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.JPanel;
import userInterface.BiofactoryManager.BiofactoryManagerWorkArea;

/**
 *
 * @author liuch
 */
public class BiofactoryManagerRole extends Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Network network, Enterprise enterprise, Organization organization, EcoSystem business, ObjectOutputStream streamOut) {
        return new BiofactoryManagerWorkArea(business, userProcessContainer, account, enterprise, streamOut);
    }
}
