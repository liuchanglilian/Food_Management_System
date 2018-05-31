/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Enterprise;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author liuch
 */
public class EnterpriseDirectory implements Serializable {
    
    private ArrayList<Enterprise> enterpriseList;
   private static final long serialVersionUID = 1L;

  /*  public static long getSerialVersionUID() {
        return serialVersionUID;
    }*/
      
    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }

    public EnterpriseDirectory() {
        enterpriseList = new ArrayList<>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }
    
    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType type,String personName,String userName,String password){
        Enterprise enterprise = null;
        if (type == Enterprise.EnterpriseType.Biofactory){
            enterprise = new BioFactory(name,personName,userName,password);
            enterpriseList.add(enterprise);
        }
          if (type == Enterprise.EnterpriseType.DeliveryCompany){
            enterprise = new DeliveryCompany(name,personName,userName,password);
            enterpriseList.add(enterprise);
        }
            if (type == Enterprise.EnterpriseType.Orphane){
            enterprise = new Orphane(name,personName,userName,password);
            enterpriseList.add(enterprise);
        }
       if (type == Enterprise.EnterpriseType.Restaurant){
            enterprise = new Restaurant(name,personName,userName,password);
            enterpriseList.add(enterprise);
        }
       if (type == Enterprise.EnterpriseType.SuperMarket){
            enterprise = new SuperMarket(name,personName,userName,password);
            enterpriseList.add(enterprise);
        }
        return enterprise;
    }
}
    
