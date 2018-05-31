/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Enterprise;

import Food.FoodServe;
import Role.RestaurantManagerRole;
import Role.SupermarketManagerRole;
import business.Organization.Organization;
import business.Organization.RestaurantWorkersOrganization;
import business.Person.Person;
import business.UserAccount.UserAccount;
import business.WorkQueue.WorkQueue;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author liuch
 */
public class SuperMarket extends Enterprise implements Serializable{
    private WorkQueue queueOphan;
   // private ArrayList<FoodServe> unfreshfoodList;
    private WorkQueue foodOrderqueue;
    private transient Connection con;
   private static final long serialVersionUID = 1L;

  /*  public static long getSerialVersionUID() {
        return serialVersionUID;
    }*/
      
    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public SuperMarket(String name,String personName,String userName,String password) {
      
        super(name, Enterprise.EnterpriseType.SuperMarket,personName,userName,password);
        super.userAccount.setRole(new SupermarketManagerRole());
        this.queueOphan = new WorkQueue();
//        this.unfreshfoodList = new ArrayList<FoodServe>();
        this.foodOrderqueue = new WorkQueue();
        createTable();
    }
    public void getConnection() throws SQLException

     {
      String DB_URL = "jdbc:mysql://35.185.14.219:3306/new_schema";
      String DB_DRV =  "com.mysql.jdbc.Driver";
      String DB_USER = "root";
      String DB_PASSWD = "8466";
      con=DriverManager.getConnection (DB_URL,DB_USER,DB_PASSWD);
      
 }
     public void createTable()
 {
        try {
            getConnection();
            String query1 =   "CREATE TABLE IF NOT EXISTS new_schema.`"+userAccount.getUsername()+"`(`id` INT NOT NULL AUTO_INCREMENT,`Name` VARCHAR(45) NULL DEFAULT NULL,`calorie` INT NULL DEFAULT NULL,`Price` DOUBLE NULL DEFAULT NULL,`pic` LONGBLOB NULL DEFAULT NULL,`discount` DOUBLE NULL DEFAULT 0,`inventory` INT NULL DEFAULT 0,`saleHistory` INT NULL DEFAULT 0,PRIMARY KEY (`id`));";
            Statement st = (Statement)con.createStatement();
           st.executeUpdate(query1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex);
        }

 }

    public WorkQueue getQueueOphan() {
        return queueOphan;
    }

    public void setQueueOphan(WorkQueue queueOphan) {
        this.queueOphan = queueOphan;
    }

   /* public ArrayList<FoodServe> getUnfreshfoodList() {
        return unfreshfoodList;
    }

    public void setUnfreshfoodList(ArrayList<FoodServe> unfreshfoodList) {
        this.unfreshfoodList = unfreshfoodList;
    }
*/
    public WorkQueue getFoodOrderqueue() {
        return foodOrderqueue;
    }

    public void setFoodOrderqueue(WorkQueue foodOrderqueue) {
        this.foodOrderqueue = foodOrderqueue;
    }
     
     /*  public void addToUnfreshList(ArrayList<FoodServe> foodList)
  {
    
       unfreshfoodList.addAll(foodList);
  }*/
    @Override
    public ArrayList<Organization> getSupportedOrganization()
    {
        return null;
    }
     public UserAccount authanticate(String name,String password)
    {
       return userAccount.checkAccount(name, password);
    }
}
