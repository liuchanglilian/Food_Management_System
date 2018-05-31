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

/**
 *
 * @author liuch
 */
public abstract class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    public enum RoleType implements Serializable {

        RestaurantManager("RestaurantManager"),
        RestaurantWorker("RestaurantWorker"),
        Customer("Customer"),
        SupermarketManager("SupermarketManager"),
        OrphaneManager("OrphaneManager"),
        DeliveryComponyManager("DeliveryComponyManager"),
        DeliveryMan("DeliveryMan"),
        BiofactoryManager("BiofactoryManager");

        private String value;
        private static final long serialVersionUID = 1L;

        public static long getSerialVersionUID() {
            return serialVersionUID;
        }

        private RoleType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public abstract JPanel createWorkArea(JPanel userProcessContainer,
            UserAccount account,
            Network network,
            Enterprise enterprise,
            Organization organization,
            EcoSystem business, ObjectOutputStream streamOut);

    @Override
    public String toString() {
        return this.getClass().getName();
    }

}
