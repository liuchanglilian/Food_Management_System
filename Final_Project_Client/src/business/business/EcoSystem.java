/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.business;

import Network.Network;
import Role.DeliveryComponyManagerRole;
import Role.Role;
import Role.SystemAdminRole;
import business.Enterprise.Enterprise;
import business.Organization.Organization;
import business.Person.Person;
import business.UserAccount.UserAccount;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author liuch
 */
public class EcoSystem extends Organization implements Serializable {

    private static EcoSystem business;
    private Person person;
    private UserAccount userAccount;
    private ArrayList<Network> networkList;
    private static final long serialVersionUID = 6529685098267757690L;

    private EcoSystem(Person person, UserAccount userAccount, ArrayList<Network> networkList, String name) {
        super(name);
        this.person = person;
        this.userAccount = userAccount;
        this.networkList = networkList;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }

    public static EcoSystem getBusiness() {
        return business;
    }

    public static void setBusiness(EcoSystem business) {
        EcoSystem.business = business;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static EcoSystem getInstance() {

        if (business == null) {
            business = new EcoSystem();
        }
        return business;
    }

    private EcoSystem() {
        super(null);
        networkList = new ArrayList<>();
        person = new Person();
        userAccount = new UserAccount();
        userAccount.setRole(new SystemAdminRole());
    }

    public Person getPerson() {
        return person;
    }

    public UserAccount authanticate(String name, String password) {
        return userAccount.checkAccount(name, password);
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public Network createAndAddNetwork(String name, String personName, String userName, String password) {
        Network network = new Network(name, personName, userName, password);
        networkList.add(network);
        return network;
    }

    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }

    public boolean checkEcosystemUser(String userName) {
        if (userAccount.getUsername().equals(userName)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkUsernameExist(String userName) {
        boolean checkSystem = checkEcosystemUser(userName);
        if (checkSystem) {
            return true;
        }
        for (Network network : getNetworkList()) {
            boolean checkNetUser = network.checkNetworkUserNameExist(userName);
            if (checkNetUser) {
                return true;
            }
            boolean checkNetCustomer = network.checkNetworkUserlistExist(userName);
            if (checkNetCustomer) {
                return true;
            }
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                boolean checkEnterprise = enterprise.checkEnterPriseUserName(userName);
                if (checkEnterprise) {
                    return true;
                }
                boolean checkOrganizationInEnterprise = enterprise.checkEnterpriseOrganizationList(userName);
                if (checkOrganizationInEnterprise) {
                    return true;
                }
            }
        }
        return false;
    }

}
