/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.business;

import Network.Network;
import Role.DeliveryManRole;
import Role.Role;
import business.Enterprise.BioFactory;
import business.Enterprise.DeliveryCompany;
import business.Enterprise.Enterprise;
import static business.Enterprise.Enterprise.EnterpriseType.DeliveryCompany;
import static business.Enterprise.Enterprise.EnterpriseType.Restaurant;
import business.Enterprise.Orphane;
import business.Enterprise.Restaurant;
import business.Enterprise.SuperMarket;
import business.Organization.DeliveryMenOrganization;
import business.Person.Person;
import business.UserAccount.UserAccount;

/**
 *
 * @author liuch
 */
public class ConfigureASystem {

    public static EcoSystem configure() {

        EcoSystem system = EcoSystem.getInstance();
        Person admin = system.getPerson();
        admin.setName("Chang");
        UserAccount ua = system.getUserAccount();
        ua.setPerson(admin);
        ua.setUsername("Chang");
        ua.setPassword("123");
        Network network = system.createAndAddNetwork("BackBay", "Chang", "BackBayAdmin", "123");
        network.addCustomer(system, "Chang", "Customer", "123");
        Restaurant r = (Restaurant) network.getEnterpriseDirectory().createAndAddEnterprise("Pho&Basil", Enterprise.EnterpriseType.Restaurant, "Chang", "Pho&Basil", "123");
        Boolean a = network.addCustomer(system, "Chang", "Customer", "123");
        UserAccount c = network.getUserList().getUserAccountList().get(0);
        c.AddAddress("Westland Ave", 02115, "8572507330");
        Restaurant r2 = (Restaurant) network.getEnterpriseDirectory().createAndAddEnterprise("PopEyes", Enterprise.EnterpriseType.Restaurant, "Chang", "PopEyes", "123");
        SuperMarket s = (SuperMarket) network.getEnterpriseDirectory().createAndAddEnterprise("Target", Enterprise.EnterpriseType.SuperMarket, "Chang", "Target", "123");
        SuperMarket star = (SuperMarket) network.getEnterpriseDirectory().createAndAddEnterprise("Star", Enterprise.EnterpriseType.SuperMarket, "Chang", "Star", "123");
        network.getEnterpriseDirectory().createAndAddEnterprise("BackBay Ophan", Enterprise.EnterpriseType.Orphane, "Chang", "Wen", "123");
        DeliveryCompany d = (DeliveryCompany) network.getEnterpriseDirectory().createAndAddEnterprise("DeliveryBackBay", Enterprise.EnterpriseType.DeliveryCompany, "Chang", "DeliveryAdmin", "123");
        DeliveryMenOrganization n = new DeliveryMenOrganization();
        Person p = n.getPersonDirectory().createPerson("Chang");
        n.getUserAccountDirectory().createUserAccount("DeliveryMan", "123", p, new DeliveryManRole());
        d.getOrganizationDirectory().getOrganizationList().add(n);

        return system;
    }

}
